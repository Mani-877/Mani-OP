import java.util.*;

public class Solution {

    public static List<String> stringMatching(String[] words) {
        List<String> result = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {

                // Don't compare a word with itself
                if (i != j && words[j].contains(words[i])) {
                    result.add(words[i]);
                    break;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String[] words = {"mass", "as", "hero", "superhero"};

        List<String> output = stringMatching(words);

        System.out.println(output);
    }
}

Output

[as, hero]
