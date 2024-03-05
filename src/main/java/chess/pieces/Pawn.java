package chess.pieces;

public class Pawn {

    public static final char BLACK_REPRESENTATION = 'P';
    public static final char WHITE_REPRESENTATION = 'p';

    private final Color color;
    private final char representation;

    public Pawn() {
        this.color = Color.WHITE;
        this.representation = WHITE_REPRESENTATION;
    }

    public Pawn(Color color) {
        this.color = color;
        this.representation = color.equals(Color.WHITE) ? WHITE_REPRESENTATION : BLACK_REPRESENTATION;
    }

    public Pawn(Color color, char representation) {
        this.color = color;
        this.representation = representation;
    }

    public Color getColor() {
        return color;
    }

    public char getRepresentation() {
        return representation;
    }
}
