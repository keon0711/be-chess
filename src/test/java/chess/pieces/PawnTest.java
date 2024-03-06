package chess.pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PawnTest {

    @Test
    @DisplayName("흰색 폰이 생성되어야 한다")
    void createWhitePawn() {
        verifyPawn(Color.WHITE, Pawn.WHITE_REPRESENTATION);
    }

    @Test
    @DisplayName("검은색 폰이 생성되어야 한다")
    void createBlackPawn() {
        verifyPawn(Color.BLACK, Pawn.BLACK_REPRESENTATION);
    }

    @Test
    @DisplayName("기본 생성자는 흰색 폰을 생성해야 한다.")
    void createDefaultConstructor() {
        Pawn pawn = new Pawn();
        assertThat(pawn.getColor()).isEqualTo(Color.WHITE);
    }

    private void verifyPawn(final Color color, final char representation) {
        Pawn pawn = new Pawn(color, representation);
        assertThat(pawn.getColor()).isEqualTo(color);
        assertThat(pawn.getRepresentation()).isEqualTo(representation);
    }
}
