package com.avstore.preschool2019;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.avstore.education.avpreschoolforkids.R;

import static com.avstore.preschool2019.Constant.BANNERADD;
import static com.avstore.preschool2019.Constant.mediaPlayer;


public class SecondActivity extends AppCompatActivity {

    public static ViewPager mViewPager;
    ViewPagerAdapter viewPagerAdapter;
    private MediaPlayer BG;
    public MediaPlayer mp;
    private Intent intent;
    public static TextView toolbarTextview;
    private ImageView backImageview;
    public static LinearLayout ToolLinearLayout;
    public static Button nextButton,previusButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //BANNER ADMOB ADS
//        String id="ca-app-pub-3940256099942544/6300978111";
        int id=R.string.AD_Banner1;
        BANNERADD(SecondActivity.this,id);

//        AdView adView = new AdView(this);
//        adView.setAdSize(AdSize.SMART_BANNER);
//        adView.setAdUnitId("ca-app-pub-3940256099942544/6300978111");
//
//        adView = findViewById(R.id.adView);
//        AdRequest adRequest = new AdRequest.Builder().build();
//        adView.loadAd(adRequest);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        toolbarTextview = (TextView) findViewById(R.id.toolbarTextview);
        backImageview = (ImageView) findViewById(R.id.backImageview);
        ToolLinearLayout = (LinearLayout) findViewById(R.id.ToolLinearLayout);

//        previusButton=(Button)findViewById(R.id.previusButton);
//        nextButton=(Button)findViewById(R.id.nextButton);

        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(viewPagerAdapter);

        backImageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();

                if (mediaPlayer != null && mediaPlayer.isPlaying()) {

                    Constant.mediaPlayer.stop();
                }

            }
        });


        switch (MenuActivity.position) {
            case 0:
                viewPagerAdapter = new ViewPagerAdapter(SecondActivity.this);
                mViewPager.setAdapter(viewPagerAdapter);
                toolbarTextview.setText("Alphabets A to Z");

                break;
            case 1:

                intent = new Intent(SecondActivity.this, RhymesActivity.class);
                startActivity(intent);
                finish();
                break;


            case 2:
                viewPagerAdapter = new ViewPagerAdapter(SecondActivity.this);
                mViewPager.setAdapter(viewPagerAdapter);
                toolbarTextview.setText("Numbers 1 to 100");
                break;

            case 3:
                intent = new Intent(SecondActivity.this, WeekMonthContinentActivity.class);
                startActivity(intent);
                finish();
                break;

            case 4:
                intent = new Intent(SecondActivity.this, WeekMonthContinentActivity.class);
                startActivity(intent);
                finish();
                break;


            case 5:
                intent = new Intent(SecondActivity.this, ColourActivity.class);
                startActivity(intent);
                finish();
                break;

            case 6:
                viewPagerAdapter = new ViewPagerAdapter(SecondActivity.this);
                mViewPager.setAdapter(viewPagerAdapter);
                toolbarTextview.setText("Human Body Parts");
                break;

            case 7:
                intent = new Intent(SecondActivity.this, ColourActivity.class);
                startActivity(intent);
                finish();
                break;

            case 8:
                intent = new Intent(SecondActivity.this, ColourActivity.class);
                startActivity(intent);
                finish();
                break;

            case 9:
                intent = new Intent(SecondActivity.this, ColourActivity.class);
                startActivity(intent);
                finish();
                break;

            case 10:
                intent = new Intent(SecondActivity.this, ColourActivity.class);
                startActivity(intent);
                finish();
                break;

            case 11:

                intent = new Intent(SecondActivity.this, ColourActivity.class);
                startActivity(intent);
                finish();
                break;

            case 12:
                intent = new Intent(SecondActivity.this, ColourActivity.class);
                startActivity(intent);
                finish();
                break;
            case 13:
                intent = new Intent(SecondActivity.this, ColourActivity.class);
                startActivity(intent);
                finish();
                break;
            case 14:

                intent = new Intent(SecondActivity.this, ColourActivity.class);
                startActivity(intent);
                finish();
                break;

            case 15:

                intent = new Intent(SecondActivity.this, ColourActivity.class);
                startActivity(intent);
                finish();
                break;
            case 16:
                intent = new Intent(SecondActivity.this, ColourActivity.class);
                startActivity(intent);
                finish();
                break;
            case 17:
                intent = new Intent(SecondActivity.this, WeekMonthContinentActivity.class);
                startActivity(intent);
                finish();
                break;
            case 18:
                intent = new Intent(SecondActivity.this, ColourActivity.class);
                startActivity(intent);
                finish();
                break;


        }

    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();

        Constant.mediaPlayer.stop();

        if (mediaPlayer != null && mediaPlayer.isPlaying()) {

            Constant.mediaPlayer.stop();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        mediaPlayer.stop();
    }
}
