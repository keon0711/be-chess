package chess;

import chess.pieces.Piece;
import chess.pieces.Piece.Color;
import chess.pieces.Piece.Type;
import utils.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Board {

    public static final String BLANK_RANK = "........";
    public static final int MIN_FILE_INDEX = 0;
    public static final int MAX_FILE_INDEX = 8;

    private final List<Rank> board = new ArrayList<>();

    public void initialize() {
        board.add(new Rank(createBlackPieces()));
        board.add(new Rank(createBlackPawns()));
        board.add(new Rank(createBlankPieces()));
        board.add(new Rank(createBlankPieces()));
        board.add(new Rank(createBlankPieces()));
        board.add(new Rank(createBlankPieces()));
        board.add(new Rank(createWhitePawns()));
        board.add(new Rank(createWhitePieces()));
    }

    private List<Piece> createBlackPieces() {
        List<Piece> blackPieces = new ArrayList<>();

        blackPieces.add(Piece.createBlackRook());
        blackPieces.add(Piece.createBlackKnight());
        blackPieces.add(Piece.createBlackBishop());
        blackPieces.add(Piece.createBlackQueen());
        blackPieces.add(Piece.createBlackKing());
        blackPieces.add(Piece.createBlackBishop());
        blackPieces.add(Piece.createBlackKnight());
        blackPieces.add(Piece.createBlackRook());

        return blackPieces
                ;
    }

    private List<Piece> createWhitePieces() {
        List<Piece> whitePieces = new ArrayList<>();

        whitePieces.add(Piece.createWhiteRook());
        whitePieces.add(Piece.createWhiteKnight());
        whitePieces.add(Piece.createWhiteBishop());
        whitePieces.add(Piece.createWhiteQueen());
        whitePieces.add(Piece.createWhiteKing());
        whitePieces.add(Piece.createWhiteBishop());
        whitePieces.add(Piece.createWhiteKnight());
        whitePieces.add(Piece.createWhiteRook());

        return whitePieces;
    }

    private List<Piece> createBlankPieces() {
        List<Piece> blankPieces = new ArrayList<>();

        for (int i = MIN_FILE_INDEX; i < MAX_FILE_INDEX; i++) {
            blankPieces.add(Piece.createBlank());
        }
        return blankPieces;
    }

    private List<Piece> createBlackPawns() {
        List<Piece> blackPawns = new ArrayList<>();
        for (int i = MIN_FILE_INDEX; i < MAX_FILE_INDEX; i++) {
            blackPawns.add(Piece.createBlackPawn());
        }
        return blackPawns;
    }

    private List<Piece> createWhitePawns() {
        List<Piece> whitePawns = new ArrayList<>();
        for (int i = MIN_FILE_INDEX; i < MAX_FILE_INDEX; i++) {
            whitePawns.add(Piece.createWhitePawn());
        }
        return whitePawns;
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

    public int count(Color color, Type type) {
        return board.stream()
                .mapToInt(rank -> rank.count(color,type))
                .sum();
    }

    public Piece findPieceByPosition(Position position) {
        Rank rank = board.get(position.row());
        return rank.findPieceByColumn(position.column());
    }

    public void clear() {
        board.forEach(Rank::clear);
    }

    public void move(Position position, Piece piece) {
        Rank rank = board.get(position.row());
        rank.move(position.column(), piece);
    }

    public double calculateBlackScore() {
        return calculateScore(Color.BLACK);
    }

    public double calculateWhiteScore() {
        return calculateScore(Color.WHITE);
    }

    private double calculateScore(Color color) {
        // 색깔 인자 추가해서 색깔별 점수 계산
        double totalScore = 0;

        for (int i = MIN_FILE_INDEX; i < MAX_FILE_INDEX; i++) {
            List<Piece> pieces = getPiecesInFile(i);
            totalScore += getFileScore(color, pieces);
        }
        return totalScore;
    }

    private static double getFileScore(Color color, List<Piece> pieces) {
        double fileScore = 0;

        for (Piece piece : pieces) {
            if (piece.isSameColor(color))
                fileScore += piece.getPoint(pieces);
        }
        return fileScore;
    }

    private List<Piece> getPiecesInFile(int fileIndex) {
        List<Piece> pieces = new ArrayList<>();
        board.forEach(rank -> pieces.add(rank.findPieceByColumn(fileIndex)));
        return pieces;
    }
}
