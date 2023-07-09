package ch.tcraft.badibuddy;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import ch.tcraft.badibuddy.databinding.ActivityMainBinding;
import ch.tcraft.badibuddy.util.NetworkUtils;
import ch.tcraft.badibuddy.util.ThemeUtils;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Apply the selected theme
        SharedPreferences preferences = getSharedPreferences("ThemePrefs", MODE_PRIVATE);
        boolean isDarkTheme = preferences.getBoolean("isDarkTheme", ThemeUtils.isUsingNightModeResources(getResources()));

        if (isDarkTheme) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Navigation Setup
        BottomNavigationView navView = findViewById(R.id.nav_view);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_water, R.id.navigation_weather, R.id.navigation_sun, R.id.navigation_pool, R.id.navigation_settings
        ).build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);

        // Hide Title Bar
        getSupportActionBar().hide();

        checkInternet();

        // set location button handler
        Button locationButton = findViewById(R.id.location_button);
        locationButton.setOnClickListener(
                view -> {
                    Intent intent = new Intent(MainActivity.this, LocationActivity.class);
                    startActivity(intent);
                }
        );
    }

    @Override
    protected void onResume() {
        super.onResume();

        checkInternet();
    }

    /**
     * Checks the availability of internet connectivity.
     * <p>
     * If there is no internet connection, displays an alert dialog with options to try again or continue anyway.
     */
    private void checkInternet() {
        Context appContext = getApplicationContext();
        ConnectivityManager connectivityManager = (ConnectivityManager) appContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        boolean hasInternet = NetworkUtils.isNetworkAvailable(connectivityManager);

        if (!hasInternet) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(R.string.text_no_internet)
                    .setCancelable(false)
                    .setNeutralButton(R.string.text_try_again, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            checkInternet();
                        }
                    })
                    .setNegativeButton(R.string.text_continue_anyway, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            // close modal
                        }
                    });
            AlertDialog alert = builder.create();
            alert.show();
        }
    }
}
