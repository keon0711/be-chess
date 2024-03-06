package chess;

import chess.pieces.Piece;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;
import static utils.StringUtils.appendNewLine;

public class BoardTest {

    public static final String BLACK_PIECES_REPRESENTATION = "RNBQKBNR";
    public static final String BLACK_PAWNS_REPRESENTATION = "PPPPPPPP";
    public static final String WHITE_PAWNS_REPRESENTATION = "pppppppp";
    public static final String WHITE_PIECES_REPRESENTATION = "rnbkqbnr";
    public static final int ALL_PIECE_COUNT = 32;

    Board board;

    @BeforeEach
    void init() {
        board = new Board();
    }

    @Test
    @DisplayName("추가한 흰색 폰을 보드에서 얻을 수 있다")
    void findWhitePawn() {
        Piece white = Piece.createWhitePawn();
        board.addWhite(white);
        assertThat(board.findWhitePawn(0)).isEqualTo(white);
    }

    @Test
    @DisplayName("추가한 검은색 폰을 보드에서 얻을 수 있다")
    void findBlackPawn() {
        Piece black = Piece.createBlackPawn();
        board.addBlack(black);
        assertThat(board.findBlackPawn(0)).isEqualTo(black);
    }

    @Test
    @DisplayName("추가한 폰 개수를 얻을 수 있다.")
    void getPawnsSize() {
        Piece white = Piece.createWhitePawn();
        board.addWhite(white);
        Piece black = Piece.createBlackPawn();
        board.addBlack(black);

        assertThat(board.pawnCount()).isEqualTo(2);
    }

    @Nested
    @DisplayName("보드를 초기화하면")
    class initBoard {

        @BeforeEach
        void init() {
            board = new Board();
            board.initialize();
        }

        @Test
        @DisplayName("검은색 Pawn이 생성되어야 한다.")
        void initBlackPawns() {
            assertThat(board.getBlackPawnsRepresentation()).isEqualTo(BLACK_PAWNS_REPRESENTATION);
        }

        @Test
        @DisplayName("흰색 Pawn이 생성되어야 한다.")
        void initWhitePawns() {
            assertThat(board.getWhitePawnsRepresentation()).isEqualTo(WHITE_PAWNS_REPRESENTATION);
        }

        @Test
        @DisplayName("결과를 출력할 수 있어야 한다.")
        void printBoard() {
            System.out.println(board.getBoard());
        }

        @Test
        @DisplayName("총 기물 수는 32개여야 한다.")
        void pieceCount() {
            assertThat(board.pieceCount()).isEqualTo(ALL_PIECE_COUNT);
        }

        @Test
        @DisplayName("기물들이 배치되어야 한다.")
        public void placeAllPiece() {
            String blankRank = appendNewLine(Board.BLACK_RANK);

            assertThat(board.getBoard()).isEqualTo(
                    appendNewLine(BLACK_PIECES_REPRESENTATION) +
                            appendNewLine(BLACK_PAWNS_REPRESENTATION) +
                            blankRank + blankRank + blankRank + blankRank +
                            appendNewLine(WHITE_PAWNS_REPRESENTATION) +
                            appendNewLine(WHITE_PIECES_REPRESENTATION));
        }
    }
}
