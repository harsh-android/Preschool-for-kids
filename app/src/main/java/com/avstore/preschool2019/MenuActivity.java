package com.avstore.preschool2019;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.avstore.education.avpreschoolforkids.R;
import com.bumptech.glide.Glide;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import static com.avstore.preschool2019.Constant.mediaPlayer;


public class MenuActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private RecyclerView menuRecyclerview;
    public static int position;

    public TextView toolbarTextviewMenu;
    private ImageView backImageview;
    private Toolbar toolbar;

    // InterstitialAd CODE
    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        // InterstitialAd CODE
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(String.valueOf(R.string.AD_Interstitial));
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                // Load the next interstitial.

                Intent intent = new Intent(MenuActivity.this, SecondActivity.class);
                startActivity(intent);
                mInterstitialAd.loadAd(new AdRequest.Builder().build());
            }

        });

        toolbarTextviewMenu = (TextView) findViewById(R.id.toolbarTextviewMenu);
        toolbarTextviewMenu.setText("Menu");

        //Navigation CODE

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer_layout = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(MenuActivity.this, drawer_layout, toolbar, R.string.open, R.string.close);
        drawer_layout.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        menuRecyclerview = (RecyclerView) findViewById(R.id.menuRecyclerview);
        MenuAdapter1 menuAdapter = new MenuAdapter1(MenuActivity.this);
        RecyclerView.LayoutManager menuManager = new GridLayoutManager(MenuActivity.this, 2, GridLayoutManager.VERTICAL, false);
        menuRecyclerview.setLayoutManager(menuManager);
        menuRecyclerview.setAdapter(menuAdapter);

        if (mediaPlayer != null && mediaPlayer.isPlaying()) {

            Toast.makeText(this, "SONGGG", Toast.LENGTH_SHORT).show();
            Constant.mediaPlayer.stop();
        }

    }

    //MenuADAPTER CODE......

    private class MenuAdapter1 extends RecyclerView.Adapter<ViewHolder> {

        public MenuAdapter1(MenuActivity menuActivity) {

        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

            View view = getLayoutInflater().inflate(R.layout.menu_item, viewGroup, false);

            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {

            viewHolder.menuTextview.setText(Constant.Titel[i]);

            Glide.with(MenuActivity.this).load(Constant.MenuImages[i]).into(viewHolder.menuImageview);

            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    position = i;

                    if (mInterstitialAd.isLoaded()) {
                        mInterstitialAd.show();
                    } else {
                        Intent intent = new Intent(MenuActivity.this, SecondActivity.class);
                        startActivity(intent);
                    }


//                    Intent intent = new Intent(MenuActivity.this, SecondActivity.class);
//                    startActivity(intent);

                }
            });
        }

        @Override
        public int getItemCount() {
            return Constant.Titel.length;
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView menuImageview;
        private final TextView menuTextview;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            menuImageview = (ImageView) itemView.findViewById(R.id.menuImageview);
            menuTextview = (TextView) itemView.findViewById(R.id.menuTextview);

        }
    }


    //Navigation SELECTED CODE
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {

            case R.id.Dashboard:
                break;

            case R.id.AboutUs:
                Intent intent = new Intent(MenuActivity.this, AboutUsActivity.class);
                startActivity(intent);
                break;

            case R.id.ShareApp:

                Intent s = new Intent(android.content.Intent.ACTION_SEND);
                s.setType("text/plain");
                s.putExtra(android.content.Intent.EXTRA_TEXT, "http://play.google.com/store/apps/details?id=" + MenuActivity.this.getPackageName());
                startActivity(Intent.createChooser(s, "Share App"));

                break;

            case R.id.RateApp:

                Uri uri = Uri.parse("market://details?id=" + MenuActivity.this.getPackageName());
                Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
                // To count with Play market backstack, After pressing back button,
                // to taken back to our application, we need to add following flags to intent.
                goToMarket.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY |
                        Intent.FLAG_ACTIVITY_NEW_DOCUMENT |
                        Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
                try {
                    startActivity(goToMarket);
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://play.google.com/store/apps/details?id=" + MenuActivity.this.getPackageName())));
                }

                break;

            case R.id.MoreApp:


                try {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://search?q=pub:AV Store")));
                } catch (android.content.ActivityNotFoundException anfe) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://play.google.com/store/apps/developer?id=AV Store")));
                }

                break;


        }

        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;

    }

}
