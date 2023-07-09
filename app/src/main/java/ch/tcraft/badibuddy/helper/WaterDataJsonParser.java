package ch.tcraft.badibuddy.helper;

import org.json.JSONException;
import org.json.JSONObject;

import ch.tcraft.badibuddy.model.WaterData;

public class WaterDataJsonParser {
    public static WaterData createWaterDataFromJsonString(String waterDataJsonString) throws JSONException {
        JSONObject root = new JSONObject(waterDataJsonString);
        JSONObject aare = root.getJSONObject("aare");
        JSONObject weather = root.getJSONObject("weather");
        JSONObject currentWeather = weather.getJSONObject("current");

        WaterData waterData = new WaterData();
        waterData.setTemperature(aare.getDouble("temperature"));
        waterData.setTemperatureForecast2h(aare.getDouble("forecast2h"));
        waterData.setTimeString(aare.getString("timestring"));
        waterData.setFlow(aare.getInt("flow"));
        waterData.setAirTemperature(currentWeather.getDouble("tt"));

        return waterData;
    }
}
