package anagram;

import java.util.*;
import java.util.stream.Collectors;

public class AnagramGenerator {

    private final String[] dictionaryWords;

    public AnagramGenerator(String[] dictionaryWords) {
        this.dictionaryWords = dictionaryWords;
    }

    public List<String> generate(String input) {
        return Arrays.asList(dictionaryWords)
                .stream()
                .filter(word -> containsAllLetters(input, word))
                .collect(Collectors.toList());
    }

    private boolean containsAllLetters(String input, String dictionaryWord) {
        Map<String, Integer> inputWordMap = wordCountMap(input.toLowerCase());

        for (String character : splitWord(dictionaryWord.toLowerCase())) {
            if (!isCharacterPresent(inputWordMap, character)) return false;
            decrementMap(inputWordMap, character);
        }
        return true;
    }

    private boolean isCharacterPresent(Map<String, Integer> map, String character) {
        return map.containsKey(character) && map.get(character) > 0;
    }

    private Map<String, Integer> wordCountMap(String input) {
        Map<String, Integer> wordMap = new HashMap<>();
        for (String inputCharacter : splitWord(input)) {
            incrementMap(wordMap, inputCharacter);
        }
        return wordMap;
    }

    private void incrementMap(Map<String, Integer> map, String character) {
        map.computeIfPresent(character, (k, v) -> v + 1);
        map.computeIfAbsent(character, k -> 1);
    }

    private void decrementMap(Map<String, Integer> map, String character) {
        map.computeIfPresent(character, (k, v) -> v - 1);
    }

    private String[] splitWord(String word) {
        return word.split("");
    }
}
