import java.util.Arrays;
import java.util.HashSet;

public class AnagramGenerator {

    private static String[] dictionary = new String[]{
            "rat",
            "tar",
            "art",
            "on",
            "no"
    };

    public static String generate(String input) {
        String result = "";
        for (String dictionaryWord : dictionary) {
           if (containsAllLetters(input, dictionaryWord)) {
              result += dictionaryWord;
           }
        }

        return result;
    }

    private static boolean containsAllLetters(String input, String dictionaryWord) {
        for (String character : splitWord(dictionaryWord)) {
            if (!input.contains(character)) {
                return false;
            }
        }
        return true;
    }

    private static String[] splitWord(String word) {
       return word.split("");
    }
}