package ch.tcraft.badibuddy.helper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import ch.tcraft.badibuddy.model.WeatherData;

public class WeatherDataJsonParser {
    public static WeatherData createWeatherDataFromJsonString(String weatherDataJsonString) throws JSONException {

        JSONObject root = new JSONObject(weatherDataJsonString);
        JSONObject weather = root.getJSONObject("weather");
        JSONObject currentWeather = weather.getJSONObject("current");

        JSONObject todayWeather = weather.getJSONObject("today");
        JSONObject morningWeather = todayWeather.getJSONObject("v");
        JSONObject afternoonWeather = todayWeather.getJSONObject("n");
        JSONObject eveningWeather = todayWeather.getJSONObject("a");

        //Next 3 Days
        JSONArray forecastWeather = weather.getJSONArray("forecast");
        JSONObject firstDayForecast = forecastWeather.getJSONObject(0);
        JSONObject secondDayForecast = forecastWeather.getJSONObject(1);
        JSONObject thirdDayForecast = forecastWeather.getJSONObject(2);

        WeatherData weatherData = new WeatherData();
        //Current weather
        weatherData.setCurrentAirTemp(currentWeather.getDouble("tt"));

        //Weather throughout the day
        weatherData.setMorningAirTemp(morningWeather.getDouble("tt"));
        weatherData.setAfternoonAirTemp(afternoonWeather.getDouble("tt"));
        weatherData.setEveningAirTemp(eveningWeather.getDouble("tt"));

        weatherData.setMorningRainProbability(morningWeather.getInt("rrisk"));
        weatherData.setAfternoonRainProbability(afternoonWeather.getInt("rrisk"));
        weatherData.setEveningRainProbability(eveningWeather.getInt("rrisk"));

        //Next 3 Days
        //Max Temperature
        weatherData.setPredictedMaxAirTempFirstDay(firstDayForecast.getDouble("tx"));
        weatherData.setPredictedMaxAirTempSecondDay(secondDayForecast.getDouble("tx"));
        weatherData.setPredictedMaxAirTempThirdDay(thirdDayForecast.getDouble("tx"));

        //Min Temperature
        weatherData.setPredictedMinAirTempFirstDay(firstDayForecast.getDouble("tn"));
        weatherData.setPredictedMinAirTempSecondDay(secondDayForecast.getDouble("tn"));
        weatherData.setPredictedMinAirTempThirdDay(thirdDayForecast.getDouble("tn"));

        //Rain in mm
        weatherData.setPredictedRainInMMFirstDay(firstDayForecast.getInt("rr"));
        weatherData.setPredictedRainInMMSecondDay(secondDayForecast.getInt("rr"));
        weatherData.setPredictedRainInMMThirdDay(thirdDayForecast.getInt("rr"));

        //Rain probability
        weatherData.setPredictedRainProbabilityFirstDay(firstDayForecast.getInt("rrisk"));
        weatherData.setPredictedRainProbabilitySecondDay(secondDayForecast.getInt("rrisk"));
        weatherData.setPredictedRainProbabilityThirdDay(thirdDayForecast.getInt("rrisk"));

        //Day names
        weatherData.setFirstDayName(firstDayForecast.getString("day"));
        weatherData.setSecondDayName(secondDayForecast.getString("day"));
        weatherData.setThirdDayName(thirdDayForecast.getString("day"));

        return weatherData;
    }
}
