package fmi.structure;
import fmi.models.AbstractCar;
import fmi.util.CarParser;
import fmi.util.FileOperation;

import java.util.*;

public class Catalogue {
    private ArrayList<AbstractCar> list = new ArrayList<AbstractCar>();

    public void loadFromFile(String path){
        for(String row : FileOperation.readFileByRow(path)){
            AbstractCar car = CarParser.parseToCar(row);
            list.add(car);
        }
    }

    public void writeToFile(String path){
        FileOperation.writeToFileByRow(list,path);
    }

    public void printCatalogue(){
        for (AbstractCar car : list){
            System.out.println(car);
        }
    }

    public void sortByCarType(){
        Comparator<AbstractCar> byCarType = (car1, car2) -> car1.getClass().getName().compareTo(car2.getClass().getName());
        list.sort(byCarType);
        printCatalogue();
    }

    public void sortByBrand(){
        Comparator<AbstractCar> byBrand = (car1, car2) -> car1.getBrand().compareTo(car2.getBrand());
        list.sort(byBrand);
        printCatalogue();
    }
}
