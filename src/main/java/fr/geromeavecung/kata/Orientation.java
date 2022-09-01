package fr.geromeavecung.kata;

import java.util.Arrays;

public enum Orientation {
    NORTH("N") {
        @Override
        Orientation rotateLeft() {
            return WEST;
        }

        @Override
        Orientation rotateRight() {
            return EAST;
        }
    },

    EAST("E") {
        @Override
        Orientation rotateLeft() {
            return NORTH;
        }

        @Override
        Orientation rotateRight() {
            return SOUTH;
        }
    },

    SOUTH("S") {
        @Override
        Orientation rotateLeft() {
            return EAST;
        }

        @Override
        Orientation rotateRight() {
            return WEST;
        }
    },

    WEST("W") {
        @Override
        Orientation rotateLeft() {
            return SOUTH;
        }

        @Override
        Orientation rotateRight() {
            return NORTH;
        }
    };

    private final String code;

    Orientation(String code) {
        this.code = code;
    }

    public static Orientation fromCode(String code) {
        return Arrays.stream(Orientation.values())
                .filter(orientation -> orientation.code.equals(code))
                .findFirst().orElseThrow(() -> new IllegalArgumentException("Orientation code unknown " + code));
    }

    abstract Orientation rotateLeft();

    abstract Orientation rotateRight();

    @Override
    public String toString() {
        return this.code;
    }
}
