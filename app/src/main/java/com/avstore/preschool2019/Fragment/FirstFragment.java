package com.avstore.preschool2019.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.avstore.education.avpreschoolforkids.R;
import com.avstore.preschool2019.Constant;



public class FirstFragment extends Fragment {
    // Store instance variables
    private String title;
    private int page;
    private RecyclerView colorRecyclerview;

    // newInstance constructor for creating fragment with arguments
    public static FirstFragment newInstance(int page, String title) {
        FirstFragment fragmentFirst = new FirstFragment();
        Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putString("someTitle", title);
        fragmentFirst.setArguments(args);
        return fragmentFirst;
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
        View view = inflater.inflate(R.layout.fragment_first, container, false);

        colorRecyclerview=(RecyclerView)view.findViewById(R.id.colorRecyclerview);
        ColourAdapter colorAdapter=new ColourAdapter(getContext());
        RecyclerView.LayoutManager menuManager=new GridLayoutManager(getContext(),2,GridLayoutManager.VERTICAL,false);
        colorRecyclerview.setLayoutManager(menuManager);
        colorRecyclerview.setAdapter(colorAdapter);

//        TextView tvLabel = (TextView) view.findViewById(R.id.tvLabel);
//        tvLabel.setText(page + " -- " + title);
        return view;
    }


    //Color ADAPTER CODE
    private class ColourAdapter extends RecyclerView.Adapter<ViewHolder> {


        public ColourAdapter(Context context) {

        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

            View view=getLayoutInflater().inflate(R.layout.colour_item,viewGroup,false);

            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

                viewHolder.colorImageview.setImageResource(Constant.colorImage[i]);
                viewHolder.colorTextview.setText(Constant.colorName[i]);
//            if(ColourActivity.vpPager.getCurrentItem() == 0) {
////                Constant.playAssetSound(getContext(), "color_one.mp3");
//            }

        }


        @Override
        public int getItemCount() {
            return Constant.colorImage.length;
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