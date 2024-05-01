package fmi.models;

public class GasCar extends AbstractCar{

    private float engDis;
    public GasCar(String brand, String model, float engDis,int powerEng, int price) {
        super(brand, model, powerEng, price);
        this.engDis = engDis;
    }

    @Override
    public String toString() {
        String print = String.format("GAS_CAR %s, %s, %.1fL, %dKW, %d euro",
                getBrand(), getModel(), getEngDis(), getPowerEng(), getPrice());
        return print;
    }

    public float getEngDis() {
        return engDis;
    }

    public void setEngDis(float engDis) {
        this.engDis = engDis;
    }
}
