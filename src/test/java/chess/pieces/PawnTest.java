package chess.pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PawnTest {

    @Test
    @DisplayName("흰색 폰이 생성되어야 한다")
    void createWhitePawn() {
        verifyPawn(Piece.createWhitePawn(), Color.WHITE, Piece.WHITE_REPRESENTATION);
    }

    @Test
    @DisplayName("검은색 폰이 생성되어야 한다")
    void createBlackPawn() {
        verifyPawn(Piece.createBlackPawn(), Color.BLACK, Piece.BLACK_REPRESENTATION);
    }

    private void verifyPawn(final Piece pawn, final Color color, final char representation) {
        assertThat(pawn.getColor()).isEqualTo(color);
        assertThat(pawn.getRepresentation()).isEqualTo(representation);
    }
}
