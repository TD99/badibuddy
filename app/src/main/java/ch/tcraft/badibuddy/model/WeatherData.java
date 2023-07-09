package ch.tcraft.badibuddy.model;

public class WeatherData {

    private double currentAirTemp;

    private double morningAirTemp;
    private double afternoonAirTemp;
    private double eveningAirTemp;

    private int morningRainProbability;
    private int afternoonRainProbability;
    private int eveningRainProbability;

    private String firstDayName;
    private String secondDayName;
    private String thirdDayName;

    private double predictedMaxAirTempFirstDay;
    private double predictedMaxAirTempSecondDay;
    private double predictedMaxAirTempThirdDay;

    private double predictedMinAirTempFirstDay;
    private double predictedMinAirTempSecondDay;
    private double predictedMinAirTempThirdDay;

    private int predictedRainInMMFirstDay;
    private int predictedRainInMMSecondDay;
    private int predictedRainInMMThirdDay;

    private int predictedRainProbabilityFirstDay;
    private int predictedRainProbabilitySecondDay;
    private int predictedRainProbabilityThirdDay;

    public WeatherData(double currentAirTemp, double morningAirTemp, double afternoonAirTemp, double eveningAirTemp, int morningRainProbability, int afternoonRainProbability, int eveningRainProbability, String firstDayName, String secondDayName, String thirdDayName, double predictedMaxAirTempFirstDay, double predictedMaxAirTempSecondDay, double predictedMaxAirTempThirdDay, double predictedMinAirTempFirstDay, double predictedMinAirTempSecondDay, double predictedMinAirTempThirdDay, int predictedRainInMMFirstDay, int predictedRainInMMSecondDay, int predictedRainInMMThirdDay, int predictedRainProbabilityFirstDay, int predictedRainProbabilitySecondDay, int predictedRainProbabilityThirdDay) {
        this.currentAirTemp = currentAirTemp;
        this.morningAirTemp = morningAirTemp;
        this.afternoonAirTemp = afternoonAirTemp;
        this.eveningAirTemp = eveningAirTemp;
        this.morningRainProbability = morningRainProbability;
        this.afternoonRainProbability = afternoonRainProbability;
        this.eveningRainProbability = eveningRainProbability;
        this.firstDayName = firstDayName;
        this.secondDayName = secondDayName;
        this.thirdDayName = thirdDayName;
        this.predictedMaxAirTempFirstDay = predictedMaxAirTempFirstDay;
        this.predictedMaxAirTempSecondDay = predictedMaxAirTempSecondDay;
        this.predictedMaxAirTempThirdDay = predictedMaxAirTempThirdDay;
        this.predictedMinAirTempFirstDay = predictedMinAirTempFirstDay;
        this.predictedMinAirTempSecondDay = predictedMinAirTempSecondDay;
        this.predictedMinAirTempThirdDay = predictedMinAirTempThirdDay;
        this.predictedRainInMMFirstDay = predictedRainInMMFirstDay;
        this.predictedRainInMMSecondDay = predictedRainInMMSecondDay;
        this.predictedRainInMMThirdDay = predictedRainInMMThirdDay;
        this.predictedRainProbabilityFirstDay = predictedRainProbabilityFirstDay;
        this.predictedRainProbabilitySecondDay = predictedRainProbabilitySecondDay;
        this.predictedRainProbabilityThirdDay = predictedRainProbabilityThirdDay;
    }

    public WeatherData() {

    }

    @Override
    public String toString() {
        return "WeatherData{" +
                "currentAirTemp=" + currentAirTemp +
                ", morningAirTemp=" + morningAirTemp +
                ", afternoonAirTemp=" + afternoonAirTemp +
                ", eveningAirTemp=" + eveningAirTemp +
                ", morningRainProbability=" + morningRainProbability +
                ", afternoonRainProbability=" + afternoonRainProbability +
                ", eveningRainProbability=" + eveningRainProbability +
                ", firstDayName='" + firstDayName + '\'' +
                ", secondDayName='" + secondDayName + '\'' +
                ", thirdDayName='" + thirdDayName + '\'' +
                ", predictedMaxAirTempFirstDay=" + predictedMaxAirTempFirstDay +
                ", predictedMaxAirTempSecondDay=" + predictedMaxAirTempSecondDay +
                ", predictedMaxAirTempThirdDay=" + predictedMaxAirTempThirdDay +
                ", predictedMinAirTempFirstDay=" + predictedMinAirTempFirstDay +
                ", predictedMinAirTempSecondDay=" + predictedMinAirTempSecondDay +
                ", predictedMinAirTempThirdDay=" + predictedMinAirTempThirdDay +
                ", predictedRainInMMFirstDay=" + predictedRainInMMFirstDay +
                ", predictedRainInMMSecondDay=" + predictedRainInMMSecondDay +
                ", predictedRainInMMThirdDay=" + predictedRainInMMThirdDay +
                ", predictedRainProbabilityFirstDay=" + predictedRainProbabilityFirstDay +
                ", predictedRainProbabilitySecondDay=" + predictedRainProbabilitySecondDay +
                ", predictedRainProbabilityThirdDay=" + predictedRainProbabilityThirdDay +
                '}';
    }

    public double getCurrentAirTemp() {
        return currentAirTemp;
    }

    public void setCurrentAirTemp(double currentAirTemp) {
        this.currentAirTemp = currentAirTemp;
    }

    public double getMorningAirTemp() {
        return morningAirTemp;
    }

    public void setMorningAirTemp(double morningAirTemp) {
        this.morningAirTemp = morningAirTemp;
    }

    public double getAfternoonAirTemp() {
        return afternoonAirTemp;
    }

    public void setAfternoonAirTemp(double afternoonAirTemp) {
        this.afternoonAirTemp = afternoonAirTemp;
    }

    public double getEveningAirTemp() {
        return eveningAirTemp;
    }

    public void setEveningAirTemp(double eveningAirTemp) {
        this.eveningAirTemp = eveningAirTemp;
    }

    public int getMorningRainProbability() {
        return morningRainProbability;
    }

    public void setMorningRainProbability(int morningRainProbability) {
        this.morningRainProbability = morningRainProbability;
    }

    public int getAfternoonRainProbability() {
        return afternoonRainProbability;
    }

    public void setAfternoonRainProbability(int afternoonRainProbability) {
        this.afternoonRainProbability = afternoonRainProbability;
    }

    public int getEveningRainProbability() {
        return eveningRainProbability;
    }

    public void setEveningRainProbability(int eveningRainProbability) {
        this.eveningRainProbability = eveningRainProbability;
    }

    public String getFirstDayName() {
        return firstDayName;
    }

    public void setFirstDayName(String firstDayName) {
        this.firstDayName = firstDayName;
    }

    public String getSecondDayName() {
        return secondDayName;
    }

    public void setSecondDayName(String secondDayName) {
        this.secondDayName = secondDayName;
    }

    public String getThirdDayName() {
        return thirdDayName;
    }

    public void setThirdDayName(String thirdDayName) {
        this.thirdDayName = thirdDayName;
    }

    public double getPredictedMaxAirTempFirstDay() {
        return predictedMaxAirTempFirstDay;
    }

    public void setPredictedMaxAirTempFirstDay(double predictedMaxAirTempFirstDay) {
        this.predictedMaxAirTempFirstDay = predictedMaxAirTempFirstDay;
    }

    public double getPredictedMaxAirTempSecondDay() {
        return predictedMaxAirTempSecondDay;
    }

    public void setPredictedMaxAirTempSecondDay(double predictedMaxAirTempSecondDay) {
        this.predictedMaxAirTempSecondDay = predictedMaxAirTempSecondDay;
    }

    public double getPredictedMaxAirTempThirdDay() {
        return predictedMaxAirTempThirdDay;
    }

    public void setPredictedMaxAirTempThirdDay(double predictedMaxAirTempThirdDay) {
        this.predictedMaxAirTempThirdDay = predictedMaxAirTempThirdDay;
    }

    public double getPredictedMinAirTempFirstDay() {
        return predictedMinAirTempFirstDay;
    }

    public void setPredictedMinAirTempFirstDay(double predictedMinAirTempFirstDay) {
        this.predictedMinAirTempFirstDay = predictedMinAirTempFirstDay;
    }

    public double getPredictedMinAirTempSecondDay() {
        return predictedMinAirTempSecondDay;
    }

    public void setPredictedMinAirTempSecondDay(double predictedMinAirTempSecondDay) {
        this.predictedMinAirTempSecondDay = predictedMinAirTempSecondDay;
    }

    public double getPredictedMinAirTempThirdDay() {
        return predictedMinAirTempThirdDay;
    }

    public void setPredictedMinAirTempThirdDay(double predictedMinAirTempThirdDay) {
        this.predictedMinAirTempThirdDay = predictedMinAirTempThirdDay;
    }

    public int getPredictedRainInMMFirstDay() {
        return predictedRainInMMFirstDay;
    }

    public void setPredictedRainInMMFirstDay(int predictedRainInMMFirstDay) {
        this.predictedRainInMMFirstDay = predictedRainInMMFirstDay;
    }

    public int getPredictedRainInMMSecondDay() {
        return predictedRainInMMSecondDay;
    }

    public void setPredictedRainInMMSecondDay(int predictedRainInMMSecondDay) {
        this.predictedRainInMMSecondDay = predictedRainInMMSecondDay;
    }

    public int getPredictedRainInMMThirdDay() {
        return predictedRainInMMThirdDay;
    }

    public void setPredictedRainInMMThirdDay(int predictedRainInMMThirdDay) {
        this.predictedRainInMMThirdDay = predictedRainInMMThirdDay;
    }

    public int getPredictedRainProbabilityFirstDay() {
        return predictedRainProbabilityFirstDay;
    }

    public void setPredictedRainProbabilityFirstDay(int predictedRainProbabilityFirstDay) {
        this.predictedRainProbabilityFirstDay = predictedRainProbabilityFirstDay;
    }

    public int getPredictedRainProbabilitySecondDay() {
        return predictedRainProbabilitySecondDay;
    }

    public void setPredictedRainProbabilitySecondDay(int predictedRainProbabilitySecondDay) {
        this.predictedRainProbabilitySecondDay = predictedRainProbabilitySecondDay;
    }

    public int getPredictedRainProbabilityThirdDay() {
        return predictedRainProbabilityThirdDay;
    }

    public void setPredictedRainProbabilityThirdDay(int predictedRainProbabilityThirdDay) {
        this.predictedRainProbabilityThirdDay = predictedRainProbabilityThirdDay;
    }
}
