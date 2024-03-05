package chess.pieces;

public class Piece {

    public static final char BLACK_PAWN_REPRESENTATION = 'P';
    public static final char BLACK_KNIGHT_REPRESENTATION = 'N';
    public static final char BLACK_ROOK_REPRESENTATION = 'R';
    public static final char BLACK_BISHOP_REPRESENTATION = 'B';
    public static final char BLACK_QUEEN_REPRESENTATION = 'Q';
    public static final char BLACK_KING_REPRESENTATION = 'K';
    public static final char WHITE_PAWN_REPRESENTATION = 'p';
    public static final char WHITE_KNIGHT_REPRESENTATION = 'n';
    public static final char WHITE_ROOK_REPRESENTATION = 'r';
    public static final char WHITE_BISHOP_REPRESENTATION = 'b';
    public static final char WHITE_QUEEN_REPRESENTATION = 'q';
    public static final char WHITE_KING_REPRESENTATION = 'k';

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
        return of(Type.PAWN, Color.BLACK, BLACK_PAWN_REPRESENTATION);
    }

    public static Piece createWhitePawn() {
        return of(Type.PAWN, Color.WHITE, WHITE_PAWN_REPRESENTATION);
    }

    public static Piece createBlackKnight() {
        return of(Type.KNIGHT, Color.BLACK, BLACK_KNIGHT_REPRESENTATION);
    }

    public static Piece createWhiteKnight() {
        return of(Type.KNIGHT, Color.WHITE, WHITE_KNIGHT_REPRESENTATION);
    }

    public static Piece createBlackRook() {
        return of(Type.ROOK, Color.BLACK, BLACK_ROOK_REPRESENTATION);
    }

    public static Piece createWhiteRook() {
        return of(Type.ROOK, Color.WHITE, WHITE_ROOK_REPRESENTATION);
    }

    public static Piece createBlackBishop() {
        return of(Type.BISHOP, Color.BLACK, BLACK_BISHOP_REPRESENTATION);
    }

    public static Piece createWhiteBishop() {
        return of(Type.BISHOP, Color.WHITE, WHITE_BISHOP_REPRESENTATION);
    }

    public static Piece createBlackQueen() {
        return of(Type.QUEEN, Color.BLACK, BLACK_QUEEN_REPRESENTATION);
    }

    public static Piece createWhiteQueen() {
        return of(Type.QUEEN, Color.WHITE, WHITE_QUEEN_REPRESENTATION);
    }

    public static Piece createBlackKing() {
        return of(Type.KING, Color.BLACK, BLACK_KING_REPRESENTATION);
    }

    public static Piece createWhiteKing() {
        return of(Type.KING, Color.WHITE, WHITE_KING_REPRESENTATION);
    }

    public Color getColor() {
        return color;
    }

    public char getRepresentation() {
        return representation;
    }

    public boolean isBlack() {
        return color == Color.BLACK;
    }

    public boolean isWhite() {
        return color == Color.WHITE;
    }
}
