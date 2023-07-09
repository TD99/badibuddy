package ch.tcraft.badibuddy.ui.water;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class WaterViewModelFactory implements ViewModelProvider.Factory {
    private final Application application;
    private final Fragment sender;

    public WaterViewModelFactory(Application application, Fragment sender) {
        this.application = application;
        this.sender = sender;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new WaterViewModel(application.getApplicationContext(), sender.getContext());
    }
}
