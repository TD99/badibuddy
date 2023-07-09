package ch.tcraft.badibuddy.ui.pool;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PoolViewModel extends ViewModel {
    private final MutableLiveData<String> mText;

    public PoolViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is pool fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}