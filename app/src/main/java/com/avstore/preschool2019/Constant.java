package com.avstore.preschool2019;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;

import com.avstore.education.avpreschoolforkids.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;

//import static com.example.preschool2019.ViewPagerAdapter.mediaPlayer;

//import static com.example.preschool2019.ViewPagerAdapter.mediaPlayer;

public class Constant {


   public static MediaPlayer mediaPlayer;

   public  static String Titel[]=new String[]{"Alphabets A to Z","Rhymes","Numbers 1 to 100","Days of the week","Months of the year","Type of Colours","Human Body Parts","Organs & Other things","Ways to be healthy","Know the Fruits","Know the Flowers","Know the Vegetables","Know the Birds","Know the Animal","Know the Sea Animal","know the Vehicles","People Who Help us","Continent","Know the Countries"};
    public static int MenuImages[]=new int[]{R.drawable.abc,R.drawable.rhayms,R.drawable.number,R.drawable.calender,R.drawable.week,R.drawable.color,R.drawable.human_body,R.drawable.organs,R.drawable.take_bath_daily,R.drawable.know_the_fruits,R.drawable.know_the_flowers,R.drawable.veg,R.drawable.know_the_birds,R.drawable.anim,R.drawable.know_the_sea_animals1,R.drawable.know_the_vehicle,R.drawable.postman,R.drawable.continents18,R.drawable.know_the_countries};

    public static String abcd[]=new String[]{"Start t","a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","Finish"};
   public  static String ABCD[]=new String[]{"Start","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z","TNX"};

   public  static int Human[]=new int[]{R.drawable.humanbody,R.drawable.gk_human_body_a,R.drawable.body1,R.drawable.body2,R.drawable.body3,R.drawable.body5,R.drawable.body4,R.drawable.finish1};
   public static String HumanSound[]=new String[]{"start.mp3","bodyparts_one.mp3","bodyparts_two.mp3","bodyparts_three.mp3","bodyparts_four.mp3","bodyparts_five.mp3","bodyparts_six.mp3","start.mp3"};

   public static String abc[]=new String[]{"start.mp3","a.mp3","b.mp3","c.mp3","d.mp3","e.mp3","f.mp3","g.mp3","h.mp3","i.mp3","j.mp3","k.mp3","l.mp3","m.mp3","n.mp3","o.mp3","p.mp3","q.mp3","r.mp3","s.mp3","t.mp3","u.mp3","v.mp3","w.mp3","x.mp3","y.mp3","z.mp3","start.mp3"};

   public  static  int a[]=new int[]{R.drawable.az,R.drawable.a1,R.drawable.b1,R.drawable.c1,R.drawable.d1,R.drawable.e1,R.drawable.f1,R.drawable.g1,R.drawable.h1,R.drawable.i1,R.drawable.j2,R.drawable.k1,R.drawable.l1,R.drawable.m1,R.drawable.n2,R.drawable.o2,R.drawable.p2,R.drawable.q1,R.drawable.r2,R.drawable.s2,R.drawable.t2,R.drawable.u1,R.drawable.v1,R.drawable.w1,R.drawable.x1,R.drawable.y1,R.drawable.z1,R.drawable.a2,};

   public  static  int one[]=new int[]{R.drawable.otoh,R.drawable.ten,R.drawable.twenty,R.drawable.thirty,R.drawable.fourty,R.drawable.fifty,R.drawable.sixty,R.drawable.sevanty,R.drawable.eighty,R.drawable.nighty,R.drawable.hundred,R.drawable.finish1};

   public static String OneToHun[]=new String[]{"start.mp3","mathone.mp3","mathtwo.mp3","maththree.mp3","mathfour.mp3","mathfive.mp3","mathsix.mp3","mathseven.mp3","matheight.mp3","mathnine.mp3","mathten.mp3","start.mp3"};

   public static String colorName[]=new String[]{"White","Gray","Yellow","Green","Turquoise","Blue"};
   public static String colorName2[]=new String[]{"Orange","Pink","Purple","red","Brown","Black"};
   public static String colorMusic[]=new String[]{"color_one.mp3","color_two.mp3"};

   public static int colorImage[]=new int[]{R.drawable.white,R.drawable.gray,R.drawable.yellow_color,R.drawable.green_color,R.drawable.turquoise,R.drawable.blue_color};
   public static int colorImage2[]=new int[]{R.drawable.orange,R.drawable.pink,R.drawable.purple,R.drawable.red_color,R.drawable.brown,R.drawable.black_color};


   public static String CountriesMusic[]=new String[]{"countryone.mp3","countrytwo.mp3"};

   public static String WayHelathMusic[]=new String[]{"waystostayhealthy1.mp3","waystostayhealthy2.mp3","waystostayhealthy.mp3"};

   public static String OrganSenceMusic[]=new String[]{"organs.mp3","sense_organ.mp3"};

   public static String FruitsMusic[]=new String[]{"fruits_1.mp3","fruits_2.mp3","fruits_3.mp3"};

   public static String FlowerMusic[]=new String[]{"flower_two.mp3","flower_first.mp3"};

   public static String VagetablesMusic[]=new String[]{"vegetables_one.mp3","vegetables_two.mp3","vegetables_three.mp3","vegetables_four.mp3"};

   public static String BirdsMusic[]=new String[]{"birds_second.mp3","birds_first.mp3"};

   public static String AnimalMusic[]=new String[]{"wild_animals.mp3","domestic_animal.mp3","farm_and_poultry_animals.mp3","pet_animals.mp3"};

   public static String AnimalToolName[]=new String[]{"Wild Animal","Domenstic Animal","Farm Animals","Pet Animals"};

   public static String SeaAnimalMusic[]=new String[]{"sea_animals_one.mp3","sea_animals_two.mp3"};

   public static String VehiclesMusic[]=new String[]{"vehicles_one.mp3","vehicles_two.mp3","special_vehicles.mp3","vehicle_drawn_by_animals.mp3"};

   public static String VehiclesToolName[]=new String[]{"know the Vehicles","know the Vehicles","Special Vehicles","Drawn by Animals"};

   public static String PeopleMusic[]=new String[]{"people_who_helps_first.mp3","people_who_helps_second.mp3"};

   public static int RhymesImages[]=new int[]{};
   public static String RhymesTitle[]=new String[]{"Baa,Baa, Black\n Sheep","Twinkle Little \nStar","Bits of \n papers","Humpty Dumpty \nSat on Wall","Jack and \n jill","Rain Rain \n Go Away","Chubby Cheeks \n Dimple Chin","Johny Johny\n Yes Papa","One Two Buckle \n My Shoe","I'm a little\n  Teapot","Elly The\n Elephant","Ding Dong\n Bell"};

   public static String PoemSound[]=new String[]{"baabaa_black_sheep.mp3","twinkletwinkle_littlestar.mp3","bits_of_pepars.mp3","humpty_dumpty.mp3","jack_and_jill.mp3","rainrain_goaway.mp3","chubby_chick.mp3","johnyjohny_yespapa_poem.mp3","buckle_my_shoe.mp3","imlittle_tea_pot.mp3","elle_the_elephant.mp3", "ding_dong_bell.mp3"};

   public static int Poemicon[]=new int[]{R.drawable.baabaa_blacksheep_index,R.drawable.twinkletwinkle_index,R.drawable.bitsofpapers_index,R.drawable.humptydumpty_index,R.drawable.jackandjill_index,R.drawable.rainraingoaway_index,R.drawable.chubbycheeksdimplechin_index,R.drawable.johnyjohnyyespapa_index,R.drawable.onetwobucklemyshoe_index,R.drawable.iamlittleteapot_index,R.drawable.ellytheelephant_index,R.drawable.dingdongbell_index};
   public static int PoemImages[]=new int[]{R.drawable.baa_baa_blacksheep,R.drawable.twinkletwinkle,R.drawable.r3,R.drawable.humptydumpty,R.drawable.jacknjill,R.drawable.r6,R.drawable.r7,R.drawable.r8,R.drawable.onetwobucklemyshoe,R.drawable.iamlittleteapot,R.drawable.r11,R.drawable.r12};

   public static void playAssetSound(Context context, String soundFileName) {
      try {

         mediaPlayer = new MediaPlayer();
         AssetFileDescriptor descriptor = context.getAssets().openFd(soundFileName);
         mediaPlayer.setDataSource(descriptor.getFileDescriptor(), descriptor.getStartOffset(), descriptor.getLength());
         descriptor.close();

         mediaPlayer.prepare();
         mediaPlayer.setVolume(1f, 1f);
         mediaPlayer.setLooping(false);
         mediaPlayer.start();
      } catch (Exception e) {
         e.printStackTrace();
      }
   }

   public static void BANNERADD(Activity activity, int id){

      AdView adView = new AdView(activity);
      adView.setAdSize(AdSize.SMART_BANNER);
      adView.setAdUnitId(String.valueOf(id));

      adView =activity.findViewById(R.id.adView);
      AdRequest adRequest = new AdRequest.Builder().build();
      adView.loadAd(adRequest);

   }


}

