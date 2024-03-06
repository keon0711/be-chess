package chess;

import chess.pieces.Piece;
import chess.pieces.Piece.Color;
import chess.pieces.Piece.Type;
import utils.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Board {

    public static final String BLACK_RANK = "........";

    private final List<Rank> board = new ArrayList<>();
    private final List<Piece> blackPieces = new ArrayList<>();
    private final List<Piece> blackPawns = new ArrayList<>();
    private final List<Piece> whitePieces = new ArrayList<>();
    private final List<Piece> whitePawns = new ArrayList<>();

    public void addWhite(Piece pawn) {
        whitePawns.add(pawn);
    }

    public void addBlack(Piece pawn) {
        blackPawns.add(pawn);
    }

    public int pawnCount() {
        return blackPawns.size() + whitePawns.size();
    }

    public Piece findWhitePawn(int index) {
        return whitePawns.get(index);
    }

    public Piece findBlackPawn(int index) {
        return blackPawns.get(index);
    }

    public void initialize() {
        initBlackPieces();
        initBlackPawn();
        initWhitePieces();
        initWhitePawn();

        board.add(new Rank(blackPieces));
        board.add(new Rank(blackPawns));
        board.add(new Rank(createBlankPieces()));
        board.add(new Rank(createBlankPieces()));
        board.add(new Rank(createBlankPieces()));
        board.add(new Rank(createBlankPieces()));
        board.add(new Rank(whitePawns));
        board.add(new Rank(whitePieces));

    }

    private void initBlackPieces() {
        blackPieces.add(Piece.createBlackRook());
        blackPieces.add(Piece.createBlackKnight());
        blackPieces.add(Piece.createBlackBishop());
        blackPieces.add(Piece.createBlackQueen());
        blackPieces.add(Piece.createBlackKing());
        blackPieces.add(Piece.createBlackBishop());
        blackPieces.add(Piece.createBlackKnight());
        blackPieces.add(Piece.createBlackRook());
    }

    private void initWhitePieces() {
        whitePieces.add(Piece.createWhiteRook());
        whitePieces.add(Piece.createWhiteKnight());
        whitePieces.add(Piece.createWhiteBishop());
        whitePieces.add(Piece.createWhiteQueen());
        whitePieces.add(Piece.createWhiteKing());
        whitePieces.add(Piece.createWhiteBishop());
        whitePieces.add(Piece.createWhiteKnight());
        whitePieces.add(Piece.createWhiteRook());
    }

    private List<Piece> createBlankPieces() {
        List<Piece> blankPieces = new ArrayList<>();

        for (int i = 0; i < Rank.RANK_SIZE; i++) {
            blankPieces.add(Piece.createBlank());
        }
        return blankPieces;
    }

    private void initBlackPawn() {
        for (int i = 0; i < 8; i++) {
            addBlack(Piece.createBlackPawn());
        }
    }

    private void initWhitePawn() {
        for (int i = 0; i < 8; i++) {
            addWhite(Piece.createWhitePawn());
        }
    }

    public void print() {
        System.out.println(getBoard());
    }

    public String getBoard() {
        return board.stream()
                .map(Rank::toString)
                .map(StringUtils::appendNewLine)
                .collect(Collectors.joining());
    }

    public String getWhitePawnsRepresentation() {
        return getPiecesRepresentation(whitePawns);
    }

    public String getBlackPawnsRepresentation() {
        return getPiecesRepresentation(blackPawns);
    }

    private String getPiecesRepresentation(List<Piece> pieces) {
        StringBuilder sb = new StringBuilder();
        pieces.forEach(piece -> sb.append(piece.getRepresentation()));
        return sb.toString();
    }

    public int pieceCount() {
        return blackPieces.size() + whitePieces.size() + pawnCount();
    }

    public int count(Color color, Type type) {
        return board.stream()
                .mapToInt(rank -> rank.count(color,type))
                .sum();
    }
}
