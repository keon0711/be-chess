package chess;

import chess.pieces.Piece;
import chess.pieces.Piece.Color;
import chess.pieces.Piece.Type;

import java.util.List;
import java.util.stream.Collectors;

public class Rank {

    public static final int MAX_RANK_SIZE = 8;
    public static final int MIN_RANK_SIZE = 0;

    private final List<Piece> rank;

    public Rank(List<Piece> rank) {
        this.rank = rank;
    }

    public Piece findPieceByColumn(int column) {
        return rank.get(column);
    }

    @Override
    public String toString() {
        return rank.stream()
                .map(Piece::getRepresentation)
                .map(c -> c.toString())
                .collect(Collectors.joining());
    }

    public int count(Color color, Type type) {
        return (int) rank.stream()
                .filter(piece -> piece.getColor() == color)
                .filter(piece -> piece.isSameType(type))
                .count();
    }

    public void clear() {
        for (int i = MIN_RANK_SIZE; i < MAX_RANK_SIZE; i++) {
            rank.set(i, Piece.createBlank());
        }
    }

    public void move(int column, Piece piece) {
        rank.set(column, piece);
    }
}
