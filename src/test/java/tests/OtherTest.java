package tests;

import org.junit.jupiter.api.*;

import static helpers.Tags.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OtherTest {

    @Test
    @DisplayName("Позитивный тест")
    @Tags({@Tag(SMOKE), @Tag(REGRESS)})
    public void positiveTest1() {
        assertTrue(true);
    }

    @Test
    @DisplayName("Позитивный тест")
    @Tags({@Tag(SMOKE), @Tag(REGRESS)})
    public void positiveTest2() {
        assertTrue(true);
    }

    @Test
    @DisplayName("Позитивный тест")
    @Tags({@Tag(SMOKE)})
    public void positiveTest3() {
        assertFalse(false);
    }

    @Test
    @DisplayName("Позитивный тест")
    @Tags({@Tag(REGRESS)})
    public void positiveTest4() {
        assertFalse(false);
    }

    @Test
    @DisplayName("Негативный тест")
    @Tags({@Tag(REGRESS)})
    public void negativeTest1() {
        assertTrue(false);
    }

    @Test
    @DisplayName("Негативный тест")
    @Tags({@Tag(REGRESS)})
    public void negativeTest2() {
        assertFalse(true);
    }

    @Test
    @Disabled
    @DisplayName("Отключенный тест")
    @Tags({@Tag(SMOKE), @Tag(REGRESS)})
    public void disabledTest1() {
        assertFalse(false);
    }

    @Test
    @Disabled
    @DisplayName("Отключенный тест")
    @Tags({@Tag(SMOKE), @Tag(REGRESS)})
    public void disabledTest2() {
        assertTrue(true);
    }
}
