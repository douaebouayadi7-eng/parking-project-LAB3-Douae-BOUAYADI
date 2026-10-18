package parking.refactored;

public class Main {
    public static void main(String[] args) {
        TariffCatalog tariffs = new InMemoryTariffCatalog()
                .register("CAR", new HourlyTariff(5.0))
                .register("MOTORBIKE", new HourlyTariff(2.0))
                .register("TRUCK", new HourlyTariff(15.0));

        ParkingService service = new ParkingService(
                tariffs, new TextReceiptFormatter(), new FileReceiptLog("parking.log"));

        Vehicule car = new Vehicule("12345-A-6", "CAR");
        Vehicule bike = new Vehicule("67890-B-1", "MOTORBIKE");
        Vehicule truck = new Vehicule("24680-D-8", "TRUCK");
        CardPayment card = new CardPayment("4242");
        CashPayment cash = new CashPayment();

        service.checkout(car, 3, card);
        service.checkout(bike, 2, cash);
        service.checkout(truck, 4, card);
        service.cancelAtDesk(bike, 2);
        service.cancel(truck, 4, card);
        System.out.println(service.dailyReport());
    }
}
