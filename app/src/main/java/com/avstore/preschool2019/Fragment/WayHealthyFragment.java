package com.avstore.preschool2019.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.avstore.education.avpreschoolforkids.R;
import com.avstore.preschool2019.Constant;



public class WayHealthyFragment extends Fragment {
    // Store instance variables
    private String title;
    private int page;
    private RecyclerView healthyRecyclerview1;

    // newInstance constructor for creating fragment with arguments
    public static WayHealthyFragment newInstance(int page, String title) {
        WayHealthyFragment wayHealthyFragment = new WayHealthyFragment();
        Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putString("someTitle", title);
        wayHealthyFragment.setArguments(args);
        return wayHealthyFragment;
    }

    // Store instance variables based on arguments passed
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        page = getArguments().getInt("someInt", 0);
        title = getArguments().getString("someTitle");
    }

    // Inflate the view for the fragment based on layout XML
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_way_healthy, container, false);

//        healthyRecyclerview1=(RecyclerView)view.findViewById(R.id.healthyRecyclerview1);
//        HealthyAdapter healthyAdapter=new HealthyAdapter(getContext());
//        RecyclerView.LayoutManager healthyManager=new GridLayoutManager(getContext(),2,GridLayoutManager.VERTICAL,false);
//        healthyRecyclerview1.setLayoutManager(healthyManager);
//        healthyRecyclerview1.setAdapter(healthyAdapter);

//        TextView tvLabel = (TextView) view.findViewById(R.id.tvLabel);
//        tvLabel.setText(page + " -- " + title);
        return view;
    }


    //Color ADAPTER CODE
    private class HealthyAdapter extends RecyclerView.Adapter<ViewHolder> {


        public HealthyAdapter(Context context) {

        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

            View view=getLayoutInflater().inflate(R.layout.fragment_way_healthy,viewGroup,false);

            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

            viewHolder.colorImageview.setImageResource(Constant.colorImage2[i]);
            viewHolder.colorTextview.setText(Constant.colorName2[i]);
//            Constant.playAssetSound(getContext(),"color_two.mp3");
//            if(ColourActivity.vpPager.getCurrentItem() == 1) {
//                Constant.playAssetSound(getContext(), "color_two.mp3");
//            }
        }


        @Override
        public int getItemCount() {
            return Constant.colorName2.length;
        }
    }
    public  class ViewHolder extends RecyclerView.ViewHolder
    {
        private final ImageView colorImageview;
        private final TextView colorTextview;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            colorImageview=(ImageView)itemView.findViewById(R.id.colorImageview);
            colorTextview=(TextView)itemView.findViewById(R.id.colorTextview);

        }
    }


}