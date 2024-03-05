package chess;

import chess.pieces.Color;
import chess.pieces.Pawn;

import java.util.ArrayList;
import java.util.List;

public class Board {

    public static final String BLANK_ROW = "........";
    private final List<Pawn> blackPawns = new ArrayList<>();
    private final List<Pawn> whitePawns = new ArrayList<>();

    public void addWhite(Pawn pawn) {
        whitePawns.add(pawn);
    }

    public void addBlack(Pawn pawn) {
        blackPawns.add(pawn);
    }

    public int size() {
        return blackPawns.size() + whitePawns.size();
    }

    public Pawn findWhitePawn(int index) {
        return whitePawns.get(index);
    }

    public Pawn findBlackPawn(int index) {
        return blackPawns.get(index);
    }

    public void initialize() {
        initBlackPawn();
        initWhitePawn();
    }

    private void initBlackPawn() {
        for (int i = 0; i < 8; i++) {
            blackPawns.add(new Pawn(Color.BLACK, Pawn.BLACK_REPRESENTATION));
        }
    }

    private void initWhitePawn() {
        for (int i = 0; i < 8; i++) {
            whitePawns.add(new Pawn(Color.WHITE, Pawn.WHITE_REPRESENTATION));
        }
    }


    public void print() {
        System.out.println(getBoard());
    }

    public String getBoard() {
        StringBuilder sb = new StringBuilder();

        sb.append(BLANK_ROW).append('\n');
        sb.append(getBlackPawnsResult()).append('\n');
        sb.append(BLANK_ROW).append('\n');
        sb.append(BLANK_ROW).append('\n');
        sb.append(BLANK_ROW).append('\n');
        sb.append(BLANK_ROW).append('\n');
        sb.append(getWhitePawnsResult()).append('\n');
        sb.append(BLANK_ROW).append('\n');

        return sb.toString();
    }

    public String getWhitePawnsResult() {
        StringBuilder sb = new StringBuilder();
        whitePawns.forEach(pawn -> sb.append(pawn.getRepresentation()));
        return sb.toString();
    }

    public String getBlackPawnsResult() {
        StringBuilder sb = new StringBuilder();
        blackPawns.forEach(pawn -> sb.append(pawn.getRepresentation()));
        return sb.toString();
    }

}
