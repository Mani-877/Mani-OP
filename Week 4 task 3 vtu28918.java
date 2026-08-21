import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;


class Result {

    public static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        int alice = 0;
        int bob = 0;

        for (int i = 0; i < 3; i++) {
            if (a.get(i) > b.get(i)) {
                alice++;
            } else if (a.get(i) < b.get(i)) {
                bob++;
            }
        }

        return Arrays.asList(alice, bob);
    }
}

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
        );

        String[] aInput = br.readLine().trim().split(" ");
        String[] bInput = br.readLine().trim().split(" ");

        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();

        for (String value : aInput) {
            a.add(Integer.parseInt(value));
        }

        for (String value : bInput) {
            b.add(Integer.parseInt(value));
        }

        List<Integer> result = Result.compareTriplets(a, b);

        System.out.println(result.get(0) + " " + result.get(1));
    }
}

Output

5 6 7
3 6 10

1 1
