package parking.refactored;

public interface Tariff {
    boolean appliesTo(String vehicleType);
    double fee(int hours);
}
