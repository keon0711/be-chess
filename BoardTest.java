import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BoardTest {

    @Test
    void create() {
        Board board = new Board();

        Pawn white = new Pawn(Pawn.WHITE_COLOR);
        board.add(white);
        assertThat(board.size()).isEqualTo(1);
        assertThat(board.findPawn(0)).isEqualTo(white);

        Pawn black = new Pawn(Pawn.WHITE_COLOR);
        board.add(black);
        assertThat(board.size()).isEqualTo(2);
        assertThat(board.findPawn(1)).isEqualTo(black);
    }
}
