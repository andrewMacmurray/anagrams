import org.junit.Test;

import static org.junit.Assert.*;

public class DictionaryTest {

    @Test
    public void returnWords() {
        Dictionary dictionary = new Dictionary();
        String[] expectedDictionary = new String[]{
                "rat",
                "tar",
                "art",
                "on",
                "no"
        };

        assertArrayEquals(expectedDictionary, dictionary.getWords());
    }
}