import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PawnTest {

    @Test
    @DisplayName("흰색 폰이 생성되어야 한다")
    void createWhitePawn() {
        verifyPawn("white");
    }

    @Test
    @DisplayName("검은색 폰이 생성되어야 한다")
    void createBlackPawn() {
        verifyPawn("black");
    }

    @Test
    @DisplayName("기본 생성자는 흰색 폰을 생성해야 한다.")
    void defaultConstructor() {
        Pawn pawn = new Pawn();
        assertThat(pawn.getColor()).isEqualTo("white");
    }

    private void verifyPawn(final String color) {

        Pawn pawn = new Pawn(color);
        assertThat(pawn.getColor()).isEqualTo(color);
    }
}
