package com.example.cihan.eczanebul;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by cihan on 18.04.2019.
 */

public class EczaneAdapter extends RecyclerView.Adapter<ViewHolder> {
    private ArrayList<String> list;

    public EczaneAdapter(ArrayList<String> eczane){
        list=eczane;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        public ViewHolder(View itemView) {
            super(itemView);

        }
    }
}
