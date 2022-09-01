package fr.geromeavecung.kata;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static fr.geromeavecung.kata.MowerCommand.MOVE_FORWARD;
import static fr.geromeavecung.kata.MowerCommand.ROTATE_LEFT;
import static fr.geromeavecung.kata.MowerCommand.ROTATE_RIGHT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class MowItNowTest {

    @Nested
    @DisplayName("mower rotation")
    class MowerRotation {

        @Test
        void given_mower_pointing_north_when_mower_rotates_left_then_mower_points_west() {
            Garden garden = new Garden(1, 1);
            MowerProgram mowerProgram = new MowerProgram(new Coordinates(0, 0), Orientation.NORTH, MowerCommand.ROTATE_LEFT);
            MowItNow mowItNow = new MowItNow(() -> new MowersProgram(garden, Collections.singletonList(mowerProgram)));

            String mowerPositions = mowItNow.executeAllMowersPrograms();

            assertThat(mowerPositions).isEqualTo("0 0 W");
        }

        @Test
        void given_mower_pointing_east_when_mower_rotates_left_then_mower_points_north() {
            Garden garden = new Garden(1, 1);
            MowerProgram mowerProgram = new MowerProgram(new Coordinates(0, 0), Orientation.EAST, MowerCommand.ROTATE_LEFT);
            MowItNow mowItNow = new MowItNow(() -> new MowersProgram(garden, Collections.singletonList(mowerProgram)));

            String mowerPositions = mowItNow.executeAllMowersPrograms();

            assertThat(mowerPositions).isEqualTo("0 0 N");
        }

        @Test
        void given_mower_pointing_south_when_mower_rotates_left_then_mower_points_east() {
            Garden garden = new Garden(1, 1);
            MowerProgram mowerProgram = new MowerProgram(new Coordinates(0, 0), Orientation.SOUTH, MowerCommand.ROTATE_LEFT);
            MowItNow mowItNow = new MowItNow(() -> new MowersProgram(garden, Collections.singletonList(mowerProgram)));

            String mowerPositions = mowItNow.executeAllMowersPrograms();

            assertThat(mowerPositions).isEqualTo("0 0 E");
        }

        @Test
        void given_mower_pointing_west_when_mower_rotates_left_then_mower_points_south() {
            Garden garden = new Garden(1, 1);
            MowerProgram mowerProgram = new MowerProgram(new Coordinates(0, 0), Orientation.WEST, MowerCommand.ROTATE_LEFT);
            MowItNow mowItNow = new MowItNow(() -> new MowersProgram(garden, Collections.singletonList(mowerProgram)));

            String mowerPositions = mowItNow.executeAllMowersPrograms();

            assertThat(mowerPositions).isEqualTo("0 0 S");
        }

        @Test
        void given_mower_pointing_north_when_mower_rotates_right_then_mower_points_east() {
            Garden garden = new Garden(1, 1);
            MowerProgram mowerProgram = new MowerProgram(new Coordinates(0, 0), Orientation.NORTH, MowerCommand.ROTATE_RIGHT);
            MowItNow mowItNow = new MowItNow(() -> new MowersProgram(garden, Collections.singletonList(mowerProgram)));

            String mowerPositions = mowItNow.executeAllMowersPrograms();

            assertThat(mowerPositions).isEqualTo("0 0 E");
        }

        @Test
        void given_mower_pointing_east_when_mower_rotates_right_then_mower_points_south() {
            Garden garden = new Garden(1, 1);
            MowerProgram mowerProgram = new MowerProgram(new Coordinates(0, 0), Orientation.EAST, MowerCommand.ROTATE_RIGHT);
            MowItNow mowItNow = new MowItNow(() -> new MowersProgram(garden, Collections.singletonList(mowerProgram)));

            String mowerPositions = mowItNow.executeAllMowersPrograms();

            assertThat(mowerPositions).isEqualTo("0 0 S");
        }

        @Test
        void given_mower_pointing_south_when_mower_rotates_right_then_mower_points_west() {
            Garden garden = new Garden(1, 1);
            MowerProgram mowerProgram = new MowerProgram(new Coordinates(0, 0), Orientation.SOUTH, MowerCommand.ROTATE_RIGHT);
            MowItNow mowItNow = new MowItNow(() -> new MowersProgram(garden, Collections.singletonList(mowerProgram)));

            String mowerPositions = mowItNow.executeAllMowersPrograms();

            assertThat(mowerPositions).isEqualTo("0 0 W");
        }

        @Test
        void given_mower_pointing_west_when_mower_rotates_right_then_mower_points_north() {
            Garden garden = new Garden(1, 1);
            MowerProgram mowerProgram = new MowerProgram(new Coordinates(0, 0), Orientation.WEST, MowerCommand.ROTATE_RIGHT);
            MowItNow mowItNow = new MowItNow(() -> new MowersProgram(garden, Collections.singletonList(mowerProgram)));

            String mowerPositions = mowItNow.executeAllMowersPrograms();

            assertThat(mowerPositions).isEqualTo("0 0 N");
        }

        @Test
        void given_mower_pointing_north_when_mower_rotates_right_and_right_then_mower_points_south() {
            Garden garden = new Garden(1, 1);
            MowerProgram mowerProgram = new MowerProgram(new Coordinates(0, 0), Orientation.NORTH, MowerCommand.ROTATE_RIGHT, MowerCommand.ROTATE_RIGHT);
            MowItNow mowItNow = new MowItNow(() -> new MowersProgram(garden, Collections.singletonList(mowerProgram)));

            String mowerPositions = mowItNow.executeAllMowersPrograms();

            assertThat(mowerPositions).isEqualTo("0 0 S");
        }

        @Test
        void given_mower_pointing_north_when_mower_rotates_right_and_left_then_mower_points_north() {
            Garden garden = new Garden(1, 1);
            MowerProgram mowerProgram = new MowerProgram(new Coordinates(0, 0), Orientation.NORTH, MowerCommand.ROTATE_RIGHT, MowerCommand.ROTATE_LEFT);
            MowItNow mowItNow = new MowItNow(() -> new MowersProgram(garden, Collections.singletonList(mowerProgram)));

            String mowerPositions = mowItNow.executeAllMowersPrograms();

            assertThat(mowerPositions).isEqualTo("0 0 N");
        }

        @Test
        void given_two_mowers_pointing_north_and_south_when_they_rotates_right_and_left_then_they_both_points_east() {
            Garden garden = new Garden(1, 1);
            MowerProgram mowerProgram1 = new MowerProgram(new Coordinates(0, 0), Orientation.NORTH, MowerCommand.ROTATE_RIGHT);
            MowerProgram mowerProgram2 = new MowerProgram(new Coordinates(0, 0), Orientation.SOUTH, MowerCommand.ROTATE_LEFT);
            MowItNow mowItNow = new MowItNow(() -> new MowersProgram(garden, Arrays.asList(mowerProgram1, mowerProgram2)));

            String mowerPositions = mowItNow.executeAllMowersPrograms();

            assertThat(mowerPositions).isEqualTo("0 0 E 0 0 E");
        }
    }

    @Nested
    @DisplayName("mower move forward")
    class MowerMoveForward {

        @Test
        void given_mower_at_1_1_pointing_north_when_moves_mower_forward_then_mower_is_at_1_2_north() {
            Garden garden = new Garden(2, 2);
            MowerProgram mowerProgram = new MowerProgram(new Coordinates(1, 1), Orientation.NORTH, MOVE_FORWARD);
            MowItNow mowItNow = new MowItNow(() -> new MowersProgram(garden, Collections.singletonList(mowerProgram)));

            String mowerPositions = mowItNow.executeAllMowersPrograms();

            assertThat(mowerPositions).isEqualTo("1 2 N");
        }

        @Test
        void given_mower_at_1_1_pointing_east_when_mower_moves_forward_then_mower_is_at_2_1_east() {
            Garden garden = new Garden(2, 2);
            MowerProgram mowerProgram = new MowerProgram(new Coordinates(1, 1), Orientation.EAST, MOVE_FORWARD);
            MowItNow mowItNow = new MowItNow(() -> new MowersProgram(garden, Collections.singletonList(mowerProgram)));

            String mowerPositions = mowItNow.executeAllMowersPrograms();

            assertThat(mowerPositions).isEqualTo("2 1 E");
        }

        @Test
        void given_mower_at_1_1_pointing_south_when_mower_moves_forward_then_mower_is_at_1_0_south() {
            Garden garden = new Garden(2, 2);
            MowerProgram mowerProgram = new MowerProgram(new Coordinates(1, 1), Orientation.SOUTH, MOVE_FORWARD);
            MowItNow mowItNow = new MowItNow(() -> new MowersProgram(garden, Collections.singletonList(mowerProgram)));

            String mowerPositions = mowItNow.executeAllMowersPrograms();

            assertThat(mowerPositions).isEqualTo("1 0 S");
        }

        @Test
        void given_mower_at_1_1_pointing_west_when_mower_moves_forward_then_mower_is_at_0_1_west() {
            Garden garden = new Garden(2, 2);
            MowerProgram mowerProgram = new MowerProgram(new Coordinates(1, 1), Orientation.WEST, MOVE_FORWARD);
            MowItNow mowItNow = new MowItNow(() -> new MowersProgram(garden, Collections.singletonList(mowerProgram)));

            String mowerPositions = mowItNow.executeAllMowersPrograms();

            assertThat(mowerPositions).isEqualTo("0 1 W");
        }

        @Test
        void given_mower_at_0_0_pointing_east_when_mower_moves_forward_twice_then_mower_is_at_0_2_east() {
            Garden garden = new Garden(2, 2);
            MowerProgram mowerProgram = new MowerProgram(new Coordinates(0, 0), Orientation.EAST, MOVE_FORWARD, MOVE_FORWARD);
            MowItNow mowItNow = new MowItNow(() -> new MowersProgram(garden, Collections.singletonList(mowerProgram)));

            String mowerPositions = mowItNow.executeAllMowersPrograms();

            assertThat(mowerPositions).isEqualTo("2 0 E");
        }

        @Test
        void given_a_mower_at_0_0_east_2_2_south_when_they_moves_forward_then_they_are_at_0_2_east_and_2_1_south() {
            Garden garden = new Garden(2, 2);
            MowerProgram mowerProgram1 = new MowerProgram(new Coordinates(0, 0), Orientation.EAST, MOVE_FORWARD);
            MowerProgram mowerProgram2 = new MowerProgram(new Coordinates(2, 2), Orientation.SOUTH, MOVE_FORWARD);
            MowItNow mowItNow = new MowItNow(() -> new MowersProgram(garden, Arrays.asList(mowerProgram1, mowerProgram2)));

            String mowerPositions = mowItNow.executeAllMowersPrograms();

            assertThat(mowerPositions).isEqualTo("1 0 E 2 1 S");
        }

        // TODO can a mower move through another mower ?

    }

    @Nested
    @DisplayName("mower can't move forward")
    class MowerCantMoveForward {

        @Test
        void given_mower_at_0_0_pointing_north_when_mower_moves_forward_then_mower_is_at_0_0_north() {
            Garden garden = new Garden(0, 0);
            MowerProgram mowerProgram = new MowerProgram(new Coordinates(0, 0), Orientation.NORTH, MOVE_FORWARD);
            MowItNow mowItNow = new MowItNow(() -> new MowersProgram(garden, Collections.singletonList(mowerProgram)));

            String mowerPositions = mowItNow.executeAllMowersPrograms();

            assertThat(mowerPositions).isEqualTo("0 0 N");
        }

        @Test
        void given_mower_at_0_0_pointing_east_when_mower_moves_forward_then_mower_is_at_0_0_east() {
            Garden garden = new Garden(0, 0);
            MowerProgram mowerProgram = new MowerProgram(new Coordinates(0, 0), Orientation.EAST, MOVE_FORWARD);
            MowItNow mowItNow = new MowItNow(() -> new MowersProgram(garden, Collections.singletonList(mowerProgram)));

            String mowerPositions = mowItNow.executeAllMowersPrograms();

            assertThat(mowerPositions).isEqualTo("0 0 E");
        }

        @Test
        void given_mower_at_0_0_pointing_south_when_mower_moves_forward_then_mower_is_at_0_0_south() {
            Garden garden = new Garden(0, 0);
            MowerProgram mowerProgram = new MowerProgram(new Coordinates(0, 0), Orientation.SOUTH, MOVE_FORWARD);
            MowItNow mowItNow = new MowItNow(() -> new MowersProgram(garden, Collections.singletonList(mowerProgram)));

            String mowerPositions = mowItNow.executeAllMowersPrograms();

            assertThat(mowerPositions).isEqualTo("0 0 S");
        }

        @Test
        void given_mower_at_0_0_pointing_west_when_mower_moves_forward_then_mower_is_at_0_0_west() {
            Garden garden = new Garden(0, 0);
            MowerProgram mowerProgram = new MowerProgram(new Coordinates(0, 0), Orientation.WEST, MOVE_FORWARD);
            MowItNow mowItNow = new MowItNow(() -> new MowersProgram(garden, Collections.singletonList(mowerProgram)));

            String mowerPositions = mowItNow.executeAllMowersPrograms();

            assertThat(mowerPositions).isEqualTo("0 0 W");
        }

    }

    @Nested
    @DisplayName("full instructions")
    class FullMowersPrograms {

        @Test
        void given_full_instructions_when_all_instructions_are_executed_then_the_mowers_are_at_1_3_north_and_5_1_east() {
            Garden garden = new Garden(5, 5);
            MowerProgram mowerProgram1 = new MowerProgram(new Coordinates(1, 2), Orientation.NORTH, ROTATE_LEFT, MOVE_FORWARD, ROTATE_LEFT, MOVE_FORWARD, ROTATE_LEFT, MOVE_FORWARD, ROTATE_LEFT, MOVE_FORWARD, MOVE_FORWARD);
            MowerProgram mowerProgram2 = new MowerProgram(new Coordinates(3, 3), Orientation.EAST, MOVE_FORWARD, MOVE_FORWARD, ROTATE_RIGHT, MOVE_FORWARD, MOVE_FORWARD, ROTATE_RIGHT, MOVE_FORWARD, ROTATE_RIGHT, ROTATE_RIGHT, MOVE_FORWARD);
            MowItNow mowItNow = new MowItNow(() -> new MowersProgram(garden, Arrays.asList(mowerProgram1, mowerProgram2)));

            String mowerPositions = mowItNow.executeAllMowersPrograms();

            assertThat(mowerPositions).isEqualTo("1 3 N 5 1 E");
        }

    }

    @Nested
    @DisplayName("full instructions from file")
    class FullMowersProgramsFromFile {

        @Test
        void given_complex_mowers_program_when_read_file_then_every_thing_works() {
            MowItNow mowItNow = new MowItNow(new MowersProgramsFromFile("complex_mowers_program.txt"));

            String mowerPositions = mowItNow.executeAllMowersPrograms();

            assertThat(mowerPositions).isEqualTo("1 3 N 5 1 E");
        }

        @Test
        void given_no_file_when_read_file_then_error() {
            MowItNow mowItNow = new MowItNow(new MowersProgramsFromFile("does_not_exists.txt"));

            assertThatThrownBy(mowItNow::executeAllMowersPrograms)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("src/test/resources/does_not_exists.txt does not exist");
        }

        @Test
        void given_empty_file_when_read_file_then_error() {
            MowItNow mowItNow = new MowItNow(new MowersProgramsFromFile("empty_file.txt"));

            assertThatThrownBy(mowItNow::executeAllMowersPrograms)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("empty_file.txt is empty");
        }

        @Test
        void given_mower_partial_parse_error_when_read_file_then_error() {
            MowItNow mowItNow = new MowItNow(new MowersProgramsFromFile("partial_mower_parse_error.txt"));

            assertThatThrownBy(mowItNow::executeAllMowersPrograms)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("src/test/resources/partial_mower_parse_error.txt doesn't have an even number of lines");
        }

        @Test
        void given_mower_garden_parse_error_when_read_file_then_error() {
            MowItNow mowItNow = new MowItNow(new MowersProgramsFromFile("garden_parse_error.txt"));

            assertThatThrownBy(mowItNow::executeAllMowersPrograms)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("Can't parse garden size 5 o");
        }

        @Test
        void given_mower_coordinate_parse_error_when_read_file_then_error() {
            MowItNow mowItNow = new MowItNow(new MowersProgramsFromFile("mower_coordinates_parse_error.txt"));

            assertThatThrownBy(mowItNow::executeAllMowersPrograms)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("Can't parse mower coordinates 1 a N");
        }

        @Test
        void given_mower_orientation_parse_error_when_read_file_then_error() {
            MowItNow mowItNow = new MowItNow(new MowersProgramsFromFile("mower_orientation_parse_error.txt"));

            assertThatThrownBy(mowItNow::executeAllMowersPrograms)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("Can't parse mower orientation 1 2 7");
        }

        @Test
        void given_mower_orientation_conversion_error_when_read_file_then_error() {
            MowItNow mowItNow = new MowItNow(new MowersProgramsFromFile("mower_orientation_conversion_error.txt"));

            assertThatThrownBy(mowItNow::executeAllMowersPrograms)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("Orientation code unknown X");
        }

        @Test
        void given_mower_command_parse_error_when_read_file_then_error() {
            MowItNow mowItNow = new MowItNow(new MowersProgramsFromFile("mower_command_parse_error.txt"));

            assertThatThrownBy(mowItNow::executeAllMowersPrograms)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("Can't parse mower commands AADA1DADDA");
        }

        @Test
        void given_mower_command_conversion_error_when_read_file_then_error() {
            MowItNow mowItNow = new MowItNow(new MowersProgramsFromFile("mower_command_conversion_error.txt"));

            assertThatThrownBy(mowItNow::executeAllMowersPrograms)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("MowerCommands unknown code : Y");
        }

        @Test
        void given_mower_coordiantes_outside_of_garden_when_read_file_then_error() {
            MowItNow mowItNow = new MowItNow(new MowersProgramsFromFile("mower_coordinates_outside_of_garden.txt"));

            assertThatThrownBy(mowItNow::executeAllMowersPrograms)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("Mower coordinates 5 5 outside of garden 2 2");
        }

    }

}