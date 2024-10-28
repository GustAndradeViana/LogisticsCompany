public enum EMaintenance {
    LESS_THAN_3_YEARS(10000, 2000),
    BETWEEN_3_AND_6_YEARS(7500, 4000),
    MORE_THAN_6_YEARS(5000, 8000);

    private final int intervalKm;
    private final int cost;

    EMaintenance(int intervalKm, int cost) {
        this.intervalKm = intervalKm;
        this.cost = cost;
    }

    public int getIntervalKm() {
        return intervalKm;
    }

    public int getCost() {
        return cost;
    }

    public static EMaintenance getServiceInterval(int vehicleAge) {
        if (vehicleAge < 3) {
            return LESS_THAN_3_YEARS;
        } else if (vehicleAge < 6) {
            return BETWEEN_3_AND_6_YEARS;
        } else {
            return MORE_THAN_6_YEARS;
        }
    }
}