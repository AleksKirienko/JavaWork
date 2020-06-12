package ru.sibsutis;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n, m;
        n = scan.nextInt();
        m = scan.nextInt();

        int[][] c = new int[n][m];  //матрица тарифов
        int[][] x = new int[n][m];  //матрица перевозок

        int[] a = new int[n]; //Запасы
        int[] b = new int[m]; //Потребности

        int s = 0, s1 = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                c[i][j] = scan.nextInt();
                System.out.print(c[i][j] + "\t");
                x[i][j] = 0;
            }
            a[i] = scan.nextInt();
            System.out.print(a[i] + "\n");
            s += a[i];
        }

        for (int j = 0; j < m; j++) {
            b[j] = scan.nextInt();
            System.out.print(b[j] + "\t");
            s1 += b[j];
        }
        System.out.println("\n");

        s = s1 - s;

        Mathematics calculate = new Mathematics();

        while (!calculate.check(a, b, n, m, s)) {

            Pair pair = calculate.min(c, x, n, m);

            if (a[pair.first] < b[pair.second]) {
                x[pair.first][pair.second] = a[pair.first];
                b[pair.second] -= a[pair.first];
                a[pair.first] = 0;
                for (int i = 0; i < m; i++) {
                    if (x[pair.first][i] == 0) {
                        x[pair.first][i] = -1;
                    }
                }
            } else if (a[pair.first] > b[pair.second]) {
                x[pair.first][pair.second] = b[pair.second];
                a[pair.first] -= b[pair.second];
                b[pair.second] = 0;
                for (int i = 0; i < n; i++) {
                    if (x[i][pair.second] == 0) {
                        x[i][pair.second] = -1;
                    }
                }
            } else {
                x[pair.first][pair.second] = b[pair.second];
                a[pair.first] = 0;
                b[pair.second] = 0;
                for (int i = 0; i < n; i++) {
                    if (x[i][pair.second] == 0) {
                        x[i][pair.second] = -1;
                    }
                }
                for (int i = 0; i < m; i++) {
                    if (x[pair.first][i] == 0) {
                        x[pair.first][i] = -1;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(c[i][j] + "[" + x[i][j] + "]" + "\t");
            }
            System.out.println(" ");
        }
        System.out.print("\n");
        System.out.print("Z = " + calculate.calcZ(c, x, n, m));
    }
}