package com.dp.examdb.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.dp.examdb.R;
import com.dp.examdb.Utils.AppUtils;

public class SplashActivity extends AppCompatActivity {
    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        dialog = new ProgressDialog(this);
        dialog.setTitle("Loading");
        dialog.setMessage("Please wait.");
        dialog.show();

        if (!AppUtils.isNetworkAvailable(this)) {
            startActivity(new Intent(this, NoInternetConnection.class));
            if (dialog.isShowing())
                dialog.dismiss();
        } else {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(new Intent(SplashActivity.this, MainActivity.class));
                    if (dialog.isShowing())
                        dialog.dismiss();
                }
            }, 1000);
        }
    }
}