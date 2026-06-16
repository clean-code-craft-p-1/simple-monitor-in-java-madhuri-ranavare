package vitals;

public class VitalsChecker {

    private VitalsChecker() {
    }

    static boolean isInRange(float value, float min, float max) {
        return value >= min && value <= max;
    }

    static String outOfRangeMessage(float temperature, float pulseRate, float spo2) {
        if (!isInRange(temperature, 95, 102)) {
            return "Temperature is critical!";
        }
        if (!isInRange(pulseRate, 60, 100)) {
            return "Pulse Rate is out of range!";
        }
        if (!isInRange(spo2, 90, 100)) {
            return "Oxygen Saturation out of range!";
        }
        return null;
    }

    static void alert(String message) throws InterruptedException {
        System.out.println(message);
        for (int i = 0; i < 6; i++) {
            System.out.print("\r* ");
            Thread.sleep(1000);
            System.out.print("\r *");
            Thread.sleep(1000);
        }
    }

    static boolean vitalsOk(float temperature, float pulseRate, float spo2) throws InterruptedException {
        String message = outOfRangeMessage(temperature, pulseRate, spo2);
        if (message != null) {
            alert(message);
            return false;
        }
        return true;
    }
}
