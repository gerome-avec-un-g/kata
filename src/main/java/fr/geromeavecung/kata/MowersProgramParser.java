package fr.geromeavecung.kata;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MowersProgramParser {

    private final List<String> lines;

    public MowersProgramParser(String fileName, List<String> lines) {
        if (lines.isEmpty()) {
            throw new IllegalArgumentException(fileName + " is empty");
        }
        if (lines.size()%2==0) {
            throw new IllegalArgumentException(fileName + " doesn't have an even number of lines");
        }
        this.lines = Collections.unmodifiableList(lines);
    }

    public MowersProgram parse() {
        return new MowersProgram(parseGarden(), parseMowerInstructions());
    }

    private Garden parseGarden() {
        Pattern pattern = Pattern.compile("(\\d+) (\\d+)");
        Matcher matcher = pattern.matcher(lines.get(0));
        if (matcher.matches()) {
            int width = Integer.parseInt(matcher.group(1));
            int length = Integer.parseInt(matcher.group(2));
            return new Garden(width, length);
        }
        throw new IllegalArgumentException("Can't parse garden size " + lines.get(0));
    }

    private List<MowerProgram> parseMowerInstructions() {
        String line;
        List<MowerProgram> mowerPrograms = new ArrayList<>();
        for (int i = 1; i < lines.size(); i++) {
            line = lines.get(i);
            Coordinates coordinates = parseCoordinates(line);
            Orientation orientation = parseOrientation(line);
            line = lines.get(++i);
            List<MowerCommand> commands = parseMowerCommands(line);
            mowerPrograms.add(new MowerProgram(coordinates, orientation, commands));
        }
        return mowerPrograms;
    }

    private Coordinates parseCoordinates(String line) {
        Pattern pattern = Pattern.compile("(\\d+) (\\d+).*");
        Matcher matcher = pattern.matcher(line);
        if (matcher.matches()) {
            int x = Integer.parseInt(matcher.group(1));
            int y = Integer.parseInt(matcher.group(2));
            return new Coordinates(x, y);
        }
        throw new IllegalArgumentException("Can't parse mower coordinates " + line);
    }

    private Orientation parseOrientation(String line) {
        Pattern pattern = Pattern.compile(".* ([A-Z])");
        Matcher matcher = pattern.matcher(line);
        if (matcher.matches()) {
            return Orientation.fromCode(matcher.group(1));
        }
        throw new IllegalArgumentException("Can't parse mower orientation " + line);
    }

    private List<MowerCommand> parseMowerCommands(String line) {
        Pattern pattern = Pattern.compile("([A-Z]*)");
        Matcher matcher = pattern.matcher(line);
        if (matcher.matches()) {
            return matcher.group(0).chars().mapToObj(Character::toString).map(MowerCommand::fromCode).toList();
        }
        throw new IllegalArgumentException("Can't parse mower commands " + line);
    }

}
