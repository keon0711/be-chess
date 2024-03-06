package chess;

import chess.pieces.Color;
import chess.pieces.Pawn;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BoardTest {

    Board board;

    @BeforeEach
    void init() {
        board = new Board();
    }

    @Test
    @DisplayName("추가한 흰색 폰을 보드에서 얻을 수 있다")
    void findWhitePawn() {
        Pawn white = new Pawn(Color.WHITE, Pawn.WHITE_REPRESENTATION);
        board.addWhite(white);
        assertThat(board.findWhitePawn(0)).isEqualTo(white);
    }

    @Test
    @DisplayName("추가한 검은색 폰을 보드에서 얻을 수 있다")
    void findBlackPawn() {
        Pawn black = new Pawn(Color.BLACK, Pawn.BLACK_REPRESENTATION);
        board.addBlack(black);
        assertThat(board.findBlackPawn(0)).isEqualTo(black);
    }

    @Test
    @DisplayName("추가한 폰 개수를 얻을 수 있다.")
    void getPawnsSize() {
        Pawn white = new Pawn(Color.WHITE, Pawn.WHITE_REPRESENTATION);
        board.addWhite(white);
        Pawn black = new Pawn(Color.BLACK, Pawn.BLACK_REPRESENTATION);
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

}
