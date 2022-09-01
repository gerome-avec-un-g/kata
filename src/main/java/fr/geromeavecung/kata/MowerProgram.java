package fr.geromeavecung.kata;

import java.util.Arrays;
import java.util.List;

public class MowerProgram {

    private final Coordinates coordinates;

    private final Orientation orientation;

    private final List<MowerCommand> commands;

    public MowerProgram(Coordinates coordinates, Orientation orientation, MowerCommand... commands) {
        this.coordinates = coordinates;
        this.orientation = orientation;
        this.commands = Arrays.asList(commands);
    }

    public MowerProgram(Coordinates coordinates, Orientation orientation, List<MowerCommand> commands) {
        this.coordinates = coordinates;
        this.orientation = orientation;
        this.commands = commands;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public List<MowerCommand> getCommands() {
        return commands;
    }
}
