package ch.tcraft.badibuddy.ui.water;

import android.content.Context;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import org.json.JSONException;

import ch.tcraft.badibuddy.R;
import ch.tcraft.badibuddy.api.MeteoApi;
import ch.tcraft.badibuddy.helper.WaterDataJsonParser;
import ch.tcraft.badibuddy.model.WaterData;
import ch.tcraft.badibuddy.util.DialogUtils;

public class WaterViewModel extends ViewModel {
    private final MutableLiveData<String> currentWaterTemp;
    private final MutableLiveData<String> waterAmount;
    private final MutableLiveData<String> predictedWaterTemp;
    private final MutableLiveData<String> airTemp;
    private final MutableLiveData<String> updateString;

    public WaterViewModel(Context appContext, Context senderContext) {
        this.currentWaterTemp = new MutableLiveData<>();
        this.waterAmount = new MutableLiveData<>();
        this.predictedWaterTemp = new MutableLiveData<>();
        this.airTemp = new MutableLiveData<>();
        this.updateString = new MutableLiveData<>();

        // TODO: Take location selected instead of default "bern"
        MeteoApi.requestMeteoDataAsJsonString("bern", appContext,
                (result) -> {
                    Toast toast = Toast.makeText(senderContext, R.string.text_getting_data, Toast.LENGTH_SHORT);
                    toast.show();

                    try {
                        WaterData waterData = WaterDataJsonParser.createWaterDataFromJsonString(result);

                        currentWaterTemp.setValue(appContext.getString(R.string.text_degrees, waterData.getTemperature()));
                        waterAmount.setValue(String.valueOf(waterData.getFlow()));
                        predictedWaterTemp.setValue(appContext.getString(R.string.text_degrees, waterData.getTemperatureForecast2h()));
                        airTemp.setValue(String.valueOf(waterData.getAirTemperature()));
                        updateString.setValue(String.valueOf(waterData.getTimeString()));
                    } catch (JSONException error) {
                        error.printStackTrace();
                        DialogUtils.showAlert(appContext.getString(R.string.text_json_exception, "Water-JSON", error.getLocalizedMessage()), appContext.getString(R.string.title_error), senderContext);
                    }
                }, (error) -> {
                    error.printStackTrace();
                    DialogUtils.showAlert(appContext.getString(R.string.text_api_exception, "Water-API", error.getLocalizedMessage()), appContext.getString(R.string.title_error), senderContext);
                });

    }

    public LiveData<String> getCurrentWaterTemp() {
        return currentWaterTemp;
    }

    public LiveData<String> getWaterAmount() {
        return waterAmount;
    }

    public LiveData<String> getPredictedWaterTemp() {
        return predictedWaterTemp;
    }

    public LiveData<String> getAirTemp() {
        return airTemp;
    }

    public MutableLiveData<String> getUpdateString() {
        return updateString;
    }
}