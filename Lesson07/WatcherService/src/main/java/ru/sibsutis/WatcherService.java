package ru.sibsutis;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.FileTime;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;

public class WatcherService {
    public static void main(String[] args) throws IOException, InterruptedException {
        Path tmp = Path.of("example.txt");
        //FileWriter fw = new FileWriter(tmp.get);

        //System.out.println(Files.exists(tmp));
        //Files.write(tmp, "Hello".getBytes());
        //Files.writeString(tmp, "Hello1", StandardOpenOption.APPEND);

        //System.out.println(Files.isReadable(tmp));
        //System.out.println(Files.isWritable(tmp));
        //System.out.println(Files.isExecutable(tmp)); //исполняемый/запуск
        //System.out.println("Directory = " + Files.isDirectory(tmp));
        //System.out.println("RegFile = " + Files.isRegularFile(tmp));
        //System.out.println("Hidden = " + Files.isHidden(tmp));


        Files.write(tmp, ("Directory = " + Files.isDirectory(tmp) + " " +
                "\nRegFile = " + Files.isRegularFile(tmp) +
                "\nHidden = " + Files.isHidden(tmp)).getBytes());

        //Files.delete(tmp);
        //Files.exists(tmp);
        //System.out.println(Files.exists(tmp));

        Path tmp1 = Path.of("example1.txt");
        Files.copy(tmp, tmp1, StandardCopyOption.REPLACE_EXISTING); //флаг позволяет при копировании изменить/оставить итд

        Path tmp2 = Path.of("example2.txt");
        Files.move(tmp1, tmp2, StandardCopyOption.REPLACE_EXISTING);


        //Считывание
        List<String> strs = Files.readAllLines(tmp2);
        for (String str : strs) {
            System.out.println(str);
        }

        //inotify
        //отслеживание некоторых событий на файловой системе
        WatchService watchService = FileSystems.getDefault().newWatchService();

        //"." - указатель на текущую дир.
        WatchKey key = Path.of(".").register(watchService, ENTRY_CREATE,
                ENTRY_MODIFY, StandardWatchEventKinds.ENTRY_DELETE);

        FileTime fileTime;
        while ((key = watchService.take()) != null) {
            for (WatchEvent<?> event : key.pollEvents()) { //получить все события
                //System.out.println(event.context()); //о каком фале идет речь context()
                //System.out.println(event.kind().name()); //какое саобытие произошло

                fileTime = Files.getLastModifiedTime(tmp);
                Files.write(tmp, ("Directory = " + Files.isDirectory(tmp) + " " +
                        "\nRegFile = " + Files.isRegularFile(tmp) +
                        "\nHidden = " + Files.isHidden(tmp) +
                        "\n" + fileTime).getBytes());

                System.out.println("Event kind : " + event.kind().name() + " - File : " + event.context());
                printFileTime(fileTime);

            }
        }
        /*try {
            fileTime = Files.getLastModifiedTime(tmp);
            printFileTime(fileTime);
        } catch (IOException e) {
            System.err.println("Cannot get the last modified time - " + e);
        }*/
    }

    private static void printFileTime(FileTime fileTime) {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy - hh:mm:ss");
        System.out.println(dateFormat.format(fileTime.toMillis()));
    }
}
