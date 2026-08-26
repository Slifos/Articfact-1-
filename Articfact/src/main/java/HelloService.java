import com.example.Articfact.ArticfactApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HelloService {
    @GetMapping("/")
    public String hello() {
        return "hello";
    }
    public static void main(String[] args) {
        Car c1 = new Car("OUI",true);
        Car c2 = new Car("NON",true);
        Car c3 = new Car("JSP",false);
        Car c4 = new Car("BLEH",false);
        Car c5 = new Car("AHAHAHAHAHAHAH",true);
    }
    @GetMapping("/cars")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<Car> listOfCars(){
        return Car.getList();
    }
}


