package com.avstore.preschool2019;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.avstore.education.avpreschoolforkids.R;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;

import static com.avstore.preschool2019.Constant.mediaPlayer;


public class WeekMonthContinentActivity extends AppCompatActivity {

    private LinearLayout ContinentsLinearlayout, weekLinearlayout, monthLinearlayout;
    private TextView toolbarTextviewWeek;
    private ImageView WeekImageview;
    private ImageView january, february, march, april, june, july, august, september, may, october, november, december;

    //Facebook ADS

    private RelativeLayout facebookad;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week_month_continent);

        //Facebook ADDD
        facebookad = findViewById(R.id.facebokad);


        weekLinearlayout = (LinearLayout) findViewById(R.id.weekLinearlayout);
        monthLinearlayout = (LinearLayout) findViewById(R.id.monthLinearlayout);
        ContinentsLinearlayout = (LinearLayout) findViewById(R.id.ContinentsLinearlayout);

        toolbarTextviewWeek = (TextView) findViewById(R.id.toolbarTextviewWeek);

        january = (ImageView) findViewById(R.id.january);
        february = (ImageView) findViewById(R.id.february);
        march = (ImageView) findViewById(R.id.march);
        april = (ImageView) findViewById(R.id.april);
//        may=(ImageView)findViewById(R.id.may);
        june = (ImageView) findViewById(R.id.june);
        july = (ImageView) findViewById(R.id.july);
        august = (ImageView) findViewById(R.id.august);
        september = (ImageView) findViewById(R.id.september);
        october = (ImageView) findViewById(R.id.october);
        november = (ImageView) findViewById(R.id.november);
        december = (ImageView) findViewById(R.id.december);

        WeekImageview = (ImageView) findViewById(R.id.WeekImageview);

        WeekImageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();
                Constant.mediaPlayer.stop();

                if (mediaPlayer != null && mediaPlayer.isPlaying()) {

                    Constant.mediaPlayer.stop();
                }
            }
        });


        switch (MenuActivity.position) {

            case 3:
                toolbarTextviewWeek.setText("Days OF The Week");
                monthLinearlayout.setVisibility(View.GONE);
                ContinentsLinearlayout.setVisibility(View.GONE);
                if (weekLinearlayout.getVisibility() == View.GONE) {
                    Constant.playAssetSound(WeekMonthContinentActivity.this, "first.mp3");
                    weekLinearlayout.setVisibility(View.VISIBLE);

                }

                break;

            case 4:

                toolbarTextviewWeek.setText("Months Of The Year");
                weekLinearlayout.setVisibility(View.GONE);
                ContinentsLinearlayout.setVisibility(View.GONE);
                if (monthLinearlayout.getVisibility() == View.GONE) {
                    Constant.playAssetSound(WeekMonthContinentActivity.this, "second.mp3");
                    monthLinearlayout.setVisibility(View.VISIBLE);

                }
                break;
            case 17:
                toolbarTextviewWeek.setText("Continent");
                weekLinearlayout.setVisibility(View.GONE);
                monthLinearlayout.setVisibility(View.GONE);
                if (ContinentsLinearlayout.getVisibility() == View.GONE) {
                    Constant.playAssetSound(WeekMonthContinentActivity.this, "continents.mp3");
                    ContinentsLinearlayout.setVisibility(View.VISIBLE);
                }
                break;
        }


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        mediaPlayer.stop();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            Constant.mediaPlayer.stop();
        }
    }


    //Faceboopkm ADS CODE Start

    public boolean isConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (cm != null) {
            NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
            return activeNetwork != null && activeNetwork.isAvailable() && activeNetwork.isConnected();
        }
        return false;
    }

    public void onStart() {
        super.onStart();
        try {
            if (isConnected()) {
                loadBannerAd();

            }
        } catch (Exception ignored) {
        }
    }


    private void loadBannerAd() {
        try {
            facebookad.addView(AdsConnection.getFacebookInstance(this).setFacebookBannerAD(this, new com.facebook.ads.AdListener() {
                @Override
                public void onError(Ad ad, AdError adError) {
                }

                @Override
                public void onAdLoaded(Ad ad) {

                }

                @Override
                public void onAdClicked(Ad ad) {

                }

                @Override
                public void onLoggingImpression(Ad ad) {

                }
            }));

        } catch (Exception ignored) {
        }
    }

    //Faceboopkm ADS CODE Finish

}
