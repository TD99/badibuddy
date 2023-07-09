package ch.tcraft.badibuddy.ui.water;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import ch.tcraft.badibuddy.databinding.FragmentWaterBinding;

public class WaterFragment extends Fragment {

    private FragmentWaterBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        WaterViewModel waterViewModel = new ViewModelProvider(this, new WaterViewModelFactory(this.requireActivity().getApplication(), this)).get(WaterViewModel.class);

        binding = FragmentWaterBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textCurrentWaterTemp = binding.currentWaterTemp;
        waterViewModel.getCurrentWaterTemp().observe(getViewLifecycleOwner(), textCurrentWaterTemp::setText);

        final TextView textWaterAmount = binding.waterAmount;
        waterViewModel.getWaterAmount().observe(getViewLifecycleOwner(), textWaterAmount::setText);

        final TextView textPredictedWaterTemp = binding.predictedWaterTemp;
        waterViewModel.getPredictedWaterTemp().observe(getViewLifecycleOwner(), textPredictedWaterTemp::setText);

        final TextView textAirTemperature = binding.airTemperature;
        waterViewModel.getAirTemp().observe(getViewLifecycleOwner(), textAirTemperature::setText);

        final TextView textUpdateString = binding.lastUpdate;
        waterViewModel.getUpdateString().observe(getViewLifecycleOwner(), textUpdateString::setText);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}