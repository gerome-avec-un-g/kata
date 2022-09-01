package fr.geromeavecung.kata;

import java.util.List;

public record MowersProgram(Garden garden, List<MowerProgram> mowerPrograms) {

    public MowersProgram {
        mowerPrograms.forEach(mowerProgram -> checkMowerStartingPoint(garden, mowerProgram));
    }

    private void checkMowerStartingPoint(Garden garden, MowerProgram mowerProgram) {
        if (!garden.checkCoordinates(mowerProgram.getCoordinates())) {
            throw new IllegalArgumentException("Mower coordinates "+ mowerProgram.getCoordinates() +" outside of garden " + garden);
        }
    }

}
