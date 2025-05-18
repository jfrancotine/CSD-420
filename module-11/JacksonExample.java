import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

public class JacksonExample {

    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();

        // Example of serializing a Java object to JSON
        try {
            Car car = new Car("Mercedes", 5);
            String carJson = objectMapper.writeValueAsString(car);
            System.out.println("JSON: " + carJson);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Example of deserializing JSON to a Java object
        String jsonString = "{ \"brand\" : \"BMW\", \"doors\" : 4 }";
        try {
            Car car = objectMapper.readValue(jsonString, Car.class);
            System.out.println("Car brand: " + car.getBrand());
            System.out.println("Car doors: " + car.getDoors());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Car {
    private String brand;
    private int doors;

    public Car() {
    }

    public Car(String brand, int doors) {
        this.brand = brand;
        this.doors = doors;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getDoors() {
        return doors;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }
}