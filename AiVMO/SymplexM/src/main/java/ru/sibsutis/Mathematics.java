package ru.sibsutis;

class Mathematics {

    public int minM(Fraction[] M, int n, int m) {
        Fraction min = new Fraction(999);
        Fraction tmp = new Fraction();
        int imin = 0;
        for (int i = 0; i < m + n; i++) {
            if (tmp.compare(M[i], min) == -1) {
                min = M[i];
                imin = i;
            }
        }
        return imin;
    }

    public int minZ(Fraction[] Z, int n) {
        Fraction min = new Fraction(0);
        Fraction tmp = new Fraction();
        int iminz = 0;
        for (int i = 0; i < n; i++) {
            if (tmp.compare(Z[i], min) == -1) {
                min = Z[i];
                iminz = i;
            }
        }
        return iminz;
    }

    public Fraction[][] Simplex(Fraction[][] arr, int n, int m, int icMin, int jb) {
        Fraction[][] result = new Fraction[m][n + 1 + m];
        Fraction tmp = new Fraction();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n + 1 + m; j++) {
                if (i == icMin) {
                    result[i][j] = tmp.div(arr[i][j], arr[icMin][jb]);
                } else {
                    result[i][j] = tmp.sub(arr[i][j], tmp.div(tmp.mul(arr[icMin][j], arr[i][jb]), arr[icMin][jb]));
                }
            }
        }

        return result;
    }

    public Fraction[] SimplexZ(Fraction[][] arr, int n, int m, int ib, int jb, Fraction[] z) {
        Fraction[] result = new Fraction[n + 1 + m];
        Fraction tmp = new Fraction();
        for (int j = 0; j < n + 1 + m; j++) {
            result[j] = tmp.sub(z[j], tmp.div(tmp.mul(arr[ib][j], z[jb]), arr[ib][jb]));
        }
        return result;
    }

    public Fraction[] SimplexM(Fraction[][] arr, int n, int m, int ib, int jb, Fraction[] z) {
        Fraction[] result = new Fraction[n + 1 + m];
        Fraction tmp = new Fraction();
        for (int j = 0; j < n + m; j++) {
            result[j] = tmp.sub(z[j], tmp.div(tmp.mul(arr[ib][j], z[jb]), arr[ib][jb]));
        }
        result[n + m] = tmp.sub(z[n + m], tmp.div(tmp.mul(arr[ib][n + m], z[jb]), arr[ib][jb]));
        return result;
    }

    public boolean checkM(Fraction[] M, int n) {
        for (int i = 0; i < n; i++) {
            if (M[i].getNumerator() != 0) {
                return false;
            }
        }
        return true;
    }

    public boolean checkZ(Fraction[] Z, int n, int m) {
        for (int i = 0; i < n; i++) {
            if (Z[i].getNumerator() < 0) {
                return false;
            }
        }
        return true;
    }
}