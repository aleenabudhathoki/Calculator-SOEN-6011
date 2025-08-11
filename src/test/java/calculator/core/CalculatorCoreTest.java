package calculator.core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorCoreTest {

    private static final double DELTA = 1e-6;

    @Test
    void testArccosAt1() {
        assertEquals(0.0, CalculatorCore.computeArccos(1.0), DELTA);
    }

    @Test
    void testArccosAtMinus1() {
        assertEquals(Math.PI, CalculatorCore.computeArccos(-1.0), DELTA);
    }

    @Test
    void testArccosAtZero() {
        assertEquals(Math.PI / 2.0, CalculatorCore.computeArccos(0.0), DELTA);
    }

    @Test
    void testArccosAtHalf() {
        assertEquals(Math.acos(0.5), CalculatorCore.computeArccos(0.5), DELTA);
    }

    @Test
    void testValidateInputValid() {
        assertDoesNotThrow(() -> CalculatorCore.validateInput(0.75));
    }

    @Test
    void testValidateInputInvalidHigh() {
        assertThrows(DomainException.class, () -> CalculatorCore.validateInput(1.5));
    }

    @Test
    void testValidateInputInvalidLow() {
        assertThrows(DomainException.class, () -> CalculatorCore.validateInput(-1.1));
    }
}
