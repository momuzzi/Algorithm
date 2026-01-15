import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][3];

        for (int i = 0; i < N; i++) {
            String[] rgb = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(rgb[0]);
            arr[i][1] = Integer.parseInt(rgb[1]);
            arr[i][2] = Integer.parseInt(rgb[2]);
        }

        int[][] rdp = new int[N][3];
        for (int i = 0; i < N; i++) {
            Arrays.fill(rdp[i], Integer.MAX_VALUE);
        }
        rdp[0][0] = arr[0][0];

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < 3; j++) {

                if (i < N - 1 && j == 0) {
                    if (rdp[i - 1][1] != Integer.MAX_VALUE || rdp[i - 1][2] != Integer.MAX_VALUE) {
                        rdp[i][j] = Math.min(rdp[i - 1][1], rdp[i - 1][2]) + arr[i][j];
                    }
                }

                if (j == 1) {
                    if (rdp[i - 1][0] != Integer.MAX_VALUE || rdp[i - 1][2] != Integer.MAX_VALUE) {
                        rdp[i][j] = Math.min(rdp[i - 1][0], rdp[i - 1][2]) + arr[i][j];
                    }
                }

                if (j == 2) {
                    if (rdp[i - 1][0] != Integer.MAX_VALUE || rdp[i - 1][1] != Integer.MAX_VALUE) {
                        rdp[i][j] = Math.min(rdp[i - 1][0], rdp[i - 1][1]) + arr[i][j];
                    }
                }
            }
        }

        int[][] gdp = new int[N][3];
        for (int i = 0; i < N; i++) {
            Arrays.fill(gdp[i], Integer.MAX_VALUE);
        }
        gdp[0][1] = arr[0][1];

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 0) {
                    if (gdp[i - 1][1] != Integer.MAX_VALUE || gdp[i - 1][2] != Integer.MAX_VALUE) {
                        gdp[i][j] = Math.min(gdp[i - 1][1], gdp[i - 1][2]) + arr[i][j];
                    }
                }

                if (i < N - 1 && j == 1) {
                    if (gdp[i - 1][0] != Integer.MAX_VALUE || gdp[i - 1][2] != Integer.MAX_VALUE) {
                        gdp[i][j] = Math.min(gdp[i - 1][0], gdp[i - 1][2]) + arr[i][j];
                    }
                }

                if (j == 2) {
                    if (gdp[i - 1][0] != Integer.MAX_VALUE || gdp[i - 1][1] != Integer.MAX_VALUE) {
                        gdp[i][j] = Math.min(gdp[i - 1][0], gdp[i - 1][1]) + arr[i][j];
                    }
                }
            }
        }

        int[][] bdp = new int[N][3];
        for (int i = 0; i < N; i++) {
            Arrays.fill(bdp[i], Integer.MAX_VALUE);
        }
        bdp[0][2] = arr[0][2];

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 0) {
                    if (bdp[i - 1][1] != Integer.MAX_VALUE || bdp[i - 1][2] != Integer.MAX_VALUE) {
                        bdp[i][j] = Math.min(bdp[i - 1][1], bdp[i - 1][2]) + arr[i][j];
                    }
                }

                if (j == 1) {
                    if (bdp[i - 1][0] != Integer.MAX_VALUE || bdp[i - 1][2] != Integer.MAX_VALUE) {
                        bdp[i][j] = Math.min(bdp[i - 1][0], bdp[i - 1][2]) + arr[i][j];
                    }
                }

                if (i < N - 1 && j == 2) {
                    if (bdp[i - 1][0] != Integer.MAX_VALUE || bdp[i - 1][1] != Integer.MAX_VALUE) {
                        bdp[i][j] = Math.min(bdp[i - 1][0], bdp[i - 1][1]) + arr[i][j];
                    }
                }
            }
        }

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < 3; i++) {
            min = Math.min(min, rdp[N - 1][i]);
        }

        for (int i = 0; i < 3; i++) {
            min = Math.min(min, gdp[N - 1][i]);
        }

        for (int i = 0; i < 3; i++) {
            min = Math.min(min, bdp[N - 1][i]);
        }

        System.out.print(min);
    }
}