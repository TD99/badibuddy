package ch.tcraft.badibuddy.ui.weather;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class WeatherViewModelFactory implements ViewModelProvider.Factory {
    private final Application application;
    private final Fragment sender;

    public WeatherViewModelFactory(Application application, Fragment sender) {
        this.application = application;
        this.sender = sender;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new WeatherViewModel(application.getApplicationContext(), sender.getContext());
    }
}
