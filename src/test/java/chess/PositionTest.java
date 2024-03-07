package chess;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PositionTest {

    @Test
    @DisplayName("g1은 7행 6열이어야 한다.")
    void verifyPosition1() {
        Position pos = Position.of("g1");

        Assertions.assertThat(pos).isEqualTo(new Position(7, 6));
    }

    @Test
    @DisplayName("a8은 0행 0열이어야 한다.")
    void verifyPosition2() {
        Position pos = Position.of("a8");

        Assertions.assertThat(pos).isEqualTo(new Position(0, 0));
    }

}