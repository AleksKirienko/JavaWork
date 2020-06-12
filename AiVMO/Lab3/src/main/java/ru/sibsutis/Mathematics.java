package ru.sibsutis;

class Mathematics {

    public Pair min(int[][] c, int[][] x, int n, int m) {
        int min1, min2;
        int imin1 = 0, jmin1 = 0, imin2 = 0;
        int maxkoef = 0, imax = 0, jmax = 0;
        for (int i = 0; i < n; i++) {
            min1 = 999;
            min2 = 999;
            for (int j = 0; j < m; j++) {
                if (c[i][j] < min1 && x[i][j] == 0) {
                    min2 = min1;
                    imin2 = imin1;

                    min1 = c[i][j];
                    imin1 = i;
                    jmin1 = j;

                } else if (c[i][j] < min2 && x[i][j] == 0) {
                    min2 = c[i][j];
                    imin2 = i;
                }
            }
            if (min1 != 999) {
                if (min2 == 999 && maxkoef == 0) {
                    imax = imin1;
                    jmax = jmin1;
                } else {
                    if (maxkoef < min2 - min1) {
                        maxkoef = min2 - min1;
                        imax = imin1;
                        jmax = jmin1;
                    } else if (maxkoef == min2 - min1 && c[imax][jmax] > c[imin1][imin2]) {
                        maxkoef = min2 - min1;
                        imax = imin1;
                        jmax = jmin1;
                    }
                }
            }
        }

        for (int j = 0; j < m; j++) {
            min1 = 999;
            min2 = 999;
            for (int i = 0; i < n; i++) {
                if (c[i][j] < min1 && x[i][j] == 0) {
                    min2 = min1;
                    imin2 = imin1;

                    min1 = c[i][j];
                    imin1 = i;
                    jmin1 = j;

                } else if (c[i][j] < min2 && x[i][j] == 0) {
                    min2 = c[i][j];
                    imin2 = i;
                }
            }
            if (min1 != 999) {
                if (min2 == 999 && maxkoef == 0) {
                    imax = imin1;
                    jmax = jmin1;
                } else {
                    if (maxkoef < min2 - min1) {
                        maxkoef = min2 - min1;
                        imax = imin1;
                        jmax = jmin1;
                    } else if (maxkoef == min2 - min1 && c[imax][jmax] > c[imin1][imin2]) {
                        maxkoef = min2 - min1;
                        imax = imin1;
                        jmax = jmin1;
                    }
                }
            }
        }
        return new Pair(imax, jmax);
    }

    public boolean check(int[] a, int[] b, int n, int m, int s) {
        int s1 = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] > 0) return false;
        }

        for (int i = 0; i < m; i++) {
            if (b[i] > 0) s1 += b[i];
        }
        if (s == s1) return true;
        return false;
    }

    public int calcZ(int[][] c, int[][] x, int n, int m) {
        int z = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (x[i][j] != -1) {
                    z += c[i][j] * x[i][j];
                }
            }
        }
        return z;
    }
}