package net.mindzone.mindshopui;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import net.mindzone.mindshopui.models.AppConfig;

import static net.mindzone.mindshopui.constants.Constants.LOGTAG;

public class BaseActivity extends AppCompatActivity
{
    public AppConfig config;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }



    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        checkApplicationSettings();
    }
    private void checkApplicationSettings()
    {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        final DocumentReference docRef = db.collection("system").document("config");
        docRef.addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot snapshot, @Nullable FirebaseFirestoreException e) {
                if (e != null)
                {
                    Log.w(LOGTAG, "Application not configured?", e);
                    return;
                }
                if (snapshot != null && snapshot.exists()) {
                    config = snapshot.toObject(AppConfig.class);
                    Log.d(LOGTAG, "Current data: " + config.toString());
                    if (config.offline == 1)
                    {
                        new AlertDialog.Builder(BaseActivity.this)
                                .setTitle("Offline")
                                .setMessage(config.offlineMessage)
                                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which)
                                    {
                                        System.exit(0);
                                    }
                                })
                                .setIcon(android.R.drawable.ic_dialog_alert)
                                .show();
                    }

                } else {
                    Log.w(LOGTAG, "Application not configured?", e);
                }
            }
        });
    }
}