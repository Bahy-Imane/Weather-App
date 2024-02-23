import java.sql.*;
import java.util.ArrayList;

public class City {
    private int ID;
    private String CityName;
    private int CityTemperature;
    private int CurrentHumidity;
    private int CurrentWedSpeed;
    public City(){}

    public City(int ID, String cityName, int cityTemperature, int currentHumidity, int currentWedSpeed) {
        this.ID = ID;
        CityName = cityName;
        CityTemperature = cityTemperature;
        CurrentHumidity = currentHumidity;
        CurrentWedSpeed = currentWedSpeed;
    }

    public int getID() {
        return ID;
    }

    public String getCityName() {
        return CityName;
    }

    public int getCityTemperature() {
        return CityTemperature;
    }

    public int getCurrentHumidity() {
        return CurrentHumidity;
    }

    public int getCurrentWedSpeed() {
        return CurrentWedSpeed;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setCityName(String cityName) {
        CityName = cityName;
    }

    public void setCityTemperature(int cityTemperature) {
        CityTemperature = cityTemperature;
    }

    public void setCurrentHumidity(int currentHumidity) {
        CurrentHumidity = currentHumidity;
    }

    public void setCurrentWedSpeed(int currentWedSpeed) {
        CurrentWedSpeed = currentWedSpeed;
    }
    private static final String URL = "jdbc:mysql://localhost:3306/weatherapp";
    private static final String USERNAME = "Bahy Imane";
    private static final String PASSWORD = "kalamar";


    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
        public static void AddCity(City city)throws SQLException{
        String sql="INSERT INTO city (ID,name,currentTempérature,currentHumidity,currentWedSpeed)values (?,?,?,?,?)";
        Connection connection=getConnection();
        PreparedStatement statement=connection.prepareStatement(sql);
        statement.setInt(1,city.ID);
        statement.setString(2,city.CityName);
        statement.setInt(3,city.CityTemperature);
        statement.setInt(4,city.CurrentHumidity);
        statement.setInt(5,city.CurrentWedSpeed);
        statement.executeUpdate();
        connection.close();
        statement.close();
        System.out.println("City added successfully ");

        }
        public static ArrayList<City> ShowCity()throws SQLException{
            ArrayList<City> cityList=new ArrayList<>();
        String sql="SELECT * FROM city";
            Connection connection=getConnection();
            PreparedStatement statement=connection.prepareStatement(sql);
            ResultSet resultSet=statement.executeQuery();
            while (resultSet.next()){
                int ID=resultSet.getInt("ID");
                String name=resultSet.getString("name");
                int currentTempérature=resultSet.getInt("currentTempérature");
                int currentHumidity=resultSet.getInt("currentHumidity");
                int currentWedSpeed=resultSet.getInt("currentWedSpeed");
                cityList.add(new City(ID,name,currentTempérature,currentHumidity,currentWedSpeed));

            }
            return cityList;
        }
        public static void UpdateCity(City city)throws SQLException{
        String sql="UPDATE city SET  name=? , currentTempérature=? , currentHumidity=?, currentWedSpeed=? WHERE ID=?";
            Connection connection=getConnection();
            PreparedStatement statement=connection.prepareStatement(sql);
            statement.setString(1,city.CityName);
            statement.setInt(2,city.CityTemperature);
            statement.setInt(3,city.CurrentHumidity);
            statement.setInt(4,city.CurrentWedSpeed);
            statement.setInt(5,city.ID);
            statement.executeUpdate();
            connection.close();
            statement.close();
            System.out.println("City updated successfully ");


        }
        public static void DeleteCity(City city)throws SQLException{
        String sql="DELETE FROM city WHERE ID=?";
            Connection connection=getConnection();
            PreparedStatement statement=connection.prepareStatement(sql);
            statement.setInt(1,city.ID);
            statement.executeUpdate();
            connection.close();
            statement.close();
            System.out.println("City deleted successfully ");



        }


}
