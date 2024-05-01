package fmi.util;
import fmi.models.AbstractCar;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class FileOperation {
    public static ArrayList<String> readFileByRow(String filePath){
        ArrayList<String> rows = new ArrayList<String>();

        try(BufferedReader bufferedReader = Files.newBufferedReader(Paths.get(filePath))) {
            rows = (ArrayList<String>) bufferedReader.lines().collect(Collectors.toList());

        } catch (IOException e){
            e.printStackTrace();
        }
        return rows;
    }

    public static void writeToFileByRow(ArrayList<AbstractCar> list, String path){
        try(BufferedWriter bufferedWriter = Files.newBufferedWriter(Paths.get(path))) {
            for (AbstractCar car : list){
                bufferedWriter.write(car.toString());
                bufferedWriter.newLine();
            }

            bufferedWriter.flush();

        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
