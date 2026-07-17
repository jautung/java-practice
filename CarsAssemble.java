public class CarsAssemble {
    static int BASE_NUMBER_OF_CARS_PER_HOUR = 221;

    public double productionRatePerHour(int speed) {
        return speed * BASE_NUMBER_OF_CARS_PER_HOUR * successRate(speed);
    }

    public int workingItemsPerMinute(int speed) {
        return (int) Math.floor(productionRatePerHour(speed) / 60);
    }

    double successRate(int speed) {
        if (speed >= 0 && speed <= 4) {
            return 1.0;
        } else if (speed >= 5 && speed <= 8) {
            return 0.9;
        } else if (speed == 9) {
            return 0.8;
        } else if (speed == 10) {
            return 0.77;
        }
        throw new Error("Invalid speed %d".formatted(speed));
    }

    public static void main(String[] args) {
        System.out.println("Hello!");
    }
}
