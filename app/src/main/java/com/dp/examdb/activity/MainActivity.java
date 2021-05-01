package com.dp.examdb.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;

import com.dp.examdb.R;
import com.dp.examdb.Utils.AppUtils;
import com.dp.examdb.service.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ArrayList<String> titles;
    private ArrayList<String> links;
    private MediaPlayer mediaPlayer;
    private String[] urls = {"https://mastermind-classes-education-center.business.site/?utm_source=gmb&utm_medium=referral",
            "https://www.google.com/maps/place/MASTERMIND+CLASSES+BAREILLY/@28.3797218,79.4080234,15z/data=!4m12!1m6!3m5!1s0x0:0x9a10b87fa215fb52!2sMASTERMIND+CLASSES+BAREILLY!8m2!3d28.3797461!4d79.408043!3m4!1s0x0:0x9a10b87fa215fb52!8m2!3d28.3797461!4d79.408043",
            "https://www.facebook.com/Mastermind-Classes-Bareilly-106976211191636",
            "https://play.google.com/store/apps/details?id=dp.ibps.generalawareness&hl=en&gl=US",
            "https://www.youtube.com/channel/UCj5Sp5oRNyQUbSIjppIp0Sg",
            "https://www.indiamart.com/mastermind-classes/",
            "https://www.olx.in/en/item/mastermind-classes-bareilly-iid-1617573604",
            "https://www.google.com/search?q=mastermind+classes+bareilly&oq=mastermind+classes+bareilly&aqs=chrome.0.69i59j69i57j69i59j69i60l4.1608j0j4&sourceid=chrome&ie=UTF-8"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mediaPlayer = MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI);
        new firstDoIt().execute();
//        startService(new Intent(MainActivity.this, service.class));

        //        Calendar calendar = Calendar.getInstance();
//
//        // TODO: 22-04-2021
//        calendar.set(calendar.get(Calendar.YEAR),
//                calendar.get(Calendar.MONTH),
//                calendar.get(Calendar.DAY_OF_MONTH),
//                17, 05, 0);

        //   setAlarm(calendar.getTimeInMillis());

    }

//    private void setAlarm(long timeInMillis) {
//        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
//        Intent intent = new Intent(this, AlarmReceiver.class);
//        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, intent, 0);
//        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, timeInMillis, AlarmManager.INTERVAL_DAY, pendingIntent);
//        Toast.makeText(this, "Alarm is Set now.", Toast.LENGTH_SHORT).show();
//
//    }

//    public InputStream getInputStream(URL url) {
//        try {
//            return url.openConnection().getInputStream();
//        } catch (IOException ioException) {
//            return null;
//        }
//    }

    public class firstDoIt extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... voids) {

            for (int i = 1; i > 0; i++) {
                try {
                    Document document = Jsoup.connect(urls[AppUtils.getRandomNumber(0, urls.length - 1)]).get();
                    Document document2 = Jsoup.parse(urls[AppUtils.getRandomNumber(0, urls.length - 1)], "6000");
                    Log.d("TAG", "doInBackground: 0" + urls[AppUtils.getRandomNumber(0, urls.length - 1)]);
//                    Elements partOfSpeech = document.select("div");
//                    Elements sentenceUse = document.select("div.fw3eif");

//                    Log.d("TAG", "Val : "+words[i]+" "+ partOfSpeech.text() + " " + sentenceUse.text());
                } catch (Exception ioException) {
                    notifyAlarm();
                    Log.d("TAG", "Val : Exception : " + ioException.getMessage());
                }
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }


    }


    //    public class ProcessInBackground extends AsyncTask<Integer, Void, Integer>{
//        ProgressDialog dialog = new ProgressDialog(MainActivity.this);
//        Exception exception = null;
//        @Override
//        protected void onPreExecute() {
//            super.onPreExecute();
//            dialog.setMessage("Busy Loading rss Feed... Please wait");
//            dialog.show();
//        }
//
//        @Override
//        protected Integer doInBackground(Integer... integers) {
//            // TODO: 25-04-2021 test with String... with all RSS Urls parsing set a loop
//            // TODO: 25-04-2021 on String array size to fetch all urls data.
//            try{
//                URL url = new URL("https://newsonair.gov.in/NSD_Audio_rss.aspx");
//                XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
//                factory.setNamespaceAware(false);
//                XmlPullParser xpp = factory.newPullParser();
//                xpp.setInput(getInputStream(url),"UTF_8");
//                boolean  insideItem = false;
//                int eventType = xpp.getEventType();
//                while(eventType != XmlPullParser.END_DOCUMENT){
//                    if (eventType == XmlPullParser.START_TAG){
//                        if (xpp.getName().equalsIgnoreCase("item")){
//                            insideItem = true;
//
//                        } else if (xpp.getName().equalsIgnoreCase("title")){
//                            if (insideItem){
//
//                            }
//                        }
//
//                    }
//                }
//
//            }catch (MalformedURLException e){
//                exception = e;
//            } catch (XmlPullParserException e){
//                exception = e;
//            } catch (IOException e){
//                exception = e;
//            }
//
//            return null;
//        }
//
//        @Override
//        protected void onPostExecute(Integer integer) {
//            super.onPostExecute(integer);
//            dialog.dismiss();
//        }
//    }

    public void notifyAlarm() {
        if (!mediaPlayer.isPlaying()) {
            mediaPlayer.start();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}