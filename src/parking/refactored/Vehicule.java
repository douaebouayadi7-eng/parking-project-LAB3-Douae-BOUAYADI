package parking.refactored;

public class Vehicule {
    private final String plate;
    private final String type;
    public Vehicule(String plate, String type){
        this.plate= plate;
        this.type= type;
    }
    public String getPlate(){
        return plate;
    }
    public String getType(){
        return type;
    }
}
