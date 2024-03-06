package chess.pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PieceTest {

    @Nested
    @DisplayName("기물들의 심볼을 검사")
    class CreatePiece {
        @Test
        void createBlackKnight() {
            verifyPieceRepresentation(Piece.createBlackKnight(), Piece.BLACK_KNIGHT_REPRESENTATION);
        }

        @Test
        void createWhiteKnight() {
            verifyPieceRepresentation(Piece.createWhiteKnight(), Piece.WHITE_KNIGHT_REPRESENTATION);
        }

        @Test
        void createBlackRook() {
            verifyPieceRepresentation(Piece.createBlackRook(), Piece.BLACK_ROOK_REPRESENTATION);
        }

        @Test
        void createWhiteRook() {
            verifyPieceRepresentation(Piece.createWhiteRook(), Piece.WHITE_ROOK_REPRESENTATION);
        }

        @Test
        void createBlackBishop() {
            verifyPieceRepresentation(Piece.createBlackBishop(), Piece.BLACK_BISHOP_REPRESENTATION);
        }

        @Test
        void createWhiteBishop() {
            verifyPieceRepresentation(Piece.createWhiteBishop(), Piece.WHITE_BISHOP_REPRESENTATION);
        }

        @Test
        void createBlackQueen() {
            verifyPieceRepresentation(Piece.createBlackQueen(), Piece.BLACK_QUEEN_REPRESENTATION);
        }

        @Test
        void createWhiteQueen() {
            verifyPieceRepresentation(Piece.createWhiteQueen(), Piece.WHITE_QUEEN_REPRESENTATION);
        }

        @Test
        void createBlackKing() {
            verifyPieceRepresentation(Piece.createBlackKing(), Piece.BLACK_KING_REPRESENTATION);
        }

        @Test
        void createWhiteKing() {
            verifyPieceRepresentation(Piece.createWhiteKing(), Piece.WHITE_KING_REPRESENTATION);
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