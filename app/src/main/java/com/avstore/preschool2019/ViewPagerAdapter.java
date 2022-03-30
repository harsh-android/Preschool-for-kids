package com.avstore.preschool2019;


import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.avstore.education.avpreschoolforkids.R;
import com.bumptech.glide.Glide;

import static com.avstore.preschool2019.SecondActivity.ToolLinearLayout;
import static com.avstore.preschool2019.SecondActivity.mViewPager;
import static com.avstore.preschool2019.SecondActivity.toolbarTextview;

class ViewPagerAdapter extends PagerAdapter {


    Context mContext;
    LayoutInflater mLayoutInflater;
    private int pos;
    private int item_lenght;
    public  int p;
    private ImageView Imageview,humanImageview,OneImageview;


    public ViewPagerAdapter(Context context) {
        mContext = context;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

//        previusButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                Toast.makeText(mContext, "posss"+pos, Toast.LENGTH_SHORT).show();
//
//            }
//        });

//        nextButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                Toast.makeText(mContext, "posss"+pos, Toast.LENGTH_SHORT).show();
//
//
//            }
//        });

    }

    @Override
    public int getCount() {
        switch (MenuActivity.position)
        {
            case 0:

                item_lenght=Constant.abc.length;

                break;
            case 2:
                item_lenght= Constant.one.length;

                break;
            case 6:
                item_lenght= Constant.Human.length;

                break;

        }
       return item_lenght;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((LinearLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View itemView = mLayoutInflater.inflate(R.layout.pager_item, container, false);

         p=position;

        TextView abctextview = (TextView) itemView.findViewById(R.id.abctextview);
        TextView ABCtextview = (TextView) itemView.findViewById(R.id.ABCtextview);
        TextView fortextview = (TextView) itemView.findViewById(R.id.fortextview);

         Imageview = (ImageView) itemView.findViewById(R.id.Imageview);
         OneImageview = (ImageView) itemView.findViewById(R.id.OneImageview);
         humanImageview = (ImageView) itemView.findViewById(R.id.humanImageview);


        LinearLayout ABDLinearLayout = (LinearLayout) itemView.findViewById(R.id.ABDLinearLayout);
        LinearLayout OneLinearLyout = (LinearLayout) itemView.findViewById(R.id.OneLinearLyout);
        LinearLayout HumanLinearLyout = (LinearLayout) itemView.findViewById(R.id.HumanLinearLyout);

        pos=mViewPager.getCurrentItem();


        switch (MenuActivity.position)
        {
            case 0:

                OneLinearLyout.setVisibility(View.GONE);
                HumanLinearLyout.setVisibility(View.GONE);

                if(ABDLinearLayout.getVisibility()==View.GONE) {
                    ABDLinearLayout.setVisibility(View.VISIBLE);
                }

                ToolLinearLayout.setBackgroundColor(Color.parseColor("#720D22DF"));
                abctextview.setText(Constant.abcd[position]);
                ABCtextview.setText(Constant.ABCD[position]);
                Glide.with(mContext).load(Constant.a[position]).into(Imageview);
                Constant.playAssetSound(mContext,Constant.abc[pos]);
                Constant.playAssetSound(mContext,Constant.abc[mViewPager.getCurrentItem()]);
                mViewPager.setOnPageChangeListener(player);



                break;
            case 2:

                ABDLinearLayout.setVisibility(View.GONE);
                HumanLinearLyout.setVisibility(View.GONE);

                if(OneLinearLyout.getVisibility()==View.GONE) {
                    OneLinearLyout.setVisibility(View.VISIBLE);
                }

                ToolLinearLayout.setBackgroundColor(Color.parseColor("#F56DCA70"));
                toolbarTextview.setTextColor(Color.parseColor("#ffffff"));

                Glide.with(mContext).load(Constant.one[position]).into(OneImageview);
                Constant.playAssetSound(mContext,Constant.OneToHun[pos]);
                mViewPager.setOnPageChangeListener(player);
                break;
            case 6:

                ABDLinearLayout.setVisibility(View.GONE);
                OneLinearLyout.setVisibility(View.GONE);

                if(HumanLinearLyout.getVisibility()==View.GONE) {
                    HumanLinearLyout.setVisibility(View.VISIBLE);
                }

                ToolLinearLayout.setBackgroundColor(Color.parseColor("#BFC5DB4B"));
                toolbarTextview.setTextColor(Color.parseColor("#ffffff"));

                Glide.with(mContext).load(Constant.Human[position]).into(humanImageview);
                Constant.playAssetSound(mContext,Constant.HumanSound[pos]);
                mViewPager.setOnPageChangeListener(player);
                break;
        }


        container.addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);

    }


    ViewPager.OnPageChangeListener player = new ViewPager.OnPageChangeListener()
    {

        @Override
        public void onPageSelected(int arg0)
        {
            Constant.mediaPlayer.stop();
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2)
        {
            Constant.mediaPlayer.stop();
        }

        @Override
        public void onPageScrollStateChanged(int arg0)
        {
            Constant.mediaPlayer.stop();
        }
    };


}