import anagram.Dictionary;
import org.junit.Test;

import static org.junit.Assert.*;

public class DictionaryTest {

    @Test
    public void returnWords() {
        Dictionary dictionary = new Dictionary("src/test/java/DUMMY_DICT.txt");
        String[] expectedDictionary = new String[]{
                "rat",
                "tar",
                "art",
                "on",
                "no"
        };

        assertArrayEquals(expectedDictionary, dictionary.getWords());
    }

    @Test
    public void returnOtherWords() {
        Dictionary dictionary = new Dictionary("src/test/java/DUMMY_DICT_2.txt");
        String[] expectedDictionary = new String[]{
                "blah",
                "car",
                "tin",
                "bin",
                "mum",
                "anagram"
        };

        assertArrayEquals(expectedDictionary, dictionary.getWords());
    }
}