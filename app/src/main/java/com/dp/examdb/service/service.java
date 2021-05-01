package com.dp.examdb.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import com.dp.examdb.Utils.AppUtils;
import com.dp.examdb.activity.MainActivity;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class service extends Service {

    String[] urls = {"https://mastermind-classes-education-center.business.site/?utm_source=gmb&utm_medium=referral",
            "https://www.google.com/maps/place/MASTERMIND+CLASSES+BAREILLY/@28.3797218,79.4080234,15z/data=!4m12!1m6!3m5!1s0x0:0x9a10b87fa215fb52!2sMASTERMIND+CLASSES+BAREILLY!8m2!3d28.3797461!4d79.408043!3m4!1s0x0:0x9a10b87fa215fb52!8m2!3d28.3797461!4d79.408043",
            "https://www.facebook.com/Mastermind-Classes-Bareilly-106976211191636",
            "https://play.google.com/store/apps/details?id=dp.ibps.generalawareness&hl=en&gl=US",
            "https://www.youtube.com/channel/UCj5Sp5oRNyQUbSIjppIp0Sg",
            "https://www.indiamart.com/mastermind-classes/",
            "https://www.olx.in/en/item/mastermind-classes-bareilly-iid-1617573604",
            "https://www.google.com/search?q=mastermind+classes+bareilly&oq=mastermind+classes+bareilly&aqs=chrome.0.69i59j69i57j69i59j69i60l4.1608j0j4&sourceid=chrome&ie=UTF-8"};

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "Service started by user.", Toast.LENGTH_LONG).show();

        for (int i = 1; i > 0; i++) {
            try {
                Document document = Jsoup.connect(urls[AppUtils.getRandomNumber(0, urls.length - 1)]).get();
//                Document document2 = Jsoup.parse(urls[AppUtils.getRandomNumber(0, urls.length - 1)],"6000");
                Log.d("TAG", "doInBackground: " + document.html().toString());
//                    Elements partOfSpeech = document.select("div");
//                    Elements sentenceUse = document.select("div.fw3eif");

//                    Log.d("TAG", "Val : "+words[i]+" "+ partOfSpeech.text() + " " + sentenceUse.text());
            } catch (Exception ioException) {
//                notifyAlarm();
                Log.d("TAG", "Val : Exception : " + ioException.getMessage());
            }
        }
        return START_NOT_STICKY;
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
//        startService(new Intent(getApplicationContext(), service.class));
        Toast.makeText(this, "Service destroyed by user.", Toast.LENGTH_LONG).show();
    }
}