package fmi.models;
public abstract class AbstractCar {
    private String model;
    private String brand;
    private int price;
    private int powerEng;

    public AbstractCar(String brand, String model, int powerEng, int price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.powerEng = powerEng;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPowerEng() {
        return powerEng;
    }

    public void setPowerEng(int powerEng) {
        this.powerEng = powerEng;
    }
}
