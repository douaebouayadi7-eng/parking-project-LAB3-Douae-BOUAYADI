package parking.refactored;
import java.util.ArrayList;
import java.util.List;

public class InMemoryTariffCatalog implements TariffCatalog{
    private final List<String> vehicleTypes = new ArrayList<>();
    private final List<Tariff> tariffs = new ArrayList<>();

    public InMemoryTariffCatalog register(String vehicleType, Tariff tariff) {
        vehicleTypes.add(vehicleType);
        tariffs.add(tariff);
        return this;
    }

    @Override
    public Tariff tariffFor(String vehicleType) {
        for (int i = 0; i < vehicleTypes.size(); i++) {
            if (vehicleTypes.get(i).equals(vehicleType)) {
                return tariffs.get(i);
            }
        }
        throw new IllegalArgumentException("Unknown vehicle type: " + vehicleType);
    }
}
