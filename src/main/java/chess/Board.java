package chess;

import chess.pieces.Color;
import chess.pieces.Piece;

import java.util.ArrayList;
import java.util.List;

import static utils.StringUtils.appendNewLine;

public class Board {

    public static final String BLANK_ROW = "........";
    private final List<Piece> blackPawns = new ArrayList<>();
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
        initBlackPawn();
        initWhitePawn();
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

        sb.append(appendNewLine(BLANK_ROW));
        sb.append(appendNewLine(getBlackPawnsResult()));
        sb.append(appendNewLine(BLANK_ROW));
        sb.append(appendNewLine(BLANK_ROW));
        sb.append(appendNewLine(BLANK_ROW));
        sb.append(appendNewLine(BLANK_ROW));
        sb.append(appendNewLine(getWhitePawnsResult()));
        sb.append(appendNewLine(BLANK_ROW));

        return sb.toString();
    }

    public String getWhitePawnsResult() {
        return getPawnsResult(whitePawns);
    }

    public String getBlackPawnsResult() {
        return getPawnsResult(blackPawns);
    }

    private String getPawnsResult(List<Piece> pawns) {
        StringBuilder sb = new StringBuilder();
        pawns.forEach(pawn -> sb.append(pawn.getRepresentation()));
        return sb.toString();
    }

}
