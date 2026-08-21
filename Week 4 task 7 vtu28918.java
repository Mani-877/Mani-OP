import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;


class Result {

    public static int diagonalDifference(List<List<Integer>> arr) {
        int n = arr.size();

        int primary = 0;
        int secondary = 0;

        for (int i = 0; i < n; i++) {
            primary += arr.get(i).get(i);
            secondary += arr.get(i).get(n - 1 - i);
        }

        return Math.abs(primary - secondary);
    }
}

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(
            new InputStreamReader(System.in)
        );

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] values = bufferedReader.readLine().trim().split(" ");

            List<Integer> row = new ArrayList<>();

            for (String value : values) {
                row.add(Integer.parseInt(value));
            }

            arr.add(row);
        }

        int result = Result.diagonalDifference(arr);

        System.out.println(result);

        bufferedReader.close();
    }
}

Output

3
11 2 4
4 5 6
10 8 -12

15
