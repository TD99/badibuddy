package ch.tcraft.badibuddy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ch.tcraft.badibuddy.model.LocationData;

public class LocationAdapter extends RecyclerView.Adapter<LocationViewHolder> {
    Context context;
    List<LocationData> items;

    public LocationAdapter(Context context, List<LocationData> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public LocationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LocationViewHolder(LayoutInflater.from(context).inflate(R.layout.activity_location_item_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull LocationViewHolder holder, int position) {
        holder.titleText.setText(items.get(position).getLocationName());
        holder.aareTemperatureText.setText(context.getString(R.string.text_degrees, items.get(position).getAareTemperature()));
        holder.minAirTemperatureText.setText(context.getString(R.string.text_degrees, items.get(position).getMinAirTemperature()));
        holder.maxAirTemperatureText.setText(context.getString(R.string.text_degrees, items.get(position).getMaxAirTemperature()));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
