package chess;

public record Position(int row, int column) {

    public static final int FILE_INDEX = 0;
    public static final int RANK_INDEX = 1;
    public static final char MIN_FILE = 'a';
    public static final char MAX_FILE = 'h';
    public static final char MIN_RANK = '1';
    public static final char MAX_RANK = '8';

    public static Position of(String position) {
        return new Position(calcRow(position), calcColumn(position));
    }

    private static int calcRow(String position) {
        validate(position);
        return Rank.MAX_RANK_SIZE - Character.getNumericValue(position.charAt(RANK_INDEX));
    }

    private static int calcColumn(String position) {
            return position.charAt(FILE_INDEX) - MIN_FILE;
    }


    private static void validate(String position) {
        if (position.charAt(FILE_INDEX) < MIN_FILE || position.charAt(FILE_INDEX) > MAX_FILE) {
            throw new IllegalArgumentException("체스판의 랭크 좌표는 a~h 여야합니다.");
        }
        if (position.charAt(RANK_INDEX) < MIN_RANK || position.charAt(RANK_INDEX) > MAX_RANK) {
            throw new IllegalArgumentException("체스판의 파일 좌표는 1~8 여야합니다.");
        }
    }

}
