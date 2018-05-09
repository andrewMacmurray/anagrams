import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class AnagramGenerator {

    private final String[] dictionary;

    public AnagramGenerator(IDicitonary dictionary) {
        this.dictionary = dictionary.getWords();
    }

    public ArrayList<String> generate(String input) {
        ArrayList<String> result = new ArrayList<>();
        for (String dictionaryWord : dictionary) {
           if (containsAllLetters(input, dictionaryWord)) {
              result.add(dictionaryWord);
           }
        }
        return result;
    }

    private boolean containsAllLetters(String input, String dictionaryWord) {
        String checkedCharacters = "";
        for (String character : splitWord(dictionaryWord)) {
            if (!input.contains(character) || checkedCharacters.contains(character)) {
                return false;
            }
            checkedCharacters += character;
        }
        return true;
    }

    private String[] splitWord(String word) {
       return word.split("");
    }
}
