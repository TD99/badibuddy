package ch.tcraft.badibuddy.ui.pool;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import ch.tcraft.badibuddy.databinding.FragmentPoolBinding;

public class PoolFragment extends Fragment {
    // TODO: Create Pool fragment (Badi Maps)

    private FragmentPoolBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        PoolViewModel sunViewModel =
                new ViewModelProvider(this).get(PoolViewModel.class);

        binding = FragmentPoolBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textPool;
        sunViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}