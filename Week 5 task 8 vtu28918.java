import java.util.*;

public class Solution {

    public static List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> result = new ArrayList<>();

        for (String word : words) {
            if (matches(word, pattern)) {
                result.add(word);
            }
        }

        return result;
    }

    private static boolean matches(String word, String pattern) {
        // pattern -> word
        Map<Character, Character> map = new HashMap<>();

        // word -> pattern, to ensure bijection
        Map<Character, Character> reverseMap = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char p = pattern.charAt(i);
            char w = word.charAt(i);

            // Check pattern character mapping
            if (map.containsKey(p)) {
                if (map.get(p) != w) {
                    return false;
                }
            } else {
                map.put(p, w);
            }

            // Check that two pattern chars don't map to same word char
            if (reverseMap.containsKey(w)) {
                if (reverseMap.get(w) != p) {
                    return false;
                }
            } else {
                reverseMap.put(w, p);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String[] words = {"abc", "deq", "mee", "aqq", "dkd", "ccc"};
        String pattern = "abb";

        List<String> output = findAndReplacePattern(words, pattern);

        System.out.println(output);
    }
}

Output

[mee, aqq]
