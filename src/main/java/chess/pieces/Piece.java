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
        return of(PAWN, BLACK, Character.toUpperCase(PAWN.representation));
    }

    public static Piece createWhitePawn() {
        return of(PAWN, WHITE, PAWN.representation);
    }

    public static Piece createBlackKnight() {
        return of(KNIGHT, BLACK, Character.toUpperCase(KNIGHT.representation));
    }

    public static Piece createWhiteKnight() {
        return of(KNIGHT, WHITE, KNIGHT.representation);
    }

    public static Piece createBlackRook() {
        return of(ROOK, BLACK, Character.toUpperCase(ROOK.representation));
    }

    public static Piece createWhiteRook() {
        return of(ROOK, WHITE, ROOK.representation);
    }

    public static Piece createBlackBishop() {
        return of(BISHOP, BLACK, Character.toUpperCase(BISHOP.representation));
    }

    public static Piece createWhiteBishop() {
        return of(BISHOP, WHITE, BISHOP.representation);
    }

    public static Piece createBlackQueen() {
        return of(QUEEN, BLACK, Character.toUpperCase(QUEEN.representation));
    }

    public static Piece createWhiteQueen() {
        return of(QUEEN, WHITE, QUEEN.representation);
    }

    public static Piece createBlackKing() {
        return of(KING, BLACK, Character.toUpperCase(KING.representation));
    }

    public static Piece createWhiteKing() {
        return of(KING, WHITE, KING.representation);
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
        BLACK, WHITE
    }

    public enum Type {
        PAWN('p'),
        KNIGHT('n'),
        ROOK('r'),
        BISHOP('b'),
        QUEEN('q'),
        KING('k');

        private final char representation;

        Type(char representation) {
            this.representation = representation;
        }

        public char getRepresentation() {
            return representation;
        }
    }
}
