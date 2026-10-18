package parking.refactored;

import java.util.ArrayList;
import java.util.List;

public class ParkingService {
    private final TariffCatalog tariffs;
    private final ReceiptFormatter formatter;
    private final ReceiptLog log;
    private final List<Receipt> receipts = new ArrayList<>();
    private double total = 0;

    public ParkingService(TariffCatalog tariffs, ReceiptFormatter formatter, ReceiptLog log) {
        this.tariffs = tariffs;
        this.formatter = formatter;
        this.log = log;
    }

    public double fee(Vehicule vehicle, int hours) {
        return tariffs.tariffFor(vehicle.getType()).fee(hours);
    }

    public void checkout(Vehicule vehicle, int hours, PaymentMethod method) {
        double amount = fee(vehicle, hours);
        method.pay(amount);
        total += amount;
        Receipt receipt = new Receipt(vehicle.getPlate(), vehicle.getType(), hours, amount, method.name());
        receipts.add(receipt);
        log.log(formatter.formatReceipt(receipt));
    }

    public void cancel(Vehicule vehicle, int hours, RefundablePaymentMethod method) {
        double amount = fee(vehicle, hours);
        method.refund(amount);
        registerCancellation(vehicle, amount);
    }

    public void cancelAtDesk(Vehicule vehicle, int hours) {
        double amount = fee(vehicle, hours);
        System.out.println("Refund " + amount + " MAD at the desk for " + vehicle.getPlate());
        registerCancellation(vehicle, amount);
    }

    public String dailyReport() {
        return formatter.formatDailyReport(receipts, total);
    }

    private void registerCancellation(Vehicule vehicle, double amount) {
        total -= amount;
        log.log("CANCELLED " + vehicle.getPlate());
    }

}
