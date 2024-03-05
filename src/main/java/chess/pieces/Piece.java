package chess.pieces;

public class Piece {

    public static final char BLACK_REPRESENTATION = 'P';
    public static final char WHITE_REPRESENTATION = 'p';

    private final Color color;
    private final Type type;
    private final char representation;

    private Piece(Color color, Type type, char representation) {
        this.color = color;
        this.type = type;
        this.representation = representation;
    }

    public static Piece of(Color color, Type name) {
        char representation = color.equals(Color.BLACK) ? BLACK_REPRESENTATION : WHITE_REPRESENTATION;
        return new Piece(color, name, representation);
    }

    public static Piece createWhitePawn() {
        return of(Color.WHITE, Type.PAWN);
    }

    public static Piece createBlackPawn() {
        return of(Color.BLACK, Type.PAWN);
    }

    public Color getColor() {
        return color;
    }

    public char getRepresentation() {
        return representation;
    }
}
