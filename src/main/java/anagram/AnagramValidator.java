package anagram;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnagramValidator {

    private Map<String, Integer> characterCount = new HashMap<>();
    private String dictionaryWord;

    public AnagramValidator(String input, String dictionaryWord) {
        constructCharacterMap(input.toLowerCase());
        this.dictionaryWord = dictionaryWord.toLowerCase();
    }

    public boolean isValidAnagram() {
        for (String character : splitWord(dictionaryWord)) {
            if (!isCharacterPresent(character)) return false;
            decrementMap(character);
        }
        return true;
    }

    private boolean isCharacterPresent(String character) {
        return characterCount.containsKey(character) && characterCount.get(character) > 0;
    }

    private void constructCharacterMap(String input) {
        splitWord(input).forEach(this::incrementMap);
    }

    private void incrementMap(String character) {
        characterCount.computeIfPresent(character, (k, v) -> v + 1);
        characterCount.computeIfAbsent(character, k -> 1);
    }

    private void decrementMap(String character) {
        characterCount.computeIfPresent(character, (k, v) -> v - 1);
    }

    private List<String> splitWord(String word) {
        return Arrays.asList(word.split(""));
    }

}
