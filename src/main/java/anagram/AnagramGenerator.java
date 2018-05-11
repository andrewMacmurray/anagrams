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
                .filter(word -> new AnagramValidator(input, word).isValidAnagram())
                .collect(Collectors.toList());
    }

}
