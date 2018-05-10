package anagram;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class Dictionary {

    private String filePath;

    public Dictionary(String filePath) {
        this.filePath = filePath;
    }

    public String[] getWords() {
        try {
            return readWords();
        } catch (FileNotFoundException err) {
            return badResult("unable to find file");
        } catch (IOException e) {
            return badResult("error reading file");
        }
    }

    private String[] readWords() throws IOException {
        Path path = new File(this.filePath).toPath();
        return Files.readAllLines(path).toArray(new String[0]);
    }

    private String[] badResult(String errorMessage) {
        System.out.println(errorMessage);
        return new String[]{};
    }

}
