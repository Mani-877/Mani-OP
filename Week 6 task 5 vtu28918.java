import java.io.*;

public class Solution {

    public static int marsExploration(String s) {

        int changes = 0;

        for (int i = 0; i < s.length(); i++) {

            char expected;

            if (i % 3 == 0 || i % 3 == 2) {
                expected = 'S';
            } else {
                expected = 'O';
            }

            if (s.charAt(i) != expected) {
                changes++;
            }
        }

        return changes;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine().trim();

        System.out.println(marsExploration(s));
    }
}

output

SOSSPSSQSSOR

SOSSOSSOSSOS

3
