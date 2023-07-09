package ch.tcraft.badibuddy;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LocationViewHolder extends RecyclerView.ViewHolder {
    TextView titleText;
    TextView aareTemperatureText;
    TextView minAirTemperatureText;
    TextView maxAirTemperatureText;

    public LocationViewHolder(@NonNull View itemView) {
        super(itemView);

        titleText = itemView.findViewById(R.id.item_title);
        aareTemperatureText = itemView.findViewById(R.id.item_aare_temperature);
        minAirTemperatureText = itemView.findViewById(R.id.item_min_air_temperature);
        maxAirTemperatureText = itemView.findViewById(R.id.item_max_air_temperature);
    }
}
