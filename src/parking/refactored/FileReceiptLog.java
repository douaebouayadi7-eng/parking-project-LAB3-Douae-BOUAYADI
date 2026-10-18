package parking.refactored;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileReceiptLog implements ReceiptLog{
    private final String fileName;
    public FileReceiptLog(String fileName){
        this.fileName= fileName;
    }
    @Override
    public void log(String line){
        try (PrintWriter out= new PrintWriter(new FileWriter(fileName, true))){
            out.println(line);
        }catch(IOException e){
            throw new RuntimeException(e);
        }
    }
}
