package anagram;

import java.util.*;

public class AnagramGenerator {

    private final String[] dictionaryWords;

    public AnagramGenerator(String[] dictionaryWords) {
        this.dictionaryWords = dictionaryWords;
    }

    public ArrayList<String> generate(String input) {
        ArrayList<String> result = new ArrayList<>();
        for (String dictionaryWord : dictionaryWords) {
            if (containsAllLetters(input, dictionaryWord)) {
                result.add(dictionaryWord);
            }
        }
        return result;
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
