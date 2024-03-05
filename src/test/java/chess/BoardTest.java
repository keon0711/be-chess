package chess;

import chess.pieces.Color;
import chess.pieces.Pawn;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

public class BoardTest {

    Board board;

    @BeforeEach
    void init() {
        board = new Board();
    }

    @Test
    @DisplayName("보드에 폰을 추가할 수 있다")
    void create() {
        verifyAdd(new Pawn(Color.WHITE), 1);
        verifyAdd(new Pawn(Color.BLACK), 2);
    }

    @Test
    @DisplayName("Pawn 이외의 객체를 넣으면 컴파일 에러 발생")
    void compileErrorTest() {
        assertThatCode(() -> {
            Method addMethod = Board.class.getMethod("add", Pawn.class);
            addMethod.invoke(board, new String());
        }).isInstanceOf(IllegalArgumentException.class);
    }


    private void verifyAdd(Pawn pawn, int expectedSize) {
        board.add(pawn);

        assertThat(board.size()).isEqualTo(expectedSize);
        assertThat(board.findPawn(expectedSize - 1)).isEqualTo(pawn);
    }
}
