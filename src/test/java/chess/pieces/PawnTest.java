package chess.pieces;

import chess.pieces.Piece.Color;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static chess.pieces.Piece.Type.PAWN;
import static org.assertj.core.api.Assertions.assertThat;

public class PawnTest {

    @Nested
    @DisplayName("흰색 폰을 생성하면")
    class CreateWhitePawn {

        Piece whitePawn;

        @BeforeEach
        void init() {
            whitePawn = Piece.createWhitePawn();
        }

        @Test
        @DisplayName("흰색이어야 한다.")
        void whiteColor() {
            verifyPawnColor(whitePawn, Color.WHITE);
        }

        @Test
        @DisplayName("흰색 폰 심볼을 가져야한다.")
        void whiteRepresentation() {
            verifyPawnRepresentation(whitePawn, PAWN.getRepresentation());
        }
    }

    @Nested
    @DisplayName("검은색 폰을 생성하면")
    class CreateBlackPawn {

        Piece blackPawn;

        @BeforeEach
        void init() {
            blackPawn = Piece.createBlackPawn();
        }

        @Test
        @DisplayName("검은색이어야 한다.")
        void blackColor() {
            verifyPawnColor(blackPawn, Color.BLACK);
        }

        @Test
        @DisplayName("검은색 폰 심볼을 가져야한다.")
        void blackRepresentation() {
            verifyPawnRepresentation(blackPawn, Character.toUpperCase(PAWN.getRepresentation()));
        }
    }

    private void verifyPawnColor(final Piece pawn, final Color color) {
        assertThat(pawn.getColor()).isEqualTo(color);

    }

    private void verifyPawnRepresentation(final Piece pawn, final char representation) {
        assertThat(pawn.getRepresentation()).isEqualTo(representation);
    }
}
