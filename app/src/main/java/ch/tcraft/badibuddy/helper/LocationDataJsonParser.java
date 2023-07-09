package ch.tcraft.badibuddy.helper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import ch.tcraft.badibuddy.model.LocationData;

public class LocationDataJsonParser {
    public static LocationData[] createLocationDataArrayFromJsonString(String locationsJsonString) throws JSONException {
        JSONArray jsonArray = new JSONArray(locationsJsonString);
        LocationData[] locationDataArray = new LocationData[jsonArray.length()];

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject locationObject = jsonArray.getJSONObject(i);

            String locationName = locationObject.optString("name");
            double aareTemperature = locationObject.optDouble("aare");
            double minAirTemperature = locationObject.optDouble("tn");
            double maxAirTemperature = locationObject.optDouble("tx");

            LocationData locationData = new LocationData(locationName, aareTemperature, minAirTemperature, maxAirTemperature);
            locationDataArray[i] = locationData;
        }

        return locationDataArray;
    }
}
