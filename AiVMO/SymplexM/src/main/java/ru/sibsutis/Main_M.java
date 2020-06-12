package ru.sibsutis;

import java.util.Scanner;

class Main_M {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Mathematics calculate = new Mathematics();
        Fraction tmp = new Fraction();

        int n, m;
        n = scan.nextInt();
        m = scan.nextInt();
        int a;
        Fraction[][] arr = new Fraction[m][n + 1 + m];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                a = scan.nextInt();
                arr[i][j] = new Fraction(a);
            }
            a = scan.nextInt();
            arr[i][n + m] = new Fraction(a);
        }

        for (int i = 0; i < m; i++) {
            for (int j = n; j < n + m; j++) {
                a = 0;
                if (i == j - n) {
                    a = 1;
                }
                arr[i][j] = new Fraction(a);
            }
        }

        Fraction[] co = new Fraction[m];
        Fraction[] z = new Fraction[n + 1 + m];
        Fraction[] mM = new Fraction[n + m + 1];

        for (int i = 0; i < n; i++) {
            a = scan.nextInt();
            z[i] = new Fraction(a);
        }

        a = scan.nextInt();
        z[n + m] = new Fraction(a);

        for (int i = n; i < n + m; i++) {
            z[i] = new Fraction(0);
        }

        for (int i = 0; i < n; i++) {
            a = 0;
            for (int j = 0; j < m; j++) {
                a += arr[j][i].getNumerator();
            }
            a *= (-1);
            mM[i] = new Fraction(a);
        }

        a = 0;
        for (int j = 0; j < m; j++) {
            a += arr[j][n + m].getNumerator();
        }
        mM[n + m] = new Fraction(a);

        for (int i = n; i < n + m; i++) {
            mM[i] = new Fraction(0);
        }

        int index = -2;

        do {
            if (index != -2) {
                for (int i = 0; i < m; i++) {
                    co[i] = tmp.div(arr[i][n + m], arr[i][index]);
                }

                Fraction cMin = new Fraction(999);
                int icMin = 0;
                for (int i = 0; i < m; i++) {
                    if (tmp.compare(co[i], cMin) == -1 && tmp.compare(co[i], new Fraction(0)) == 1) {
                        cMin = co[i];
                        icMin = i;
                    }
                }
                System.out.println(icMin + " " + index);
                arr = calculate.Simplex(arr, n, m, icMin, index);
                z = calculate.SimplexZ(arr, n, m, icMin, index, z);
                mM = calculate.SimplexM(arr, n, m, icMin, index, mM);
            }

            for (int i = 0; i < m; i++) {
                tmp.print(arr[i][n + m]);
                for (int j = 0; j < n + m; j++) {
                    tmp.print(arr[i][j]);
                }
                System.out.println(" ");
            }
            tmp.print(z[n + m]);
            for (int j = 0; j < n + m; j++) {
                tmp.print(z[j]);
            }

            System.out.print("\n");

            tmp.print(mM[n + m]);
            for (int j = 0; j < n + m; j++) {
                tmp.print(mM[j]);
            }

            System.out.println("\n");

            index = calculate.minM(mM, n, m);

        } while (!(calculate.checkM(mM, n)));

        int flag = 0;

        do {
            for (int i = 0; i < m; i++) {
                co[i] = tmp.div(arr[i][n + m], arr[i][index]);
            }

            Fraction cMin = new Fraction(999);
            int icMin = 0;
            for (int i = 0; i < m; i++) {
                if (tmp.compare(co[i], cMin) == -1 && tmp.compare(co[i], new Fraction(0)) == 1) {
                    cMin = co[i];
                    icMin = i;
                }
            }
            System.out.println(icMin + " " + index);
            arr = calculate.Simplex(arr, n, m, icMin, index);
            z = calculate.SimplexZ(arr, n, m, icMin, index, z);

            //if (flag == 1) {
            for (int i = 0; i < m; i++) {
                tmp.print(arr[i][n + m]);
                for (int j = 0; j < n + m; j++) {
                    tmp.print(arr[i][j]);
                }
                System.out.println(" ");
            }
            tmp.print(z[n + m]);
            for (int j = 0; j < n + m; j++) {
                tmp.print(z[j]);
            }
            //}
            index = calculate.minZ(z, n);
            System.out.println("\n");
            flag = 1;
        } while (!(calculate.checkZ(z, n, m)));

        System.out.print("Zmin = " + -z[n + m].getNumerator());
    }
}