package chess.pieces;

import org.junit.jupiter.api.Test;

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

    private void verifyPiece(final Piece piece, final Color color, final char representation) {
        assertThat(piece.getColor()).isEqualTo(color);
        assertThat(piece.getRepresentation()).isEqualTo(representation);
    }

}