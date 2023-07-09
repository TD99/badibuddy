package ch.tcraft.badibuddy.ui.weather;

import android.content.Context;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import org.json.JSONException;

import ch.tcraft.badibuddy.R;
import ch.tcraft.badibuddy.api.MeteoApi;
import ch.tcraft.badibuddy.helper.WeatherDataJsonParser;
import ch.tcraft.badibuddy.model.WeatherData;
import ch.tcraft.badibuddy.util.DialogUtils;


//TODO: Use string resource "degree"
public class WeatherViewModel extends ViewModel {

    private final MutableLiveData<String> currentAirTemp;

    //Prognosis for the day
    private final MutableLiveData<String> morningAirTemp;
    private final MutableLiveData<String> afternoonAirTemp;
    private final MutableLiveData<String> eveningAirTemp;
    //Rain Prognosis for the day
    private final MutableLiveData<String> morningRainProbability;
    private final MutableLiveData<String> afternoonRainProbability;
    private final MutableLiveData<String> eveningRainProbability;

    //Prognosis for the next 3 days
    //Max Temp
    private final MutableLiveData<String> predictedMaxAirTempFirstDay;
    private final MutableLiveData<String> predictedMaxAirTempSecondDay;
    private final MutableLiveData<String> predictedMaxAirTempThirdDay;

    //MinTemp
    private final MutableLiveData<String> predictedMinAirTempFirstDay;
    private final MutableLiveData<String> predictedMinAirTempSecondDay;
    private final MutableLiveData<String> predictedMinAirTempThirdDay;

    //Rain in mm
    private final MutableLiveData<String> predictedRainInMMFirstDay;
    private final MutableLiveData<String> predictedRainInMMSecondDay;
    private final MutableLiveData<String> predictedRainInMMThirdDay;

    //Rain probability
    private final MutableLiveData<String> predictedRainProbabilityFirstDay;
    private final MutableLiveData<String> predictedRainProbabilitySecondDay;
    private final MutableLiveData<String> predictedRainProbabilityThirdDay;

    private final MutableLiveData<String> firstDayName;
    private final MutableLiveData<String> secondDayName;
    private final MutableLiveData<String> thirdDayName;

    private final MutableLiveData<String> firstDay;
    private final MutableLiveData<String> secondDay;
    private final MutableLiveData<String> thirdDay;

    public WeatherViewModel(Context appContext, Context senderContext) {
        this.currentAirTemp = new MutableLiveData<>();

        //Prognosis for the day
        this.morningAirTemp = new MutableLiveData<>();
        this.afternoonAirTemp = new MutableLiveData<>();
        this.eveningAirTemp = new MutableLiveData<>();

        //Rain Prognosis for the day
        this.morningRainProbability = new MutableLiveData<>();
        this.afternoonRainProbability = new MutableLiveData<>();
        this.eveningRainProbability = new MutableLiveData<>();

        //Prognosis for the next 3 Days
        this.predictedMaxAirTempFirstDay = new MutableLiveData<>();
        this.predictedMaxAirTempSecondDay = new MutableLiveData<>();
        this.predictedMaxAirTempThirdDay = new MutableLiveData<>();

        this.predictedMinAirTempFirstDay = new MutableLiveData<>();
        this.predictedMinAirTempSecondDay = new MutableLiveData<>();
        this.predictedMinAirTempThirdDay = new MutableLiveData<>();

        this.predictedRainInMMFirstDay = new MutableLiveData<>();
        this.predictedRainInMMSecondDay = new MutableLiveData<>();
        this.predictedRainInMMThirdDay = new MutableLiveData<>();

        this.predictedRainProbabilityFirstDay = new MutableLiveData<>();
        this.predictedRainProbabilitySecondDay = new MutableLiveData<>();
        this.predictedRainProbabilityThirdDay = new MutableLiveData<>();

        this.firstDayName = new MutableLiveData<>();
        this.secondDayName = new MutableLiveData<>();
        this.thirdDayName = new MutableLiveData<>();

        this.firstDay = new MutableLiveData<>();
        this.secondDay = new MutableLiveData<>();
        this.thirdDay = new MutableLiveData<>();

        MeteoApi.requestMeteoDataAsJsonString("bern", appContext,
                (result) -> {
                    Toast toast = Toast.makeText(senderContext, R.string.text_getting_data, Toast.LENGTH_SHORT);
                    toast.show();

                    try {
                        WeatherData weatherData = WeatherDataJsonParser.createWeatherDataFromJsonString(result);

                        currentAirTemp.setValue(weatherData.getCurrentAirTemp() + "°");

                        morningAirTemp.setValue(weatherData.getMorningAirTemp() + "°");
                        afternoonAirTemp.setValue(weatherData.getAfternoonAirTemp() + "°");
                        eveningAirTemp.setValue(weatherData.getEveningAirTemp() + "°");

                        morningRainProbability.setValue(weatherData.getMorningRainProbability() + "%");
                        afternoonRainProbability.setValue(weatherData.getAfternoonRainProbability() + "%");
                        eveningRainProbability.setValue(weatherData.getEveningRainProbability() + "%");

                        predictedMaxAirTempFirstDay.setValue(weatherData.getPredictedMaxAirTempFirstDay() + "°");
                        predictedMaxAirTempSecondDay.setValue(weatherData.getPredictedMaxAirTempSecondDay() + "°");
                        predictedMaxAirTempThirdDay.setValue(weatherData.getPredictedMaxAirTempThirdDay() + "°");

                        predictedMinAirTempFirstDay.setValue(weatherData.getPredictedMinAirTempFirstDay() + "°");
                        predictedMinAirTempSecondDay.setValue(weatherData.getPredictedMinAirTempSecondDay() + "°");
                        predictedMinAirTempThirdDay.setValue(weatherData.getPredictedMinAirTempThirdDay() + "°");

                        predictedRainInMMFirstDay.setValue(weatherData.getPredictedRainInMMFirstDay() + "mm");
                        predictedRainInMMSecondDay.setValue(weatherData.getPredictedRainInMMSecondDay() + "mm");
                        predictedRainInMMThirdDay.setValue(weatherData.getPredictedRainInMMThirdDay() + "mm");

                        predictedRainProbabilityFirstDay.setValue(weatherData.getPredictedRainProbabilityFirstDay() + "%");
                        predictedRainProbabilitySecondDay.setValue(weatherData.getPredictedRainProbabilitySecondDay() + "%");
                        predictedRainProbabilityThirdDay.setValue(weatherData.getPredictedRainProbabilityThirdDay() + "%");

                        firstDayName.setValue(String.valueOf(weatherData.getFirstDayName()));
                        secondDayName.setValue(String.valueOf(weatherData.getSecondDayName()));
                        thirdDayName.setValue(String.valueOf(weatherData.getThirdDayName()));

                        // TODO: Split up in different elements
                        // working non-clean code because it would have taken too long to split it up properly (Lorenzo)
                        firstDay.setValue(
                                weatherData.getFirstDayName() + "\n\n" +
                                        weatherData.getPredictedMinAirTempFirstDay() + "°" +
                                        " - " +
                                        weatherData.getPredictedMaxAirTempFirstDay() + "°" +
                                        "\n\n" +
                                        weatherData.getPredictedRainInMMFirstDay() + "mm" +
                                        "\n\n" +
                                        weatherData.getPredictedRainProbabilityFirstDay() + "%");

                        secondDay.setValue(
                                weatherData.getSecondDayName() + "\n\n" +
                                        weatherData.getPredictedMinAirTempSecondDay() + "°" +
                                        " - " +
                                        weatherData.getPredictedMaxAirTempSecondDay() + "°" +
                                        "\n\n" +
                                        weatherData.getPredictedRainInMMSecondDay() + "mm" +
                                        "\n\n" +
                                        weatherData.getPredictedRainProbabilitySecondDay() + "%");

                        thirdDay.setValue(
                                weatherData.getThirdDayName() + "\n\n" +
                                        weatherData.getPredictedMinAirTempThirdDay() + "°" +
                                        " - " +
                                        weatherData.getPredictedMaxAirTempThirdDay() + "°" +
                                        "\n\n" +
                                        weatherData.getPredictedRainInMMThirdDay() + "mm" +
                                        "\n\n" +
                                        weatherData.getPredictedRainProbabilityThirdDay() + "%");
                    } catch (JSONException error) {
                        error.printStackTrace();
                        DialogUtils.showAlert(appContext.getString(R.string.text_json_exception, "Water-JSON", error.getLocalizedMessage()), appContext.getString(R.string.title_error), senderContext);
                    }

                },
                (error) -> {
                    error.printStackTrace();
                    DialogUtils.showAlert(appContext.getString(R.string.text_api_exception, "Water-API", error.getLocalizedMessage()), appContext.getString(R.string.title_error), senderContext);
                });
    }

    public LiveData<String> getCurrentAirTemp() {
        return currentAirTemp;
    }

    //Prognosis for the day
    public LiveData<String> getMorningAirTemp() {
        return morningAirTemp;
    }

    public LiveData<String> getAfternoonAirTemp() {
        return afternoonAirTemp;
    }

    public LiveData<String> getEveningAirTemp() {
        return eveningAirTemp;
    }

    //Rain Prognosis for the day
    public LiveData<String> getMorningRainProbability() {
        return morningRainProbability;
    }

    public LiveData<String> getAfternoonRainProbability() {
        return afternoonRainProbability;
    }

    public LiveData<String> getEveningRainProbability() {
        return eveningRainProbability;
    }

    //Prognosis for the next 3 days
    public LiveData<String> getPredictedMaxAirTempFirstDay() {
        return predictedMaxAirTempFirstDay;
    }

    public LiveData<String> getPredictedMaxAirTempSecondDay() {
        return predictedMaxAirTempSecondDay;
    }

    public LiveData<String> getPredictedMaxAirTempThirdDay() {
        return predictedMaxAirTempThirdDay;
    }

    public LiveData<String> getPredictedMinAirTempFirstDay() {
        return predictedMinAirTempFirstDay;
    }

    public LiveData<String> getPredictedMinAirTempSecondDay() {
        return predictedMinAirTempSecondDay;
    }

    public LiveData<String> getPredictedMinAirTempThirdDay() {
        return predictedMinAirTempThirdDay;
    }

    public LiveData<String> getPredictedRainInMMFirstDay() {
        return predictedRainInMMFirstDay;
    }

    public LiveData<String> getPredictedRainInMMSecondDay() {
        return predictedRainInMMSecondDay;
    }

    public LiveData<String> getPredictedRainInMMThirdDay() {
        return predictedRainInMMThirdDay;
    }

    public LiveData<String> getPredictedRainProbabilityFirstDay() {
        return predictedRainProbabilityFirstDay;
    }

    public LiveData<String> getPredictedRainProbabilitySecondDay() {
        return predictedRainProbabilitySecondDay;
    }

    public LiveData<String> getPredictedRainProbabilityThirdDay() {
        return predictedRainProbabilityThirdDay;
    }

    public MutableLiveData<String> getFirstDayName() {
        return firstDayName;
    }

    public MutableLiveData<String> getSecondDayName() {
        return secondDayName;
    }

    public MutableLiveData<String> getThirdDayName() {
        return thirdDayName;
    }

    public MutableLiveData<String> getFirstDay() {
        return firstDay;
    }

    public MutableLiveData<String> getSecondDay() {
        return secondDay;
    }

    public MutableLiveData<String> getThirdDay() {
        return thirdDay;
    }
}
