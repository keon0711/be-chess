package chess.pieces;

import java.util.List;
import java.util.Objects;

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

    public boolean isSameType(Type type) {
        return this.type == type;
    }

    public double getPoint(List<Piece> pieces) {
        if (type != PAWN) {
            return type.getDefaultPoint();
        }

        return getPawnPoint(pieces);
    }

    private double getPawnPoint(List<Piece> pieces) {
        if (containsOtherPawn(pieces)) {
            return Type.DECREASED_PAWN_POINT;
        }
        return type.getDefaultPoint();
    }

    private boolean containsOtherPawn(List<Piece> pieces) {
        for (Piece piece : pieces) {
            if (piece != this && piece.equals(this)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Piece piece = (Piece) o;
        return representation == piece.representation && type == piece.type && color == piece.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, color, representation);
    }

    public boolean isSameColor(Color color) {
        return this.color == color;
    }

    public double getDefaultPoint() {
        return type.getDefaultPoint();
    }

    public enum Color {
        BLACK, WHITE, NOCOLOR
    }

    public enum Type {
        PAWN('p', 1.0),
        KNIGHT('n', 2.5),
        ROOK('r', 5.0),
        BISHOP('b', 3.0),
        QUEEN('q', 9.0),
        KING('k', 0.0),
        NO_PIECE('.', 0.0);

        private static final double DECREASED_PAWN_POINT = 0.5;

        private final char representation;
        private final double defaultPoint;

        Type(char representation, double defaultPoint) {
            this.representation = representation;
            this.defaultPoint = defaultPoint;
        }

        public char getRepresentation() {
            return representation;
        }

        public double getDefaultPoint() {
            return defaultPoint;
        }
    }
}
