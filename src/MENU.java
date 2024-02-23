import java.sql.SQLException;
import java.util.Scanner;

public class MENU {
    City city = new City();
    public void menu() throws SQLException {
        int choice;



        do {
            System.out.println("******************************** Menu *****************************");
            System.out.println("*******************************************************************");
            System.out.println("***       Press [1] if you want to add a City                   ***");
            System.out.println("***       Press [2] if you want to see all cities               ***");
            System.out.println("***       Press [3] if you want to update a City                ***");
            System.out.println("***       Press [4] if you want to delete a city                ***");
            System.out.println("*******************************************************************");
            System.out.println("***       Press [5] if you want to add a City HISTORY           ***");
            System.out.println("***       Press [6] if you want to see all city Histories       ***");
            System.out.println("***       Press [7] if you want to Update a city History        ***");
            System.out.println("***       Press [8] if you want to delete a City History        ***");
            System.out.println("*******************************************************************");
            System.out.println("***       Press [0] if you want to quit                         ***");
            System.out.println("*******************************************************************");

            System.out.println("Enter your choice:");
            choice = new Scanner(System.in).nextInt();

            switch (choice) {


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
                    System.out.println("-------------------------------------------");
                    for(City ct:City.ShowCity()){
                        System.out.println("                                      ");
                        System.out.println("City ID:"+ct.getID());
                        System.out.println("City Name :"+ct.getCityName());
                        System.out.println("City Temperature :"+ct.getCityTemperature());
                        System.out.println("City Humidity :"+ct.getCurrentHumidity());
                        System.out.println("City Wed Speed :"+ct.getCurrentWedSpeed());

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
        }while(choice!=0);
    }
}







