package fr.geromeavecung.kata;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MowersProgramsFromFile implements MowersPrograms {

    private final String fileName;

    public MowersProgramsFromFile(String fileName) {
        this.fileName = "src/test/resources/" + fileName;
    }

    @Override
    public MowersProgram get() {
        String line;
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
            return new MowersProgramParser(fileName, lines).parse();
        } catch (FileNotFoundException f) {
            throw new IllegalArgumentException(fileName + " does not exist");
        } catch (IOException e) {
            throw new IllegalArgumentException("error while reading " + fileName);
        }
    }


}
