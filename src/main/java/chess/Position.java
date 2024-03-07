package chess;

public record Position(int row, int column) {

    public static final int COLUMN_INDEX = 0;
    public static final int ROW_INDEX = 1;

    public static Position of(String position) {
        return new Position(calcRow(position), calcColumn(position));
    }

    private static int calcRow(String position) {
        return Rank.MAX_RANK_SIZE - Character.getNumericValue(position.charAt(ROW_INDEX));
    }

    private static int calcColumn(String position) {
        return position.charAt(COLUMN_INDEX) - 'a';
    }

}
