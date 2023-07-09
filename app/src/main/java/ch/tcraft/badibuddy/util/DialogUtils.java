package ch.tcraft.badibuddy.util;

import android.content.Context;

import androidx.appcompat.app.AlertDialog;

public class DialogUtils {
    public static void showAlert(String message, String title, Context context) {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context);
        dialogBuilder.setPositiveButton("Ok", (dialog, id) -> {
            // Closes this activity finish();
        });
        dialogBuilder.setMessage(message).setTitle(title);
        AlertDialog dialog = dialogBuilder.create();
        dialog.show();
    }
}
