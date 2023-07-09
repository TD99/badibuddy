package ch.tcraft.badibuddy.ui.weather;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import ch.tcraft.badibuddy.databinding.FragmentWeatherBinding;

public class WeatherFragment extends Fragment {
    // TODO: Display time of access of WeatherData from API

    private FragmentWeatherBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        WeatherViewModel weatherViewModel = new ViewModelProvider(this, new WeatherViewModelFactory(this.requireActivity().getApplication(), this)).get(WeatherViewModel.class);

        binding = FragmentWeatherBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.currentAirTemperature;
        weatherViewModel.getCurrentAirTemp().observe(getViewLifecycleOwner(), textView::setText);

        //Prediction for the day
        final TextView textView1 = binding.morningAirTemp;
        weatherViewModel.getMorningAirTemp().observe(getViewLifecycleOwner(), textView1::setText);

        final TextView textView2 = binding.afternoonAirTemp;
        weatherViewModel.getAfternoonAirTemp().observe(getViewLifecycleOwner(), textView2::setText);

        final TextView textView3 = binding.eveningAirTemp;
        weatherViewModel.getEveningAirTemp().observe(getViewLifecycleOwner(), textView3::setText);

        final TextView textView7 = binding.morningRain;
        weatherViewModel.getMorningRainProbability().observe(getViewLifecycleOwner(), textView7::setText);

        final TextView textView8 = binding.afternoonRain2;
        weatherViewModel.getAfternoonRainProbability().observe(getViewLifecycleOwner(), textView8::setText);

        final TextView textView9 = binding.eveningRain;
        weatherViewModel.getEveningRainProbability().observe(getViewLifecycleOwner(), textView9::setText);

        final TextView afternoonRainText = binding.morningRain;
        weatherViewModel.getMorningRainProbability();

        final TextView eveningRainText = binding.morningRain;
        weatherViewModel.getMorningRainProbability();
        //Prediction for the next 3 days
        final TextView textView4 = binding.predictedAirTempFirstDay;
        weatherViewModel.getFirstDay().observe(getViewLifecycleOwner(), textView4::setText);

        final TextView textView5 = binding.predictedAirTempSecondDay;
        weatherViewModel.getSecondDay().observe(getViewLifecycleOwner(), textView5::setText);

        final TextView textView6 = binding.predictedAirTempThirdDay;
        weatherViewModel.getThirdDay().observe(getViewLifecycleOwner(), textView6::setText);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}