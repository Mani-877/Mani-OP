import java.io.*;
import java.util.*;

public class Solution {

    public static String twoStrings(String s1, String s2) {

        boolean[] seen = new boolean[26];

        for (char c : s1.toCharArray()) {
            seen[c - 'a'] = true;
        }

        for (char c : s2.toCharArray()) {
            if (seen[c - 'a']) {
                return "YES";
            }
        }

        return "NO";
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {

            String s1 = br.readLine().trim();
            String s2 = br.readLine().trim();

            System.out.println(twoStrings(s1, s2));
        }
    }
}

output
2
hello
world
hi
world

YES
NO
