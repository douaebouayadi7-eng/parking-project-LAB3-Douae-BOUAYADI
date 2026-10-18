package parking.refactored;
import java.util.List;

public class TextReceiptFormatter implements ReceiptFormatter{
    @Override
    public String formatReceipt(Receipt receipt) {
        return receipt.plate()+"|"+ receipt.vehicleType()+"|"+receipt.hours()+"h|"+ receipt.amount()+"MAD |"+ receipt.methodName();
    }
    @Override
    public String formatDailyReport(List<Receipt> receipts, double total){
        StringBuilder sb= new StringBuilder(("===Daily report===\n"));
        for (Receipt r: receipts){
            sb.append(formatReceipt(r)).append("\n");
        }
        sb.append("Total: ").append(total).append("MAD");
        return sb.toString();
    }
}
