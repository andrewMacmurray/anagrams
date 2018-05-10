import anagram.AnagramGenerator;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class AnagramGeneratorTest {

    private void assertAnagram(String input, String[] dictionaryWords, String... expectedResultWords) {
        List<String> expectedWords = Arrays.asList(expectedResultWords);
        AnagramGenerator anagramGenerator = new AnagramGenerator(dictionaryWords);
        assertEquals(anagramGenerator.generate(input), expectedWords);
    }

    @Test
    public void testNo() {
        assertAnagram("no", new String[]{"on", "no"}, "on", "no");
    }

    @Test
    public void testOn() {
        assertAnagram("on", new String[]{"on", "no"}, "on", "no");
    }

    @Test
    public void testSingleUseOfChars() {
        assertAnagram("tar", new String[]{"rat", "tar", "art", "atar", "ratatat", "tart"}, "rat", "tar", "art");
    }


    @Test
    public void upperCaseChars() {
        assertAnagram("Tar", new String[]{"raT", "tAR", "art"}, "raT", "tAR", "art");
    }

    @Test
    public void checkMultipleChars() {
        assertAnagram("tart", new String[]{"rat", "tar", "art", "atar", "ratatat", "tart"}, "rat", "tar", "art", "tart");
    }
}
