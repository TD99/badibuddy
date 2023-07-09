package ch.tcraft.badibuddy.model;

public class LocationData {

    private String locationName;

    private double aareTemperature;

    private double minAirTemperature;

    private double maxAirTemperature;

    public LocationData(String locationName, double aareTemperature, double minAirTemperature, double maxAirTemperature) {
        this.locationName = locationName;
        this.aareTemperature = aareTemperature;
        this.minAirTemperature = minAirTemperature;
        this.maxAirTemperature = maxAirTemperature;
    }

    public LocationData() {
    }

    @Override
    public String toString() {
        return "LocationData{" +
                "locationName='" + locationName + '\'' +
                ", aareTemperature=" + aareTemperature +
                ", minAirTemperature=" + minAirTemperature +
                ", maxAirTemperature=" + maxAirTemperature +
                '}';
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public double getAareTemperature() {
        return aareTemperature;
    }

    public void setAareTemperature(double aareTemperature) {
        this.aareTemperature = aareTemperature;
    }

    public double getMinAirTemperature() {
        return minAirTemperature;
    }

    public void setMinAirTemperature(double minAirTemperature) {
        this.minAirTemperature = minAirTemperature;
    }

    public double getMaxAirTemperature() {
        return maxAirTemperature;
    }

    public void setMaxAirTemperature(double maxAirTemperature) {
        this.maxAirTemperature = maxAirTemperature;
    }
}
