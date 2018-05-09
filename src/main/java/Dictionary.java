import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class Dictionary implements IDicitonary {

    private String filePath;

    public Dictionary(String filePath) {
        this.filePath = filePath;
    }

    public String[] getWords() {
        try {
            Path path = new File(this.filePath).toPath();
            return Files.readAllLines(path).toArray(new String[0]);
        } catch (FileNotFoundException err) {
            System.out.println("unable to find file");
            return new String[]{};
        }  catch (IOException e) {
            System.out.println("error reading file");
            return new String[]{};
        }
    }
    
}
