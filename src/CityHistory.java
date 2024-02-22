import java.util.Date;

public class CityHistory {
        private int HistoricalDataID;
        private int ID;
        private Date EventDate;
        private int Temperature;

        public CityHistory(int historicalDataID, int cityID, Date eventDate, int temperature) {
                HistoricalDataID = historicalDataID;
                ID = cityID;
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

        public void setID(int cityID) {
                ID = cityID;
        }

        public Date getEventDate() {
                return EventDate;
        }

        public void setEventDate(Date eventDate) {
                EventDate = eventDate;
        }

        public int getTemperature() {
                return Temperature;
        }

        public void setTemperature(int temperature) {
                Temperature = temperature;
        }
}
