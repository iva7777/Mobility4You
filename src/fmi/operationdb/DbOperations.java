package fmi.operationdb;

import java.sql.*;

public class DbOperations {
    private static Connection connection = null;
    private static PreparedStatement statement = null;
    private static ResultSet result = null;

    public static ResultSet getAllCars(){
        connection = getConnection();
        String sql = "select * from car";
        try {
            statement = connection.prepareStatement(sql);
            result = statement.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public static void insertGasCar(String type, String brand, String model, float engDis, int powerEng, int price){
        connection = getConnection();

        String sql = "insert into car (type, brand, model, powereng, price,engdis)" + "values(?, ?, ?, ?, ?, ?)";
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, type);
            statement.setString(2, brand);
            statement.setString(3, model);
            statement.setInt(4, powerEng);
            statement.setInt(5, price);
            statement.setFloat(6, engDis);

            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }//can be int-type

    public static void insertElectricCar(String type, String brand, String model, int capacity, int powerEng, int price){
        connection = getConnection();

        String sql = "insert into car (type, brand, model,powereng, price, capacity)" + "values(?, ?, ?, ?, ?, ?)";
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, type);
            statement.setString(2, brand);
            statement.setString(3, model);
            statement.setInt(4, powerEng);
            statement.setInt(5, price);
            statement.setInt(6, capacity);

            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void insertHybridCar(String type, String brand, String model, float engDis, int powerEng,int capacity, int price){
        connection = getConnection();

        String sql = "insert into car (type, brand, model,powereng, price, capacity, engdis)" + "values(?, ?, ?, ?, ?, ?, ?)";
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, type);
            statement.setString(2, brand);
            statement.setString(3, model);
            statement.setInt(4, powerEng);
            statement.setInt(5, price);
            statement.setInt(6, capacity);
            statement.setFloat(7, engDis);

            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection(){
        try {
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection("jdbc:h2:tcp://localhost/C:\\Users\\acer\\Desktop\\Мои неща\\UNI\\ВТОРИ КУРС\\JAVA\\mobility", "sa","sa");

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return connection;
    }
}
