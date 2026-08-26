import java.util.ArrayList;
import java.util.List;
public class Car {
    static List<Car> all_cars = new ArrayList<>();
    private String plateNumber;
    boolean isRented;
    Car(String plateNumber, boolean isRented){
        this.plateNumber = plateNumber;
        all_cars.add(this);
        this.isRented = isRented;
    }
    String getPlateNumber(){
        return plateNumber;
    }
    static List<Car> getList(){
        return all_cars;
    }
}
