public class City {
    private int ID;
    private String CityName;
    private int CityTemperature;
    private int CurrentHumidity;
    private int CurrentWedSpeed;

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
}
