import anagram.AnagramGenerator;
import anagram.IDicitonary;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class AnagramGeneratorTest {

    private void assertAnagram(String input, String... dictionaryWords) {
        List<String> expectedWords = new ArrayList<>();
        expectedWords.addAll(Arrays.asList(dictionaryWords));

        AnagramGenerator anagramGenerator = new AnagramGenerator(new MockDict());
        assertEquals(anagramGenerator.generate(input), expectedWords);
    }

    @Test
    public void testNo() {
        assertAnagram("no", "on", "no");
    }

    @Test
    public void testOn() {
        assertAnagram("on", "on", "no");
    }

    @Test
    public void testArt() {
        assertAnagram("art", "rat", "tar", "art");
    }

    @Test
    public void testRat() {
        assertAnagram("rat", "rat", "tar", "art");
    }

    @Test
    public void testTar() {
        assertAnagram("tar", "rat", "tar", "art");
    }

    @Test
    public void testSingleUseOfChars() {
        List<String> expectedWords = new ArrayList<>();
        expectedWords.addAll(Arrays.asList("rat", "tar", "art"));
        AnagramGenerator anagramGenerator = new AnagramGenerator(
                new MockDict2(Arrays.asList("rat",
                        "tar",
                        "art",
                        "atar",
                        "ratatat",
                        "tart"))
        );
        assertEquals(expectedWords, anagramGenerator.generate("tar"));
    }


    @Test
    public void upperCaseChars() {
        List<String> expectedWords = new ArrayList<>();
        expectedWords.addAll(Arrays.asList("Rat", "Tar", "art"));
        AnagramGenerator anagramGenerator = new AnagramGenerator(new MockDict2(Arrays.asList(
                "Rat",
                "Tar",
                "art",
                "ratatat"
        )));
        assertEquals(expectedWords, anagramGenerator.generate("TAR"));
    }

    @Test
    public void checkMultipleChars() {
        List<String> expectedWords = new ArrayList<>();
        expectedWords.addAll(Arrays.asList("tar", "art", "tart"));
        AnagramGenerator anagramGenerator = new AnagramGenerator(new MockDict2(Arrays.asList(
            "tar",
            "art",
            "tart",
            "ratatat"
        )));
        assertEquals(expectedWords, anagramGenerator.generate("tart"));
    }
}

class MockDict2 implements IDicitonary {

    private String[] words;

    public MockDict2(List<String> words) {
        this.words = words.toArray(new String[0]);
    }

    public String[] getWords() {
        return words;
    }

}
