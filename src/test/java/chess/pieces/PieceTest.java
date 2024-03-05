package chess.pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PieceTest {

    @Test
    void createBlackKnight() {
        verifyPiece(Piece.createBlackKnight(), Color.BLACK, Piece.BLACK_KNIGHT_REPRESENTATION);
    }

    @Test
    void createWhiteKnight() {
        verifyPiece(Piece.createWhiteKnight(), Color.WHITE, Piece.WHITE_KNIGHT_REPRESENTATION);
    }

    @Test
    void createBlackRook() {
        verifyPiece(Piece.createBlackRook(), Color.BLACK, Piece.BLACK_ROOK_REPRESENTATION);
    }

    @Test
    void createWhiteRook() {
        verifyPiece(Piece.createWhiteRook(), Color.WHITE, Piece.WHITE_ROOK_REPRESENTATION);
    }

    @Test
    void createBlackBishop() {
        verifyPiece(Piece.createBlackBishop(), Color.BLACK, Piece.BLACK_BISHOP_REPRESENTATION);
    }

    @Test
    void createWhiteBishop() {
        verifyPiece(Piece.createWhiteBishop(), Color.WHITE, Piece.WHITE_BISHOP_REPRESENTATION);
    }

    @Test
    void createBlackQueen() {
        verifyPiece(Piece.createBlackQueen(), Color.BLACK, Piece.BLACK_QUEEN_REPRESENTATION);
    }

    @Test
    void createWhiteQueen() {
        verifyPiece(Piece.createWhiteQueen(), Color.WHITE, Piece.WHITE_QUEEN_REPRESENTATION);
    }

    @Test
    void createBlackKing() {
        verifyPiece(Piece.createBlackKing(), Color.BLACK, Piece.BLACK_KING_REPRESENTATION);
    }

    @Test
    void createWhiteKing() {
        verifyPiece(Piece.createWhiteKing(), Color.WHITE, Piece.WHITE_KING_REPRESENTATION);
    }

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

    private void verifyPiece(final Piece piece, final Color color, final char representation) {
        assertThat(piece.getColor()).isEqualTo(color);
        assertThat(piece.getRepresentation()).isEqualTo(representation);
    }

}