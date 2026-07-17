
class BirdWatcher {
    private final static int[] BIRDS_LAST_WEEK = {0, 2, 5, 3, 7, 8, 4};
    private final int[] birdsPerDay;

    public BirdWatcher(int[] birdsPerDay) {
        this.birdsPerDay = birdsPerDay.clone();
    }

    public static int[] getLastWeek() {
        return BIRDS_LAST_WEEK.clone();
    }

    public int getToday() {
        return birdsPerDay[birdsPerDay.length - 1];
    }

    public void incrementTodaysCount() {
        birdsPerDay[birdsPerDay.length - 1]++;
    }

    public boolean hasDayWithoutBirds() {
        for (int birds : birdsPerDay) {
            if (birds == 0) {
                return true;
            }
        }
        return false;
    }

    public int getCountForFirstDays(int numberOfDays) {
        int totalCount = 0;
        for (int i = 0; i < Math.min(numberOfDays, birdsPerDay.length); i++) {
            totalCount += birdsPerDay[i];
        }
        return totalCount;
    }

    public int getBusyDays() {
        int busyDays = 0;
        for (int birds : birdsPerDay) {
            if (birds >= 5) {
                busyDays++;
            }
        }
        return busyDays;
    }
}
