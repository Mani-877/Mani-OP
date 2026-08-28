import java.io.*;
import java.util.*;

public class Solution {

    public static int birthday(List<Integer> s, int d, int m) {
        int count = 0;
        int sum = 0;

        // First window
        for (int i = 0; i < m; i++) {
            sum += s.get(i);
        }

        if (sum == d) {
            count++;
        }

        // Slide the window
        for (int i = m; i < s.size(); i++) {
            sum += s.get(i);
            sum -= s.get(i - m);

            if (sum == d) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());

        String[] arr = br.readLine().trim().split(" ");
        List<Integer> s = new ArrayList<>();

        for (String x : arr) {
            s.add(Integer.parseInt(x));
        }

        String[] dm = br.readLine().trim().split(" ");
        int d = Integer.parseInt(dm[0]);
        int m = Integer.parseInt(dm[1]);

        int result = birthday(s, d, m);

        System.out.println(result);
    }
}

output

5
1 2 1 3 2
3 2

2
