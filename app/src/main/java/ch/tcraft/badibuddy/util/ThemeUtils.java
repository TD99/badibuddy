package ch.tcraft.badibuddy.util;

import android.content.res.Configuration;
import android.content.res.Resources;

import androidx.annotation.NonNull;

public class ThemeUtils {
    /**
     * Checks if the device is using night mode resources.
     *
     * @param resources the resources used to check the night mode status
     * @return true if the device is using night mode resources, false otherwise
     */
    public static boolean isUsingNightModeResources(@NonNull Resources resources) {
        return (resources.getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK) == Configuration.UI_MODE_NIGHT_YES;
    }
}
