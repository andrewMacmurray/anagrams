import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class Dictionary {

    private String fileName;

    public Dictionary(String filePath) {
        this.fileName = filePath;
    }

    public String[] getWords() {
        String line = null;
        try {
            Path filePath = new File(fileName).toPath();
            return Files.readAllLines(filePath).toArray(new String[0]);

        } catch (FileNotFoundException err) {
            System.out.println("unable to find file");
            return new String[]{};
        }  catch (IOException e) {
            System.out.println("error reading file");
            return new String[]{};
        }
    }
    
}
