package ch.tcraft.badibuddy;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONException;

import java.util.Arrays;
import java.util.List;

import ch.tcraft.badibuddy.api.LocationApi;
import ch.tcraft.badibuddy.helper.LocationDataJsonParser;
import ch.tcraft.badibuddy.model.LocationData;
import ch.tcraft.badibuddy.util.DialogUtils;

public class LocationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
        setTitle(R.string.title_location);

        // setup of up button
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // get location data
        RecyclerView recyclerView = findViewById(R.id.location_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        LocationApi.requestLocationDataAsJsonString(getApplicationContext(),
                (result) -> {
                    Toast toast = Toast.makeText(this, R.string.text_getting_data, Toast.LENGTH_SHORT);
                    toast.show();

                    try {
                        List<LocationData> locationData = Arrays.asList(LocationDataJsonParser.createLocationDataArrayFromJsonString(result));
                        recyclerView.setAdapter(new LocationAdapter(getApplicationContext(), locationData));
                    } catch (JSONException error) {
                        error.printStackTrace();
                        DialogUtils.showAlert(getApplicationContext().getString(R.string.text_json_exception, "Water-JSON", error.getLocalizedMessage()), getApplicationContext().getString(R.string.title_error), this);
                    }
                }, (error) -> {
                    error.printStackTrace();
                    DialogUtils.showAlert(getApplicationContext().getString(R.string.text_api_exception, "Water-API", error.getLocalizedMessage()), getApplicationContext().getString(R.string.title_error), this);
                });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if (itemId != android.R.id.home) {
            return super.onOptionsItemSelected(item);
        }

        onBackPressed();
        return true;
    }
}