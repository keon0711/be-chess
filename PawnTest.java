import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PawnTest {

    @Test
    @DisplayName("흰색 폰이 생성되어야 한다")
    void create() {
        Pawn whitePawn = new Pawn("white");
        Assertions.assertThat(whitePawn.getColor()).isEqualTo("white");

        Pawn blackPawn = new Pawn("black");
        Assertions.assertThat(blackPawn.getColor()).isEqualTo("black");
    }
}
