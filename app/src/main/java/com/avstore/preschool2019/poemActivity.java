package com.avstore.preschool2019;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.avstore.education.avpreschoolforkids.R;
import com.bumptech.glide.Glide;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdListener;
import com.facebook.ads.InterstitialAdListener;

public class poemActivity extends AppCompatActivity {

    private Button playbutton, pausebutton, privesbutton, nextbutton;
    private Object position;
    private ImageView poemImages;

    //Facebook ADS
    private com.facebook.ads.InterstitialAd mFBInterstitialAd;
    private RelativeLayout facebookad;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poem);

        //Facebook ADDD
        facebookad = findViewById(R.id.facebokad);
        mFBInterstitialAd = AdsConnection.getFacebookInstance(this).createFacebookInterstitialAD(this);


        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        playbutton = (Button) findViewById(R.id.playbutton);
        pausebutton = (Button) findViewById(R.id.pausebutton);
        privesbutton = (Button) findViewById(R.id.privesbutton);
        nextbutton = (Button) findViewById(R.id.nextbutton);
        poemImages = (ImageView) findViewById(R.id.poemImages);

        pausebutton.setVisibility(View.VISIBLE);

        Glide.with(poemActivity.this).load(Constant.PoemImages[RhymesActivity.position]).into(poemImages);
        Constant.playAssetSound(poemActivity.this, Constant.PoemSound[RhymesActivity.position]);

//        Constant.mediaPlayer= MediaPlayer.create(poemActivity.this,Constant.P[RhymesActivity.position]);
//        animalName.setText(AniName[RhymesActivity.position]);

        playbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (pausebutton.getVisibility() == View.GONE) {
                    pausebutton.setVisibility(View.VISIBLE);
                    playbutton.setVisibility(View.GONE);

                } else {

                }

                if (Constant.mediaPlayer.isPlaying() == false) {


                    Constant.mediaPlayer.seekTo((Integer) position);
                    Constant.mediaPlayer.start();
                    Constant.mediaPlayer.setLooping(true);

                }


            }
        });


        pausebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (playbutton.getVisibility() == View.GONE) {
                    playbutton.setVisibility(View.VISIBLE);
                    pausebutton.setVisibility(View.GONE);
                }
                Constant.mediaPlayer.pause();
                position = 0;
                Constant.mediaPlayer.seekTo(0);


            }
        });

        nextbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                playbutton.setVisibility(View.GONE);
                pausebutton.setVisibility(View.VISIBLE);

                if (RhymesActivity.position < 11) {
                    Constant.mediaPlayer.stop();
                    RhymesActivity.position = RhymesActivity.position + 1;


                    //Facebook ADD
                    AdsConnection.getFacebookInstance(poemActivity.this).setFacebokInterstitialAD(mFBInterstitialAd, new InterstitialAdListener() {
                        public void onInterstitialDisplayed(Ad p0) {
                        }

                        public void onAdClicked(Ad p0) {
                        }

                        public void onInterstitialDismissed(Ad p0) {

                            Glide.with(poemActivity.this).load(Constant.PoemImages[RhymesActivity.position]).into(poemImages);
                            Constant.playAssetSound(poemActivity.this, Constant.PoemSound[RhymesActivity.position]);
                        }

                        public void onError(Ad p0, AdError p1) {
                        }

                        public void onAdLoaded(Ad p0) {
                        }

                        public void onLoggingImpression(Ad p0) {
                        }
                    });

                    if (RhymesActivity.position % 4 == 0) {

                        if (mFBInterstitialAd != null && mFBInterstitialAd.isAdLoaded()) {
                            mFBInterstitialAd.show();
                            mFBInterstitialAd = AdsConnection.getFacebookInstance(poemActivity.this).createFacebookInterstitialAD(poemActivity.this);
                        } else {
                            Glide.with(poemActivity.this).load(Constant.PoemImages[RhymesActivity.position]).into(poemImages);
                            Constant.playAssetSound(poemActivity.this, Constant.PoemSound[RhymesActivity.position]);

                        }
                    } else {

                        Glide.with(poemActivity.this).load(Constant.PoemImages[RhymesActivity.position]).into(poemImages);
                        Constant.playAssetSound(poemActivity.this, Constant.PoemSound[RhymesActivity.position]);
                    }


                }


            }
        });

        privesbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                playbutton.setVisibility(View.GONE);
                pausebutton.setVisibility(View.VISIBLE);

//                if (RhymesActivity.position % 3 == 0) {
//                    if (mFBInterstitialAd != null && mFBInterstitialAd.isAdLoaded()) {
//                        mFBInterstitialAd.show();
//                        mFBInterstitialAd = AdsConnection.getFacebookInstance(poemActivity.this).createFacebookInterstitialAD(poemActivity.this);
//
//                    }
//                }

                if (RhymesActivity.position > 0) {

                    Constant.mediaPlayer.stop();
                    RhymesActivity.position = RhymesActivity.position - 1;

                    //Facebook ADD
                    AdsConnection.getFacebookInstance(poemActivity.this).setFacebokInterstitialAD(mFBInterstitialAd, new InterstitialAdListener() {
                        public void onInterstitialDisplayed(Ad p0) {
                        }

                        public void onAdClicked(Ad p0) {
                        }

                        public void onInterstitialDismissed(Ad p0) {

                            Glide.with(poemActivity.this).load(Constant.PoemImages[RhymesActivity.position]).into(poemImages);
                            Constant.playAssetSound(poemActivity.this, Constant.PoemSound[RhymesActivity.position]);
                        }

                        public void onError(Ad p0, AdError p1) {

                            Intent intent = new Intent(poemActivity.this, SecondActivity.class);
                            startActivity(intent);
                        }

                        public void onAdLoaded(Ad p0) {
                        }

                        public void onLoggingImpression(Ad p0) {
                        }
                    });

                    if (RhymesActivity.position % 4 == 0) {
                        if (mFBInterstitialAd != null && mFBInterstitialAd.isAdLoaded()) {
                            mFBInterstitialAd.show();
                            mFBInterstitialAd = AdsConnection.getFacebookInstance(poemActivity.this).createFacebookInterstitialAD(poemActivity.this);

                        } else {

                            Glide.with(poemActivity.this).load(Constant.PoemImages[RhymesActivity.position]).into(poemImages);
                            Constant.playAssetSound(poemActivity.this, Constant.PoemSound[RhymesActivity.position]);
                        }
                    } else {
                        Glide.with(poemActivity.this).load(Constant.PoemImages[RhymesActivity.position]).into(poemImages);
                        Constant.playAssetSound(poemActivity.this, Constant.PoemSound[RhymesActivity.position]);
                    }


//                    if (mFBInterstitialAd != null && mFBInterstitialAd.isAdLoaded()) {
//                        mFBInterstitialAd.show();
//                        mFBInterstitialAd = AdsConnection.getFacebookInstance(poemActivity.this).createFacebookInterstitialAD(StartActivity.this);
//
//                    } else {
//                        Glide.with(poemActivity.this).load(Constant.PoemImages[RhymesActivity.position]).into(poemImages);
//                        Constant.playAssetSound(poemActivity.this, Constant.PoemSound[RhymesActivity.position]);
//                    }


                }

            }
        });

    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Constant.mediaPlayer.stop();
        position = 0;
        Constant.mediaPlayer.seekTo(0);
    }

    protected void onStop() {
        super.onStop();
        Constant.mediaPlayer.stop();
        // insert here your instructions
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
