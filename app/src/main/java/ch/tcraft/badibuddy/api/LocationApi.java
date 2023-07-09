package ch.tcraft.badibuddy.api;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.function.Consumer;

public class LocationApi {
    private static final String API_URL = "https://aareguru.existenz.ch/v2018/cities";

    public static void requestLocationDataAsJsonString(Context context, Consumer<String> successCallback, Consumer<VolleyError> errorCallback) {
        RequestQueue queue = Volley.newRequestQueue(context);

        StringRequest stringRequest = new StringRequest(Request.Method.GET, API_URL, successCallback::accept, errorCallback::accept);
        queue.add(stringRequest);
    }
}
