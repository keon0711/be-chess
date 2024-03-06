package chess.pieces;

import static chess.pieces.Piece.Color.*;
import static chess.pieces.Piece.Type.*;

public class Piece {

    private final Type type;
    private final Color color;
    private final char representation;

    private Piece(Type type, Color color, char representation) {
        this.color = color;
        this.type = type;
        this.representation = representation;
    }

    public static Piece of(Type type, Color color, char representation) {
        return new Piece(type, color, representation);
    }

    public static Piece createBlackPawn() {
        return createBlack(PAWN);
    }

    public static Piece createWhitePawn() {
        return createWhite(PAWN);
    }

    public static Piece createBlackKnight() {
        return createBlack(KNIGHT);
    }

    public static Piece createWhiteKnight() {
        return createWhite(KNIGHT);
    }

    public static Piece createBlackRook() {
        return createBlack(ROOK);
    }

    public static Piece createWhiteRook() {
        return createWhite(ROOK);
    }

    public static Piece createBlackBishop() {
        return createBlack(BISHOP);
    }

    public static Piece createWhiteBishop() {
        return createWhite(BISHOP);
    }

    public static Piece createBlackQueen() {
        return createBlack(QUEEN);
    }

    public static Piece createWhiteQueen() {
        return createWhite(QUEEN);
    }

    public static Piece createBlackKing() {
        return createBlack(KING);
    }

    public static Piece createWhiteKing() {
        return createWhite(KING);
    }

    public static Piece createBlank() {
        return of(NO_PIECE, NOCOLOR, NO_PIECE.representation);
    }

    private static Piece createWhite(Type type) {
        return of(type, WHITE, type.representation);
    }

    private static Piece createBlack(Type type) {
        return of(type, BLACK, Character.toUpperCase(type.representation));
    }

    public Color getColor() {
        return color;
    }

    public char getRepresentation() {
        return representation;
    }

    public boolean isBlack() {
        return color == BLACK;
    }

    public boolean isWhite() {
        return color == WHITE;
    }

    public enum Color {
        BLACK, WHITE, NOCOLOR
    }

    public enum Type {
        PAWN('p'),
        KNIGHT('n'),
        ROOK('r'),
        BISHOP('b'),
        QUEEN('q'),
        KING('k'),
        NO_PIECE('.');

        private final char representation;

        Type(char representation) {
            this.representation = representation;
        }

        public char getRepresentation() {
            return representation;
        }
    }
}
