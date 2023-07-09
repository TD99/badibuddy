package ch.tcraft.badibuddy.model;

public class WaterData {
    private double temperature;
    private double temperatureForecast2h;
    private String timeString;
    private int flow;
    private double airTemperature;

    public WaterData(double temperature, double temperatureForecast2h, String timeString, int flow, double airTemperature) {
        this.temperature = temperature;
        this.temperatureForecast2h = temperatureForecast2h;
        this.timeString = timeString;
        this.flow = flow;
        this.airTemperature = airTemperature;
    }

    public WaterData() {
    }

    @Override
    public String toString() {
        return "WaterData{" +
                "temperature=" + temperature +
                ", temperatureForecast2h=" + temperatureForecast2h +
                ", timeString='" + timeString + '\'' +
                ", flow=" + flow +
                ", airTemperature=" + airTemperature +
                '}';
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getTemperatureForecast2h() {
        return temperatureForecast2h;
    }

    public void setTemperatureForecast2h(double temperatureForecast2h) {
        this.temperatureForecast2h = temperatureForecast2h;
    }

    public String getTimeString() {
        return timeString;
    }

    public void setTimeString(String timeString) {
        this.timeString = timeString;
    }

    public int getFlow() {
        return flow;
    }

    public void setFlow(int flow) {
        this.flow = flow;
    }

    public double getAirTemperature() {
        return airTemperature;
    }

    public void setAirTemperature(double airTemperature) {
        this.airTemperature = airTemperature;
    }
}
