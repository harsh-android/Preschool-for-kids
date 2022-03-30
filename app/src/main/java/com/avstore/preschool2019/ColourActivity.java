package com.avstore.preschool2019;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.avstore.education.avpreschoolforkids.R;
import com.avstore.preschool2019.Fragment.Animal1Fragment;
import com.avstore.preschool2019.Fragment.Animal2Fragment;
import com.avstore.preschool2019.Fragment.Animal3Fragment;
import com.avstore.preschool2019.Fragment.Animal4Fragment;
import com.avstore.preschool2019.Fragment.Birds1Fragment;
import com.avstore.preschool2019.Fragment.Birds2Fragment;
import com.avstore.preschool2019.Fragment.Countries1Fragment;
import com.avstore.preschool2019.Fragment.Countries2Fragment;
import com.avstore.preschool2019.Fragment.FirstFragment;
import com.avstore.preschool2019.Fragment.Flowers1Fragment;
import com.avstore.preschool2019.Fragment.Flowers2Fragment;
import com.avstore.preschool2019.Fragment.Fruits1Fragment;
import com.avstore.preschool2019.Fragment.Fruits2Fragment;
import com.avstore.preschool2019.Fragment.Fruits3Fragment;
import com.avstore.preschool2019.Fragment.Healthy2Fragment;
import com.avstore.preschool2019.Fragment.Healthy3Fragment;
import com.avstore.preschool2019.Fragment.OrgansFragment;
import com.avstore.preschool2019.Fragment.People1Fragment;
import com.avstore.preschool2019.Fragment.People2Fragment;
import com.avstore.preschool2019.Fragment.SeaAnimal2Fragment;
import com.avstore.preschool2019.Fragment.SeaAnimalFragment;
import com.avstore.preschool2019.Fragment.SenceOrgansFragment;
import com.avstore.preschool2019.Fragment.Vagetables1Fragment;
import com.avstore.preschool2019.Fragment.Vagetables2Fragment;
import com.avstore.preschool2019.Fragment.Vagetables3Fragment;
import com.avstore.preschool2019.Fragment.Vagetables4Fragment;
import com.avstore.preschool2019.Fragment.Vehicles1Fragment;
import com.avstore.preschool2019.Fragment.Vehicles2Fragment;
import com.avstore.preschool2019.Fragment.Vehicles3Fragment;
import com.avstore.preschool2019.Fragment.Vehicles4Fragment;
import com.avstore.preschool2019.Fragment.WayHealthyFragment;
import com.avstore.preschool2019.Fragment.colorFragment2;

import static com.avstore.preschool2019.Constant.BANNERADD;
import static com.avstore.preschool2019.Constant.mediaPlayer;

public class ColourActivity extends AppCompatActivity {

    FragmentPagerAdapter adapterViewPager;
    private Button nextButton, previusButton;
    public static ViewPager vpPager;
    public static TextView toolbarTextviewColour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colour);

        //BANNER ADMOB ADS
//        String id="ca-app-pub-3940256099942544/6300978111";
        int id = R.string.AD_banner3;
        BANNERADD(ColourActivity.this, id);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        nextButton = (Button) findViewById(R.id.nextButton);
        previusButton = (Button) findViewById(R.id.previusButton);

        toolbarTextviewColour = (TextView) findViewById(R.id.toolbarTextviewColour);

        ImageView backImageview = (ImageView) findViewById(R.id.backImageview);

        backImageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();

            }
        });

        vpPager = (ViewPager) findViewById(R.id.vpPager);
        adapterViewPager = new MyPagerAdapter(getSupportFragmentManager());
        vpPager.setAdapter(adapterViewPager);

        vpPager.setOnPageChangeListener(player);

        previusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int p = vpPager.getCurrentItem();

                if (p != 0) {

                    int pos = p - 1;
                    vpPager.setCurrentItem(pos);

                }
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (MenuActivity.position == 5 || MenuActivity.position == 7 || MenuActivity.position == 10 || MenuActivity.position == 12 || MenuActivity.position == 14 || MenuActivity.position == 16 || MenuActivity.position == 18) {

                    int p = vpPager.getCurrentItem();

                    if (p != 1) {

                        int pos = p + 1;
                        vpPager.setCurrentItem(pos);

                    }
                }

                if (MenuActivity.position == 8 || MenuActivity.position == 9) {

                    int p = vpPager.getCurrentItem();

                    if (p != 2) {

                        int pos = p + 1;
                        vpPager.setCurrentItem(pos);

                    }
                }
                if (MenuActivity.position == 11 || MenuActivity.position == 13 || MenuActivity.position == 15) {

                    int p = vpPager.getCurrentItem();

                    if (p != 3) {

                        int pos = p + 1;
                        vpPager.setCurrentItem(pos);

                    }
                }


            }
        });


    }

    public class MyPagerAdapter extends FragmentPagerAdapter {

        public int NUM_ITEMS = 2;


        public MyPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }


        @Override
        public int getCount() {

            if (MenuActivity.position == 5 || MenuActivity.position == 7 || MenuActivity.position == 10 || MenuActivity.position == 12 || MenuActivity.position == 14 || MenuActivity.position == 16 || MenuActivity.position == 18) {
                NUM_ITEMS = 2;
            }
            if (MenuActivity.position == 8 || MenuActivity.position == 9) {
                NUM_ITEMS = 3;
            }
            if (MenuActivity.position == 11 || MenuActivity.position == 13 || MenuActivity.position == 15) {
                NUM_ITEMS = 4;
            }


            return NUM_ITEMS;
        }


        @Override
        public Fragment getItem(int position) {

            if (MenuActivity.position == 5) {
                switch (position) {
                    case 0:
                        Constant.playAssetSound(ColourActivity.this, Constant.colorMusic[0]);
                        return FirstFragment.newInstance(0, "Page # 1");

                    case 1:
//
                        return colorFragment2.newInstance(1, "Page # 2");

                    default:
                        return null;
                }
            }

            if (MenuActivity.position == 7) {
                switch (position) {
                    case 0:
                        Constant.playAssetSound(ColourActivity.this, Constant.OrganSenceMusic[0]);
                        return OrgansFragment.newInstance(0, "Page # 1");

                    case 1:
//
                        return SenceOrgansFragment.newInstance(1, "Page # 2");

                    default:
                        return null;
                }
            }

            if (MenuActivity.position == 8) {
                switch (position) {
                    case 0:
                        Constant.playAssetSound(ColourActivity.this, Constant.WayHelathMusic[0]);
                        return WayHealthyFragment.newInstance(0, "Page # 1");

                    case 1:
//
                        return Healthy2Fragment.newInstance(1, "Page # 2");
                    case 2:
//
                        return Healthy3Fragment.newInstance(2, "Page # 3");

                    default:
                        return null;
                }
            }

            if (MenuActivity.position == 9) {
                switch (position) {
                    case 0:
                        Constant.playAssetSound(ColourActivity.this, Constant.FruitsMusic[0]);
                        return Fruits1Fragment.newInstance(0, "Page # 1");

                    case 1:
//
                        return Fruits2Fragment.newInstance(1, "Page # 2");
                    case 2:
//
                        return Fruits3Fragment.newInstance(2, "Page # 3");

                    default:
                        return null;
                }
            }

            if (MenuActivity.position == 10) {
                switch (position) {
                    case 0:
                        Constant.playAssetSound(ColourActivity.this, Constant.FlowerMusic[0]);
                        return Flowers1Fragment.newInstance(0, "Page # 1");

                    case 1:
//
                        return Flowers2Fragment.newInstance(1, "Page # 2");

                    default:
                        return null;
                }
            }

            if (MenuActivity.position == 11) {
                switch (position) {
                    case 0:
                        Constant.playAssetSound(ColourActivity.this, Constant.VagetablesMusic[0]);
                        return Vagetables1Fragment.newInstance(0, "Page # 1");

                    case 1:
//
                        return Vagetables2Fragment.newInstance(1, "Page # 2");
                    case 2:
//
                        return Vagetables3Fragment.newInstance(2, "Page # 3");
                    case 3:
//
                        return Vagetables4Fragment.newInstance(3, "Page # 4");

                    default:
                        return null;
                }
            }

            if (MenuActivity.position == 12) {
                switch (position) {
                    case 0:
                        Constant.playAssetSound(ColourActivity.this, Constant.BirdsMusic[0]);
                        return Birds1Fragment.newInstance(0, "Page # 1");

                    case 1:
//
                        return Birds2Fragment.newInstance(1, "Page # 2");

                    default:
                        return null;
                }
            }

            if (MenuActivity.position == 13) {
                switch (position) {
                    case 0:
                        toolbarTextviewColour.setText(Constant.AnimalToolName[0]);
                        Constant.playAssetSound(ColourActivity.this, Constant.AnimalMusic[0]);
                        return Animal1Fragment.newInstance(0, "Page # 1");

                    case 1:

                        return Animal2Fragment.newInstance(1, "Page # 2");
                    case 2:


                        return Animal3Fragment.newInstance(2, "Page # 3");
                    case 3:


                        return Animal4Fragment.newInstance(3, "Page # 4");

                    default:
                        return null;
                }
            }

            if (MenuActivity.position == 14) {
                switch (position) {
                    case 0:
                        Constant.playAssetSound(ColourActivity.this, Constant.SeaAnimalMusic[0]);
                        return SeaAnimalFragment.newInstance(0, "Page # 1");

                    case 1:
//
                        return SeaAnimal2Fragment.newInstance(1, "Page # 2");

                    default:
                        return null;
                }
            }

            if (MenuActivity.position == 15) {
                switch (position) {
                    case 0:
                        toolbarTextviewColour.setText(Constant.VehiclesToolName[0]);
                        Constant.playAssetSound(ColourActivity.this, Constant.VehiclesMusic[0]);
                        return Vehicles1Fragment.newInstance(0, "Page # 1");

                    case 1:
//
                        return Vehicles2Fragment.newInstance(1, "Page # 2");
                    case 2:
//
                        return Vehicles3Fragment.newInstance(2, "Page # 3");
                    case 3:
//
                        return Vehicles4Fragment.newInstance(3, "Page # 4");

                    default:
                        return null;
                }
            }

            if (MenuActivity.position == 16) {
                switch (position) {
                    case 0:
                        Constant.playAssetSound(ColourActivity.this, Constant.PeopleMusic[0]);
                        return People1Fragment.newInstance(0, "Page # 1");

                    case 1:
//
                        return People2Fragment.newInstance(1, "Page # 2");

                    default:
                        return null;
                }
            }

            if (MenuActivity.position == 18) {
                switch (position) {
                    case 0:
                        Constant.playAssetSound(ColourActivity.this, Constant.CountriesMusic[0]);
                        return Countries1Fragment.newInstance(0, "Page # 1");

                    case 1:
//
                        return Countries2Fragment.newInstance(1, "Page # 2");

                    default:
                        return null;
                }
            }


            return null;

        }

        // Returns the page title for the top indicator
        @Override
        public CharSequence getPageTitle(int position) {
            return "Page " + position;
        }

    }

    //VIPAGE CHANGE Lister For Sound
    ViewPager.OnPageChangeListener player = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageSelected(int arg0) {

            if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                mediaPlayer.stop();
            }

            switch (MenuActivity.position) {
                case 5:

                    Constant.playAssetSound(ColourActivity.this, Constant.colorMusic[arg0]);
                    break;
                case 7:
//                    toolbarTextviewColour.setText("Organs & Other Things");
                    Constant.playAssetSound(ColourActivity.this, Constant.OrganSenceMusic[arg0]);
                    break;
                case 8:
//                    toolbarTextviewColour.setText("Way To Stay Healthy");
                    Constant.playAssetSound(ColourActivity.this, Constant.WayHelathMusic[arg0]);
                    break;
                case 9:
//                    toolbarTextviewColour.setText("Type Of Fruits");
                    Constant.playAssetSound(ColourActivity.this, Constant.FruitsMusic[arg0]);
                    break;
                case 10:
//                    toolbarTextviewColour.setText("Type Of Flowers");
                    Constant.playAssetSound(ColourActivity.this, Constant.FlowerMusic[arg0]);
                    break;
                case 11:
//                    toolbarTextviewColour.setText("Know The Vegetables");
                    Constant.playAssetSound(ColourActivity.this, Constant.VagetablesMusic[arg0]);
                    break;
                case 12:
//                    toolbarTextviewColour.setText("Know The Vegetables");
                    Constant.playAssetSound(ColourActivity.this, Constant.BirdsMusic[arg0]);
                    break;
                case 13:
//
                    toolbarTextviewColour.setText(Constant.AnimalToolName[arg0]);
                    Constant.playAssetSound(ColourActivity.this, Constant.AnimalMusic[arg0]);
                    break;
                case 14:
//                    toolbarTextviewColour.setText("Sea Animal");
                    Constant.playAssetSound(ColourActivity.this, Constant.SeaAnimalMusic[arg0]);
                    break;
                case 15:
                    toolbarTextviewColour.setText(Constant.VehiclesToolName[arg0]);
                    Constant.playAssetSound(ColourActivity.this, Constant.VehiclesMusic[arg0]);
                    break;
                case 16:
//                    toolbarTextviewColour.setText("Who Help Us");
                    Constant.playAssetSound(ColourActivity.this, Constant.PeopleMusic[arg0]);
                    break;
                case 18:
//                    toolbarTextviewColour.setText("Know the Countries");
                    Constant.playAssetSound(ColourActivity.this, Constant.CountriesMusic[arg0]);
                    break;
            }


        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {

        }

        @Override
        public void onPageScrollStateChanged(int arg0) {

        }
    };

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            Constant.mediaPlayer.stop();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            Constant.mediaPlayer.stop();
        }
    }
}
