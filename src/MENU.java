import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class MENU {
    City city = new City();
    CityHistory cityHistory = new CityHistory();

    public void menu() throws SQLException {
        int choice;

        do {

            System.out.println("******************************** Menu *****************************");
            System.out.println("*******************************************************************");
            System.out.println("***                  Press [1] City Manager                     ***");
            System.out.println("***                  Press [2] City  History Manager            ***");
            System.out.println("*******************************************************************");
            System.out.println("***                  Press [0] if you want to quit              ***");
            System.out.println("*******************************************************************");

            System.out.println("Enter your choice:");
            choice = new Scanner(System.in).nextInt();

            switch (choice) {
                case 1:
                    menucity();
                    break;
                case 2 :
                    menucityHistory();
                    break;
            }

        } while (choice != 0);
    }

    void menucity() throws SQLException {
        System.out.println("******************************** Menu *****************************");
        System.out.println("*******************************************************************");
        System.out.println("***       Press [1] if you want to add a City                   ***");
        System.out.println("***       Press [2] if you want to see all cities               ***");
        System.out.println("***       Press [3] if you want to update a City                ***");
        System.out.println("***       Press [4] if you want to delete a city                ***");
        System.out.println("*******************************************************************");
        System.out.println("Enter your choice:");
        int choice1 = new Scanner(System.in).nextInt();

        switch (choice1) {
            case 1:
                System.out.println("Enter ID :");
                city.setID(new Scanner(System.in).nextInt());

                System.out.println("Enter CityName");
                city.setCityName(new Scanner(System.in).nextLine());

                System.out.println("Enter CityTemperature");
                city.setCityTemperature(new Scanner(System.in).nextInt());

                System.out.println("Enter CurrentHumidity");
                city.setCurrentHumidity(new Scanner(System.in).nextInt());

                System.out.println("Enter CurrentWedSpeed");
                city.setCurrentWedSpeed(new Scanner(System.in).nextInt());
                City.AddCity(city);

                break;
            case 2:
                System.out.println("******List of cities******");
                for (City C : City.ShowCity()) {
                    System.out.println("                                      ");
                    System.out.println("City ID:" + C.getID());
                    System.out.println("City Name :" + C.getCityName());
                    System.out.println("City Temperature :" + C.getCityTemperature());
                    System.out.println("City Humidity :" + C.getCurrentHumidity());
                    System.out.println("City Wed Speed :" + C.getCurrentWedSpeed());
                }
                break;

            case 3:
                System.out.println("Enter the ID of City that you wanna update :");
                city.setID(new Scanner(System.in).nextInt());

                System.out.println("Enter the new CityName");
                city.setCityName(new Scanner(System.in).nextLine());

                System.out.println("Enter the new CityTemperature");
                city.setCityTemperature(new Scanner(System.in).nextInt());

                System.out.println("Enter the new Current Humidity");
                city.setCurrentHumidity(new Scanner(System.in).nextInt());

                System.out.println("Enter the new Current WedSpeed");
                city.setCurrentWedSpeed(new Scanner(System.in).nextInt());
                City.UpdateCity(city);

                break;
            case 4:
                System.out.println("Enter the ID of City that you wanna delete :");
                city.setID(new Scanner(System.in).nextInt());
                City.DeleteCity(city);
                break;
        }
    }

    void menucityHistory() throws SQLException {
        System.out.println("******************************** Menu *****************************");
        System.out.println("*******************************************************************");
        System.out.println("***       Press [1] if you want to add a City HISTORY           ***");
        System.out.println("***       Press [2] if you want to see all city Histories       ***");
        System.out.println("***       Press [3] if you want to Update a city History        ***");
        System.out.println("***       Press [4] if you want to delete a City History        ***");
        System.out.println("***       Press [5] if you want to search a City History        ***");
        System.out.println("*******************************************************************");

        System.out.println("Enter your choice:");
        int choice2 = new Scanner(System.in).nextInt();

        switch (choice2) {

            case 1:
                System.out.println("Enter HistoricalDataID :");
                cityHistory.setHistoricalDataID(new Scanner(System.in).nextInt());

                System.out.println("Enter City ID :");
                cityHistory.setID(new Scanner(System.in).nextInt());

                System.out.println("Enter Event date (YYYY-MM-DD):");
                String EV = new Scanner(System.in).next();
                DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                cityHistory.setEventDate(LocalDate.parse(EV, dateTimeFormatter));

                System.out.println("Enter Temperature :");
                cityHistory.setTemperature(new Scanner(System.in).nextInt());

                CityHistory.addCityHistory(cityHistory);

                break;

            case 2:
                System.out.println("***************************List of city history**************************");
                System.out.println("                                                                         ");
                CityHistory.showCityHistory().forEach(cityHistory1 -> System.out.println(cityHistory1));
                System.out.println("                                                                         ");
                break;

            case 3:
                System.out.println("Enter the Historical Data ID of City history that you wanna update :");
                cityHistory.setHistoricalDataID(new Scanner(System.in).nextInt());

                System.out.println("Enter the new Historical Data ID :");
                cityHistory.setHistoricalDataID(new Scanner(System.in).nextInt());

                System.out.println("Enter the new Event Date (YYYY-MM-DD) :");
                String newEventDate = new Scanner(System.in).next();
                dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                cityHistory.setEventDate(LocalDate.parse(newEventDate, dateTimeFormatter));

                System.out.println("Enter the new Temperature :");
                cityHistory.setTemperature(new Scanner(System.in).nextInt());

                CityHistory.UpdateCityHistory(cityHistory);
                break;

            case 4:
                System.out.println("Enter the Historical Data ID of City History that you wanna delete :");
                cityHistory.setHistoricalDataID(new Scanner(System.in).nextInt());
                CityHistory.DeleteCityHistory(cityHistory);
                break;

            case 5:
                CityHistory cityHistory1 = new CityHistory();
                System.out.print("Enter the ID of city that you want to see its history: ");
                int cityIdForHistoryRead = new Scanner(System.in).nextInt();
                cityHistory1.readCityHistory(cityIdForHistoryRead);
                break;
            default:

        }
    }
}


