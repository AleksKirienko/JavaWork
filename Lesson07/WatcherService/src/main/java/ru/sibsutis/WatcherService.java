package ru.sibsutis;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class WatcherService {
    public static void main(String[] args) throws IOException {
        Path tmp = Path.of("example.txt");
        //FileWriter fw = new FileWriter(tmp.get);

        //System.out.println(Files.exists(tmp));
        Files.write(tmp, "Hello".getBytes());

        System.out.println(Files.isReadable(tmp));
        System.out.println(Files.isWritable(tmp));
        System.out.println(Files.isExecutable(tmp)); //исполняемый/запуск
        System.out.println("Directory = " + Files.isDirectory(tmp));
        System.out.println("RegFile = " + Files.isRegularFile(tmp));
        System.out.println("Hidden = " +  Files.isHidden(tmp));

        //Files.delete(tmp);
        //Files.exists(tmp);
        // System.out.println(Files.exists(tmp));

        Path tmp1 = Path.of("example1.txt");
        Files.copy(tmp, tmp1, StandardCopyOption.REPLACE_EXISTING); //флаг позволяет при копировании изменить/оставить итд

        Path tmp2 = Path.of("example2.txt");
        Files.move(tmp1, tmp2, StandardCopyOption.REPLACE_EXISTING);

    }
}
