import sun.util.resources.LocaleData;

import java.time.LocalDate;
import java.sql.*;
import java.util.ArrayList;
import java.util.Locale;


public class CityHistory {
        private int HistoricalDataID;
        private int ID;
        private LocalDate EventDate;
        private int Temperature;

        public CityHistory(int historicalDataID, int ID, LocalDate eventDate, int temperature) {
                HistoricalDataID = historicalDataID;
                this.ID = ID;
                EventDate = eventDate;
                Temperature = temperature;
        }

        public int getHistoricalDataID() {
                return HistoricalDataID;
        }

        public void setHistoricalDataID(int historicalDataID) {
                HistoricalDataID = historicalDataID;
        }

        public int getID() {
                return ID;
        }

        public void setID(int ID) {
                this.ID = ID;
        }

        public LocalDate getEventDate() {
                return EventDate;
        }

        public void setEventDate(LocalDate eventDate) {
                EventDate = eventDate;
        }

        public int getTemperature() {
                return Temperature;
        }

        public void setTemperature(int temperature) {
                Temperature = temperature;
        }



        public static void addCityHistory(CityHistory cityHistory) throws SQLException{
                String sql ="INSERT INTO cityhistory (HistoriacalDataID ,ID ,EventDate ,Temperature) values (?,?,?,?)";
                Connection connection=City.getConnection();
                PreparedStatement statement=connection.prepareStatement(sql);
                statement.setInt(1,cityHistory.HistoricalDataID);
                statement.setInt(2,cityHistory.ID);
                statement.setDate(3, Date.valueOf(cityHistory.EventDate));
                statement.setInt(4,cityHistory.Temperature);
                connection.close();
                statement.close();
                System.out.println("The city history is added successfully ");
        }


        public static ArrayList<CityHistory> showCityHistory() throws SQLException {
                ArrayList<CityHistory> cityHistoryList=new ArrayList<>();
                String sql = "SELECT * FROM cityhistory";
                Connection connection=City.getConnection();
                PreparedStatement statement=connection.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                int HistoricalDataID = resultSet.getInt("HistoricalDataID");
                int ID = resultSet.getInt("ID");
                LocalDate EventDate = resultSet.getDate("EventDate").toLocalDate();
                int Temperature = resultSet.getInt("Temperature");
                cityHistoryList.add(new CityHistory(HistoricalDataID, ID, EventDate,Temperature ));
        }
                connection.close();
                statement.close();
                resultSet.close();
                return cityHistoryList;
    }

        public static void UpdateCity(CityHistory cityHistory)throws SQLException{
                String sql="UPDATE cityhistory SET Temperature=? , EventDate=? WHERE HistoricalDataID =?";
                Connection connection=City.getConnection();
                PreparedStatement statement=connection.prepareStatement(sql);
                statement.setInt(1,cityHistory.Temperature);
                statement.setDate(2, Date.valueOf(cityHistory.EventDate));
                statement.setInt(3,cityHistory.HistoricalDataID);
                statement.executeUpdate();
                connection.close();
                statement.close();
                System.out.println("City History updated successfully ");


        }

        public static void DeleteCityHistory(CityHistory cityHistory)throws SQLException{
                String sql="DELETE FROM cityhistory WHERE HistoricalDataID =?";
                Connection connection=City.getConnection();
                PreparedStatement statement=connection.prepareStatement(sql);
                statement.setInt(1,cityHistory.HistoricalDataID);
                statement.executeUpdate();
                connection.close();
                statement.close();
                System.out.println("City History deleted successfully ");



        }
}
