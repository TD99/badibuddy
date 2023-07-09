package ch.tcraft.badibuddy.util;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;

public class NetworkUtils {
    /**
     * Checks if a network is available.
     *
     * @param connectivityManager the connectivity manager used to check the network availability
     * @return true if a network is available, false otherwise
     */
    public static Boolean isNetworkAvailable(ConnectivityManager connectivityManager) {
        Network network = connectivityManager.getActiveNetwork();
        if (network == null) return false;
        NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(network);
        return networkCapabilities != null && (
                networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) ||
                        networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) ||
                        networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) ||
                        networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_BLUETOOTH)
        );
    }
}
