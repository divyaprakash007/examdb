package com.dp.examdb.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.dp.examdb.R;
import com.dp.examdb.Utils.AppUtils;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SplashActivity extends AppCompatActivity {
    private ProgressDialog dialog;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        dialog = new ProgressDialog(this);
        dialog.setTitle("Loading");
        dialog.setMessage("Please wait.");
        dialog.show();
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = mAuth.getCurrentUser();

        if (!AppUtils.isNetworkAvailable(this)) {
            startActivity(new Intent(this, NoInternetConnection.class));
            if (dialog.isShowing())
                dialog.dismiss();
        } else if (currentUser == null || currentUser.getUid().length()<=0){
            startActivity(new Intent(this, LoginActivity.class));
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