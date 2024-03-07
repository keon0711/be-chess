package chess;

import chess.pieces.Piece;
import chess.pieces.Piece.Color;
import chess.pieces.Piece.Type;

import java.util.List;
import java.util.stream.Collectors;

public class Rank {

    public static final int RANK_SIZE = 8;

    private final List<Piece> rank;

    public Rank(List<Piece> rank) {
        this.rank = rank;
    }

    public Piece getPieceByColumn(int column) {
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
}
