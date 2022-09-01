package fr.geromeavecung.kata;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MowItNow {

    private final MowersPrograms mowersPrograms;

    private final List<Mower> mowers = new ArrayList<>();

    public MowItNow(MowersPrograms mowersPrograms) {
        this.mowersPrograms = mowersPrograms;
    }

    public String executeAllMowersPrograms() {
        MowersProgram mowersProgram = mowersPrograms.get();
        mowersProgram.mowerPrograms().forEach(mowerProgram -> executeMowerProgram(mowerProgram, mowersProgram.garden()));
        return mowers.stream().map(Mower::toString).collect(Collectors.joining(" "));
    }

    private void executeMowerProgram(MowerProgram mowerProgram, Garden garden) {
        Mower mower = new Mower(mowerProgram.getCoordinates(), mowerProgram.getOrientation());
        mowerProgram.getCommands().forEach(mowerCommands -> mowerCommands.accept(mower, garden));
        mowers.add(mower);
    }

}
