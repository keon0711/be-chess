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
    @DisplayName("보드에 폰을 추가할 수 있다")
    void create() {
        Pawn white = new Pawn(Color.WHITE, Pawn.WHITE_REPRESENTATION);
        board.addWhite(white);
        assertThat(board.size()).isEqualTo(1);
        assertThat(board.findWhitePawn(0)).isEqualTo(white);

        Pawn black = new Pawn(Color.BLACK, Pawn.BLACK_REPRESENTATION);
        board.addBlack(black);
        assertThat(board.size()).isEqualTo(2);
        assertThat(board.findBlackPawn(0)).isEqualTo(black);
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
}
