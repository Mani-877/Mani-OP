import java.io.*;
import java.util.*;

public class Solution {

    static int[] p;
    static int[][] st;
    static int[] log;

    static void manacher(String s) {
        int n = s.length();

        char[] t = new char[2 * n + 1];

        for (int i = 0; i < t.length; i++) {
            t[i] = (i % 2 == 0) ? '#' : s.charAt(i / 2);
        }

        p = new int[t.length];

        int center = 0;
        int right = 0;

        for (int i = 0; i < t.length; i++) {

            int mirror = 2 * center - i;

            if (i < right) {
                p[i] = Math.min(right - i, p[mirror]);
            }

            while (i - p[i] - 1 >= 0 &&
                   i + p[i] + 1 < t.length &&
                   t[i - p[i] - 1] == t[i + p[i] + 1]) {
                p[i]++;
            }

            if (i + p[i] > right) {
                center = i;
                right = i + p[i];
            }
        }
    }

    static void buildRMQ() {

        int n = p.length;

        log = new int[n + 1];

        for (int i = 2; i <= n; i++) {
            log[i] = log[i / 2] + 1;
        }

        int k = log[n] + 1;

        st = new int[k][n];

        System.arraycopy(p, 0, st[0], 0, n);

        for (int j = 1; j < k; j++) {

            int len = 1 << j;
            int half = len >> 1;

            for (int i = 0; i + len <= n; i++) {
                st[j][i] = Math.max(
                    st[j - 1][i],
                    st[j - 1][i + half]
                );
            }
        }
    }

    static int query(int l, int r) {

        if (l > r) {
            return 0;
        }

        int len = r - l + 1;
        int k = log[len];

        return Math.max(
            st[k][l],
            st[k][r - (1 << k) + 1]
        );
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());
        String s = br.readLine().trim();

        String doubled = s + s;

        manacher(doubled);
        buildRMQ();

        StringBuilder ans = new StringBuilder();

        for (int rotation = 0; rotation < n; rotation++) {

            /*
             * Character positions in transformed string.
             *
             * Rotation covers characters:
             * rotation ... rotation+n-1
             */
            int L = 2 * rotation + 1;
            int R = 2 * (rotation + n - 1) + 1;

            int low = 1;
            int high = n;
            int best = 1;

            while (low <= high) {

                int len = (low + high) >>> 1;

                /*
                 * A palindrome of length len must have
                 * a center inside this range.
                 */
                int cl = L + len - 1;
                int cr = R - len + 1;

                if (cl <= cr && query(cl, cr) >= len) {
                    best = len;
                    low = len + 1;
                } else {
                    high = len - 1;
                }
            }

            ans.append(best).append('\n');
        }

        System.out.print(ans);
    }
}

output

13
aaaaabbbbaaaa

12
12
10
8
8
9
11
13
11
9
8
8
10
