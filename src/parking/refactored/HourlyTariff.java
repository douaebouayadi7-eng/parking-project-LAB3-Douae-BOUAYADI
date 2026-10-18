package parking.refactored;

public class HourlyTariff implements Tariff{
    private final double ratePerHour;
    public HourlyTariff(double ratePerHour){
        this.ratePerHour= ratePerHour;
    }

    @Override
    public double fee(int hours) {
        return ratePerHour* hours;
    }
}
