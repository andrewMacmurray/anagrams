import org.junit.Test;

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
        assertAnagram("on", "on","no");
    }

    @Test
    public void testArt() {
        assertAnagram("art","rat","tar", "art");
    }

    @Test
    public void testRat() {
        assertAnagram("rat","rat","tar", "art");
    }

    @Test
    public void testTar() {
        assertAnagram("tar","rat","tar", "art");
    }
}

