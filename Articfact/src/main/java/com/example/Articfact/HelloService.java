package com.example.Articfact;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


import java.util.ArrayList;
import java.util.List;

@RestController
public class HelloService {
    private static List<Car> allCars = new ArrayList<>();

    // Bloc statique : s'exécute une seule fois au chargement de la classe
    static {
        allCars.add(new Car("OUI", true));
        allCars.add(new Car("NON", true));
        allCars.add(new Car("JSP", false));
        allCars.add(new Car("BLEH", false));
        allCars.add(new Car("AHAHAHAHAHAHAH", true));
        allCars.add(new Car("BOOOOH", false));
    }
    @GetMapping("/")
    public String hello() {
        return "hello";
    }

    @GetMapping("/cars")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<Car> listOfCars() {
        return HelloService.allCars;
    }


    @GetMapping("/cars/{plateNumber}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Car aCar(@PathVariable("plateNumber") String plateNumber) {
        for (Car car : HelloService.allCars) {
            if (car.getPlateNumber().equals(plateNumber)) {
                return car;
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Voiture non trouvée : " + plateNumber);
    }
    @PutMapping(value = "/voiture/{plateNumber}")
    @ResponseStatus(HttpStatus.OK)
    public void rentOrGetBack(
            @PathVariable("plateNumber") String plateNumber,
            @RequestParam(value="rent", required = true)boolean rent){
        aCar(plateNumber).setIsRented(rent);
    }
    @PutMapping(value = "/cars/{plateNumber}")
    @ResponseStatus(HttpStatus.OK)
    public void rent(
            @PathVariable("plateNumber") String plateNumber,
            @RequestParam(value="rent", required = true)boolean rent,
            @RequestBody Dates dates){
        Car car = aCar(plateNumber);
        car.setIsRented(rent);
        car.setReturnDate(dates.getReturnDate());
    }
}


