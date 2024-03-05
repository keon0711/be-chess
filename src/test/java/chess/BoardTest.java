package chess;

import chess.pieces.Piece;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static utils.StringUtils.appendNewLine;

public class BoardTest {

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

        assertThat(board.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("보드를 초기화하면 검은색 Pawn이 생성되어야 한다.")
    void initBlackPawns() {
        board.initialize();
        assertThat(board.getBlackPawnsResult()).isEqualTo("PPPPPPPP");
    }

    @Test
    @DisplayName("보드를 초기화하면 흰색 Pawn이 생성되어야 한다.")
    void initWhitePawns() {
        board.initialize();
        assertThat(board.getWhitePawnsResult()).isEqualTo("pppppppp");
    }

    @Test
    @DisplayName("보드를 초기화한 결과를 출력할 수 있어야 한다.")
    void printBoard() {
        board.initialize();
        System.out.println(board.getBoard());
    }

    @Test
    public void create() {
        board.initialize();
        assertThat(board.pieceCount()).isEqualTo(32);

        String blankRank = appendNewLine(Board.BLACK_RANK);
        assertThat(board.getBoard()).isEqualTo(
                appendNewLine("RNBQKBNR") +
                appendNewLine("PPPPPPPP") +
                blankRank + blankRank + blankRank + blankRank +
                appendNewLine("pppppppp") +
                appendNewLine("rnbkqbnr"));
    }

}
