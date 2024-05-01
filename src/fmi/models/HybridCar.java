package fmi.models;

public class HybridCar extends AbstractCar{
    private int capacity;
    private float engDis;
    public HybridCar(String brand, String model, float engDis,int powerEng, int capacity,int price) {
        super(brand, model, powerEng, price);
        this.engDis = engDis;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        String print = String.format("HYBRID_CAR %s, %s, %.1fL, %dKW, %dAh, %d euro",
                getBrand(), getModel(), getEngDis(), getPowerEng(), getCapacity(),getPrice());
        return print;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public float getEngDis() {
        return engDis;
    }

    public void setEngDis(float engDis) {
        this.engDis = engDis;
    }
}
