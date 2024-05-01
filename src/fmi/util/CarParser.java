package fmi.util;

import fmi.models.AbstractCar;
import fmi.models.ElectricCar;
import fmi.models.GasCar;
import fmi.models.HybridCar;
import fmi.operationdb.DbOperations;

public class CarParser {
    public static void insertAbstractCar(String row){
        float engDis = 0.0f;
        int powerEng = 0;
        int capacity = 0;
        String[] parts = row.split(", ");
        String[] firstPart = parts[0].split(" ");
        String brand = firstPart[1];
        String model = parts[1];
        int price = Integer.parseInt(parts[parts.length - 1].replace(" euro", ""));

        switch (firstPart[0]){
            case "ELECTRIC_CAR":
                powerEng = Integer.parseInt(parts[2].replace("KW", ""));
                capacity = Integer.parseInt(parts[3].replace("Ah", ""));
                DbOperations.insertElectricCar("ELECTRIC_CAR",brand, model, capacity, powerEng, price);
                break;
            case "GAS_CAR":
                engDis = Float.parseFloat(parts[2].replace("L", ""));
                powerEng = Integer.parseInt(parts[3].replace("KW", ""));
                DbOperations.insertGasCar("GAS_CAR", brand, model, engDis, powerEng, price);
                break;
            case "HYBRID_CAR":
                engDis = Float.parseFloat(parts[2].replace("L", ""));
                powerEng = Integer.parseInt(parts[3].replace("KW", ""));
                capacity = Integer.parseInt(parts[4].replace("Ah", ""));
                DbOperations.insertHybridCar("HYBRID_CAR", brand, model, engDis, powerEng, capacity, price);
                break;
            default:
                System.out.println("Error");
        }
    }
    public static AbstractCar parseToCar(String row){
        String[] parts = row.split(", ");
        String[] firstPart = parts[0].split(" ");
        String brand = firstPart[1];
        String model = parts[1];
        int price = Integer.parseInt(parts[parts.length - 1].replace(" euro", ""));

        switch (firstPart[0]){
            case "ELECTRIC_CAR":
                return getElectricCar(brand, model, price, parts);
            case "GAS_CAR":
                return getGasCar(brand, model, price, parts);
            case "HYBRID_CAR":
                return getHybridCar(brand, model, price, parts);
            default:
                return null;
        }
    }

    private static GasCar getGasCar(String brand, String model, int price, String[] parts){
        float engDis = Float.parseFloat(parts[2].replace("L", ""));
        int powerEng = Integer.parseInt(parts[3].replace("KW", ""));

        return new GasCar(brand, model, engDis, powerEng, price);
    }

    private static ElectricCar getElectricCar(String brand, String model, int price, String[] parts){
        int powerEng = Integer.parseInt(parts[2].replace("KW", ""));
        int capacity = Integer.parseInt(parts[3].replace("Ah", ""));
        return new ElectricCar(brand, model, powerEng, capacity,price);
    }

    private static HybridCar getHybridCar(String brand, String model, int price, String[] parts){
        float engDis = Float.parseFloat(parts[2].replace("L", ""));
        int powerEng = Integer.parseInt(parts[3].replace("KW", ""));
        int capacity = Integer.parseInt(parts[4].replace("Ah", ""));
        return new HybridCar(brand, model, engDis,powerEng, capacity,price);
    }
}
