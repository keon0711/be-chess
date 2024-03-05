package chess;

import chess.pieces.Color;
import chess.pieces.Pawn;
import utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

import static utils.StringUtils.*;

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
            addBlack(new Pawn(Color.BLACK, Pawn.BLACK_REPRESENTATION));
        }
    }

    private void initWhitePawn() {
        for (int i = 0; i < 8; i++) {
            addWhite(new Pawn(Color.WHITE, Pawn.WHITE_REPRESENTATION));
        }
    }


    public void print() {
        System.out.println(getBoard());
    }

    public String getBoard() {
        StringBuilder sb = new StringBuilder();

        sb.append(appendNewLine(BLANK_ROW));
        sb.append(getBlackPawnsResult());
        sb.append(appendNewLine(BLANK_ROW));
        sb.append(appendNewLine(BLANK_ROW));
        sb.append(appendNewLine(BLANK_ROW));
        sb.append(appendNewLine(BLANK_ROW));
        sb.append(getWhitePawnsResult());
        sb.append(appendNewLine(BLANK_ROW));

        return sb.toString();
    }

    public String getWhitePawnsResult() {
        return getPawnsResult(whitePawns);
    }

    public String getBlackPawnsResult() {
        return getPawnsResult(blackPawns);
    }

    private String getPawnsResult(List<Pawn> pawns) {
        StringBuilder sb = new StringBuilder();
        pawns.forEach(pawn -> sb.append(pawn.getRepresentation()));
        return sb.toString();
    }

}
