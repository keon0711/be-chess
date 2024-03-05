package chess;

import chess.pieces.Piece;

import java.util.ArrayList;
import java.util.List;

import static utils.StringUtils.appendNewLine;

public class Board {

    public static final String BLACK_RANK = "........";

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

    public int size() {
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
        whitePieces.add(Piece.createWhiteKing());
        whitePieces.add(Piece.createWhiteQueen());
        whitePieces.add(Piece.createWhiteBishop());
        whitePieces.add(Piece.createWhiteKnight());
        whitePieces.add(Piece.createWhiteRook());
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
        StringBuilder sb = new StringBuilder();

        sb.append(appendNewLine(getBlackPiecesResult()));
        sb.append(appendNewLine(getBlackPawnsResult()));
        sb.append(appendNewLine(BLACK_RANK));
        sb.append(appendNewLine(BLACK_RANK));
        sb.append(appendNewLine(BLACK_RANK));
        sb.append(appendNewLine(BLACK_RANK));
        sb.append(appendNewLine(getWhitePawnsResult()));
        sb.append(appendNewLine(getWhitePiecesResult()));

        return sb.toString();
    }

    private String getBlackPiecesResult() {
        return getPiecesResult(blackPieces);
    }

    private String getWhitePiecesResult() {
        return getPiecesResult(whitePieces);
    }

    public String getWhitePawnsResult() {
        return getPiecesResult(whitePawns);
    }

    public String getBlackPawnsResult() {
        return getPiecesResult(blackPawns);
    }

    private String getPiecesResult(List<Piece> pieces) {
        StringBuilder sb = new StringBuilder();
        pieces.forEach(piece -> sb.append(piece.getRepresentation()));
        return sb.toString();
    }

    public int pieceCount() {
        return blackPieces.size() + whitePieces.size() + size();
    }
}
