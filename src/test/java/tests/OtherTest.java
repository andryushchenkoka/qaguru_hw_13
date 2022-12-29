package tests;

import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.open;
import static helpers.Tags.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OtherTest extends TestBase {

    @Test
    @DisplayName("Позитивный тест")
    @Tags({@Tag(SMOKE), @Tag(REGRESS)})
    public void positiveTest1() {
        open("");
        assertTrue(true);
    }

    @Test
    @DisplayName("Позитивный тест")
    @Tags({@Tag(SMOKE), @Tag(REGRESS)})
    public void positiveTest2() {
        open("");
        assertTrue(true);
    }

    @Test
    @DisplayName("Позитивный тест")
    @Tags({@Tag(SMOKE)})
    public void positiveTest3() {
        open("");
        assertFalse(false);
    }

    @Test
    @DisplayName("Позитивный тест")
    @Tags({@Tag(REGRESS)})
    public void positiveTest4() {
        open("");
        assertFalse(false);
    }

    @Test
    @DisplayName("Негативный тест")
    @Tags({@Tag(REGRESS)})
    public void negativeTest1() {
        open("");
        assertTrue(false);
    }

    @Test
    @DisplayName("Негативный тест")
    @Tags({@Tag(REGRESS)})
    public void negativeTest2() {
        open("");
        assertFalse(true);
    }

    @Test
    @Disabled
    @DisplayName("Отключенный тест")
    @Tags({@Tag(SMOKE), @Tag(REGRESS)})
    public void disabledTest1() {
        open("");
        assertFalse(false);
    }

    @Test
    @Disabled
    @DisplayName("Отключенный тест")
    @Tags({@Tag(SMOKE), @Tag(REGRESS)})
    public void disabledTest2() {
        open("");
        assertTrue(true);
    }
}
