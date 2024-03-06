package chess.pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static chess.pieces.Piece.Type.*;
import static org.assertj.core.api.Assertions.assertThat;

class PieceTest {

    @Nested
    @DisplayName("기물들의 심볼을 검사")
    class CreatePiece {
        @Test
        void createBlackKnight() {
            verifyPieceRepresentation(Piece.createBlackKnight(), Character.toUpperCase(KNIGHT.getRepresentation()));
        }

        @Test
        void createWhiteKnight() {
            verifyPieceRepresentation(Piece.createWhiteKnight(), KNIGHT.getRepresentation());
        }

        @Test
        void createBlackRook() {
            verifyPieceRepresentation(Piece.createBlackRook(), Character.toUpperCase(ROOK.getRepresentation()));
        }

        @Test
        void createWhiteRook() {
            verifyPieceRepresentation(Piece.createWhiteRook(), ROOK.getRepresentation());
        }

        @Test
        void createBlackBishop() {
            verifyPieceRepresentation(Piece.createBlackBishop(), Character.toUpperCase(BISHOP.getRepresentation()));
        }

        @Test
        void createWhiteBishop() {
            verifyPieceRepresentation(Piece.createWhiteBishop(), BISHOP.getRepresentation());
        }

        @Test
        void createBlackQueen() {
            verifyPieceRepresentation(Piece.createBlackQueen(), Character.toUpperCase(QUEEN.getRepresentation()));
        }

        @Test
        void createWhiteQueen() {
            verifyPieceRepresentation(Piece.createWhiteQueen(), QUEEN.getRepresentation());
        }

        @Test
        void createBlackKing() {
            verifyPieceRepresentation(Piece.createBlackKing(), Character.toUpperCase(KING.getRepresentation()));
        }

        @Test
        void createWhiteKing() {
            verifyPieceRepresentation(Piece.createWhiteKing(), KING.getRepresentation());
        }

        private void verifyPieceRepresentation(final Piece piece, final char representation) {
            assertThat(piece.getRepresentation()).isEqualTo(representation);
        }
    }

    @Nested
    @DisplayName("기물들의 색을 비교")
    class ColorCompare {
        @Test
        @DisplayName("검은색 기물들은 모두 검은색이어야 함")
        void isBlackColor() {
            List<Piece> pieces = new ArrayList<>();
            pieces.add(Piece.createBlackKing());
            pieces.add(Piece.createBlackQueen());
            pieces.add(Piece.createBlackBishop());
            pieces.add(Piece.createBlackKnight());
            pieces.add(Piece.createBlackRook());
            pieces.add(Piece.createBlackPawn());

            assertThat(pieces).allMatch(Piece::isBlack);
        }

        @Test
        @DisplayName("흰색 기물들은 모두 흰색이어야 함")
        void isWhiteColor() {
            List<Piece> pieces = new ArrayList<>();
            pieces.add(Piece.createWhiteKing());
            pieces.add(Piece.createWhiteQueen());
            pieces.add(Piece.createWhiteBishop());
            pieces.add(Piece.createWhiteKnight());
            pieces.add(Piece.createWhiteRook());
            pieces.add(Piece.createWhitePawn());

            assertThat(pieces).allMatch(Piece::isWhite);
        }
    }

}