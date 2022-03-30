package com.avstore.preschool2019;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.avstore.education.avpreschoolforkids.R;
import com.bumptech.glide.Glide;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.InterstitialAdListener;

import static com.avstore.preschool2019.Constant.BANNERADD;

public class RhymesActivity extends AppCompatActivity {

    private RecyclerView rhymesRecyclerview;
    public static int position;
    private TextView toolbarTextviewRhymes;
    private ImageView backImageviewRhymes;

    //Facebook ADS
    private com.facebook.ads.InterstitialAd mFBInterstitialAd;
//    private RelativeLayout facebookad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rhymes);

        //Facebook ADDD
//        facebookad = findViewById(R.id.facebokad);
        mFBInterstitialAd = AdsConnection.getFacebookInstance(this).createFacebookInterstitialAD(this);


        //BANNER ADMOB ADS
//        String id="ca-app-pub-3940256099942544/6300978111";
        int id=R.string.AD_banner2;
        BANNERADD(RhymesActivity.this,id);

        toolbarTextviewRhymes=(TextView)findViewById(R.id.toolbarTextviewRhymes);
        toolbarTextviewRhymes.setText("Rhymes");
        backImageviewRhymes=(ImageView)findViewById(R.id.backImageviewRhymes);

        backImageviewRhymes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();
            }
        });

        rhymesRecyclerview=(RecyclerView)findViewById(R.id.rhymesRecyclerview);
        RhymesAdapter rhymesAdapter=new RhymesAdapter(RhymesActivity.this);
        RecyclerView.LayoutManager menuManager=new GridLayoutManager(RhymesActivity.this,2,GridLayoutManager.VERTICAL,false);
        rhymesRecyclerview.setLayoutManager(menuManager);
        rhymesRecyclerview.setAdapter(rhymesAdapter);


    }

    //RhymesADAPTER CODE......

    private class RhymesAdapter extends RecyclerView.Adapter<ViewHolder> {

        public RhymesAdapter(RhymesActivity menuActivity) {

        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

            View view=getLayoutInflater().inflate(R.layout.rhymes_item,viewGroup,false);

            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {

//            viewHolder.rhymestextview.setText(Constant.RhymesTitle[i]);

            Glide.with(RhymesActivity.this).load(Constant.Poemicon[i]).into(viewHolder.rhymesImageview);

            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    position=i;

                    //Facebook ADD
                    AdsConnection.getFacebookInstance(RhymesActivity.this).setFacebokInterstitialAD(mFBInterstitialAd, new InterstitialAdListener() {
                        public void onInterstitialDisplayed(Ad p0) {
                        }

                        public void onAdClicked(Ad p0) {
                        }

                        public void onInterstitialDismissed(Ad p0) {

                            Intent intent=new Intent(RhymesActivity.this,poemActivity.class);
                            startActivity(intent);
                        }

                        public void onError(Ad p0, AdError p1) {


                        }

                        public void onAdLoaded(Ad p0) {
                        }

                        public void onLoggingImpression(Ad p0) {
                        }
                    });

                    if (mFBInterstitialAd != null && mFBInterstitialAd.isAdLoaded()) {
                        mFBInterstitialAd.show();
                        mFBInterstitialAd = AdsConnection.getFacebookInstance(RhymesActivity.this).createFacebookInterstitialAD(RhymesActivity.this);

                    } else {
                        Intent intent=new Intent(RhymesActivity.this,poemActivity.class);
                        startActivity(intent);
                    }
//                    Intent intent=new Intent(RhymesActivity.this,poemActivity.class);
//                    startActivity(intent);

                }
            });
        }

        @Override
        public int getItemCount() {
            return Constant.RhymesTitle.length;
        }
    }

    public  class ViewHolder extends RecyclerView.ViewHolder
    {
        private final ImageView rhymesImageview;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            rhymesImageview=(ImageView)itemView.findViewById(R.id.rhymesImageview);


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
//                loadBannerAd();

            }
        } catch (Exception ignored) {
        }
    }


//    private void loadBannerAd() {
//        try {
//            facebookad.addView(AdsConnection.getFacebookInstance(this).setFacebookBannerAD(this, new com.facebook.ads.AdListener() {
//                @Override
//                public void onError(Ad ad, AdError adError) {
//                }
//
//                @Override
//                public void onAdLoaded(Ad ad) {
//
//                }
//
//                @Override
//                public void onAdClicked(Ad ad) {
//
//                }
//
//                @Override
//                public void onLoggingImpression(Ad ad) {
//
//                }
//            }));
//
//        } catch (Exception ignored) {
//        }
//    }

    //Faceboopkm ADS CODE Finish


}
