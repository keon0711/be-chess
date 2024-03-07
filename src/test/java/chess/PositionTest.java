package chess;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PositionTest {

    @Test
    @DisplayName("g1은 7행 6열이어야 한다.")
    void g1_should_be_pared_7_row_6_column() {
        Position pos = Position.of("g1");

        assertThat(pos).isEqualTo(new Position(7, 6));
    }

    @Test
    @DisplayName("a8은 0행 0열이어야 한다.")
    void a8_should_be_pared_0_row_0_column() {
        Position pos = Position.of("a8");

        assertThat(pos).isEqualTo(new Position(0, 0));
    }

    @ParameterizedTest
    @ValueSource(strings = {"a0, a9, c0, c9, g0, g9, h0, h9"})
    @DisplayName("Rank가 1~8 사이가 아니면 예외를 발생시켜야 한다.")
    void rankIndex_ShouldBe_Between_One_And_Eight(String position) {
        assertThatThrownBy(() -> Position.of(position)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"a0, a9, c0, c9, g0, g9, h0, h9"})
    @DisplayName("File이 a~h 사이가 아니면 예외를 발생시켜야 한다.")
    void fileIndex_ShouldBe_Between_A_And_H(String position) {
        assertThatThrownBy(() -> Position.of(position)).isInstanceOf(IllegalArgumentException.class);
    }
}