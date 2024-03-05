package chess.pieces;

public class Piece {

    public static final char BLACK_REPRESENTATION = 'P';
    public static final char WHITE_REPRESENTATION = 'p';

    private final Type type;
    private final Color color;
    private final char representation;

    private Piece(Type type, Color color, char representation) {
        this.color = color;
        this.type = type;
        this.representation = representation;
    }

    public static Piece of(Type type, Color color) {
        char representation = color.equals(Color.BLACK) ? BLACK_REPRESENTATION : WHITE_REPRESENTATION;
        return new Piece(type, color, representation);
    }

    public static Piece createWhitePawn() {
        return of(Type.PAWN, Color.WHITE);
    }

    public static Piece createBlackPawn() {
        return of(Type.PAWN, Color.BLACK);
    }

    public Color getColor() {
        return color;
    }

    public char getRepresentation() {
        return representation;
    }
}
