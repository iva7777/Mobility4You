package fmi.models;

public class ElectricCar extends AbstractCar{
    private int capacity;
    public ElectricCar(String brand, String model, int powerEng, int capacity,int price) {
        super(brand, model, powerEng, price);
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        String print = String.format("ELECTRIC_CAR %s, %s, %dKW, %dAh, %d euro",
                getBrand(), getModel(), getPowerEng(), getCapacity(), getPrice());
        return print;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
