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
            if (!inputWordMap.containsKey(character) || inputWordMap.get(character) == 0) {
                return false;
            }
            inputWordMap.put(character, inputWordMap.get(character) - 1);
        }
        return true;
    }

    private Map<String, Integer> wordCountMap(String input) {
        Map<String, Integer> wordMap = new HashMap<>();
        for (String inputCharacter : splitWord(input)) {
            if (wordMap.containsKey(inputCharacter)) {
                wordMap.put(inputCharacter, wordMap.get(inputCharacter) + 1);
            } else {
                wordMap.put(inputCharacter, 1);
            }
        }
        return wordMap;
    }

    private String[] splitWord(String word) {
        return word.split("");
    }
}
