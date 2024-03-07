package chess;

public record Position(int row, int column) {

    public static Position of(String position) {
        return new Position(calcRow(position), calcColumn(position));
    }

    private static int calcRow(String position) {
        return Rank.RANK_SIZE - Character.getNumericValue(position.charAt(1));
    }

    private static int calcColumn(String position) {
        return position.charAt(0) - 'a';
    }

}
