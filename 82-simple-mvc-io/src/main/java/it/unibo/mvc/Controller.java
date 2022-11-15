package it.unibo.mvc;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {

    private File currFile;

    public Controller(String path) {
        currFile = new File(path);
    }

    public File getFile() {
        return currFile;
    }

    public String getPath() {
        return currFile.getAbsolutePath();
    }

    public void writeOnFile(String s) throws IOException{
        try (PrintStream ps = new PrintStream(currFile.getPath(), StandardCharsets.UTF_8)){
            ps.print(s);
        } catch (IOException e) {
            System.out.println("Errore: " + e.getMessage());
        }
    }
}
