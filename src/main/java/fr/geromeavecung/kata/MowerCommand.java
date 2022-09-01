package fr.geromeavecung.kata;

import java.util.Arrays;
import java.util.function.BiConsumer;

public enum MowerCommand implements BiConsumer<Mower, Garden> {

    MOVE_FORWARD("A", Mower::moveForward),

    ROTATE_LEFT("G", (mower, garden) -> mower.rotateLeft()),

    ROTATE_RIGHT("D", (mower, garden) -> mower.rotateRight());

    private final String code;
    private final BiConsumer<Mower, Garden> command;

    MowerCommand(String code, BiConsumer<Mower, Garden> command) {
        this.code = code;
        this.command = command;
    }

    public static MowerCommand fromCode(String code) {
        return Arrays.stream(MowerCommand.values())
                .filter(mowerCommand -> mowerCommand.code.equals(code))
                .findFirst().orElseThrow(() -> new IllegalArgumentException("MowerCommands unknown code : " + code));
    }

    @Override
    public void accept(Mower mower, Garden garden) {
        command.accept(mower, garden);
    }
}
