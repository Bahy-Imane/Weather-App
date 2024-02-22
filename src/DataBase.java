import java.sql.*;
import java.util.*;
import java.util.Date;




public class DataBase {


    private static final String URL = "jdbc:mysql://localhost:3306/weatherapp";
        private static final String USERNAME = "Bahy Imane";
        private static final String PASSWORD = "kalamar";


        public static Connection getConnection() throws SQLException {
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        }

    public static ArrayList<CityHistory> getAllCityHistories() throws SQLException {
        ArrayList<CityHistory> cityHistoryList = new ArrayList<>();
        String sql = "SELECT * FROM cityhistory";
        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            int HistoricalDataID = resultSet.getInt("HistoricalDataID");
            String ID = resultSet.getString("CityID");
            Date EventDate = resultSet.getDate("EventDate");
            int Temperature = resultSet.getInt("Temperature");
            cityHistoryList.add(new CityHistory(HistoricalDataID, ID, EventDate,Temperature ));
        }
        connection.close();
        statement.close();
        resultSet.close();
        return cityHistoryList;
    }

    public static void addCityHistory(CityHistory cityhistory) throws SQLException {
        String sql = "INSERT INTO cityhistory (HistoricalDataID, ID, EventDate ,Temperature ) VALUES (?, ?, ?, ?)";
        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, cityhistory.getHistoricalDataID());
        statement.setInt(2, cityhistory.getID());
        statement.setDate(3, cityhistory.getEventDate());
        statement.setInt(3, cityhistory.getTemperature());
        statement.executeUpdate();
        connection.close();
        statement.close();
        System.out.println("CityHistory added successfully!");
    }

    public static void updateCityHistory(CityHistory cityhistory) throws SQLException {
        String sql = "UPDATE cityhistory SET HistoricalDataID = ?, ID = ? ,EventDate = ?, Temperature = ? ,WHERE HistoricalDataID = ?";
        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, cityhistory.getHistoricalDataID());
        statement.setInt(2, cityhistory.getID());
        statement.setDate(3, cityhistory.getEventDate());
        statement.setInt(3, cityhistory.getTemperature());
        statement.executeUpdate();
        connection.close();
        statement.close();
        System.out.println("CityHistory updated successfully!");
    }

    public static void deleteCityHistory(int HistoricalDataID) throws SQLException {
        String sql = "DELETE FROM CityHistory WHERE HistoricalDataID = ?";
        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1,HistoricalDataID);
        statement.executeUpdate();
        connection.close();
        statement.close();
        System.out.println("CityHistory deleted successfully!");
    }

                        // City:

    public static ArrayList<City> getAllCities() throws SQLException {
        ArrayList<City> cityList = new ArrayList<>();
        String sql = "SELECT * FROM city";
        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            int ID = resultSet.getInt("ID");
            String CityName = resultSet.getString("CityName");
            int CityTemperature = resultSet.getInt("CityTemperature");
            int CurrentHumidity = resultSet.getInt("CurrentHumidity");
            int CurrentWedSpeed = resultSet.getInt("CurrentWedSpeed");
            cityList.add(new City(ID, CityName, CityTemperature,CurrentHumidity ,CurrentWedSpeed));
        }
        connection.close();
        statement.close();
        resultSet.close();
        return cityList;
    }

    public static void addCity(City city) throws SQLException {
        String sql = "INSERT INTO city (ID, CityName, CityTemperature ,CurrentHumidity ,CurrentWedSpeed) VALUES (?, ?, ?, ?, ?)";
        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, city.getID());
        statement.setString(2, city.getCityName());
        statement.setInt(3, city.getCityTemperature());
        statement.setInt(3, city.getCurrentHumidity());
        statement.setInt(3, city.getCurrentWedSpeed());
        statement.executeUpdate();
        connection.close();
        statement.close();
        System.out.println("City added successfully!");

    }

    public static void updateCity(City city) throws SQLException {
        String sql = "UPDATE city SET ID = ?, CityName = ? ,CityTemperature = ?, CurrentHumidity = ? ,CurrentWedSpeed =? ,WHERE ID = ?";
        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, city.getID());
        statement.setString(2, city.getCityName());
        statement.setInt(3, city.getCityTemperature());
        statement.setInt(3, city.getCurrentHumidity());
        statement.setInt(3, city.getCurrentWedSpeed());
        statement.executeUpdate();
        connection.close();
        statement.close();
        System.out.println("City updated successfully!");
    }

    public static void deleteCity(int ID) throws SQLException {
        String sql = "DELETE FROM City WHERE ID = ?";
        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1,ID);
        statement.executeUpdate();
        connection.close();
        statement.close();
        System.out.println("City deleted successfully!");
    }

}
