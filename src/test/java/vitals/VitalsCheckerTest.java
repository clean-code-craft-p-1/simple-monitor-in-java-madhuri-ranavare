package vitals;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class VitalsCheckerTest {

    // Tests for pure isInRange function - no I/O, no sleeping
    @Test
    public void valueWithinBoundsIsInRange() {
        assertTrue(VitalsChecker.isInRange(98.1f, 95, 102));
    }

    @Test
    public void lowerBoundaryIsInRange() {
        assertTrue(VitalsChecker.isInRange(95f, 95, 102));
    }

    @Test
    public void upperBoundaryIsInRange() {
        assertTrue(VitalsChecker.isInRange(102f, 95, 102));
    }

    @Test
    public void belowLowerBoundIsOutOfRange() {
        assertFalse(VitalsChecker.isInRange(94.9f, 95, 102));
    }

    @Test
    public void aboveUpperBoundIsOutOfRange() {
        assertFalse(VitalsChecker.isInRange(102.1f, 95, 102));
    }

    // Tests for pure outOfRangeMessage function - covers all vital conditions
    @Test
    public void allVitalsNormalReturnsNull() {
        assertNull(VitalsChecker.outOfRangeMessage(98.1f, 70f, 98f));
    }

    @Test
    public void highTemperatureIsDetected() {
        assertNotNull(VitalsChecker.outOfRangeMessage(103f, 70f, 98f));
    }

    @Test
    public void lowTemperatureIsDetected() {
        assertNotNull(VitalsChecker.outOfRangeMessage(94f, 70f, 98f));
    }

    @Test
    public void highPulseRateIsDetected() {
        assertNotNull(VitalsChecker.outOfRangeMessage(98.1f, 101f, 98f));
    }

    @Test
    public void lowPulseRateIsDetected() {
        assertNotNull(VitalsChecker.outOfRangeMessage(98.1f, 59f, 98f));
    }

    @Test
    public void lowSpo2IsDetected() {
        assertNotNull(VitalsChecker.outOfRangeMessage(98.1f, 70f, 89f));
    }
}
