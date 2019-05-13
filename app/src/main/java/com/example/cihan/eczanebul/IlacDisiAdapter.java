package com.example.cihan.eczanebul;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * Created by cihan on 23.04.2019.
 */

public class IlacDisiAdapter extends RecyclerView.Adapter<IlacDisiAdapter.ViewHolder>{
    private ArrayList<ArrayList<String>> list;
    private Context context;

    public IlacDisiAdapter(Context context,ArrayList<ArrayList<String>> list){
        this.context=context;
        this.list=list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        View view=layoutInflater.inflate(R.layout.eczanegoster,null);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ArrayList<String> insert = list.get(position);
        holder.eczAdi.setText(insert.get(0));
        holder.eczAdres.setText(insert.get(1));
        holder.ilacIsim.setText(insert.get(2)+" tl");
    }

    @Override
    public int getItemCount() {
        if(list==null)
            return 0;
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView eczAdi;
        TextView eczAdres;
        TextView ilacIsim;
        public ViewHolder(View view){
            super(view);
            eczAdi=(TextView)view.findViewById(R.id.eczGosterIsım);
            eczAdres=(TextView)view.findViewById(R.id.eczGosterAdres);
            ilacIsim=(TextView)view.findViewById(R.id.eczGosterTel);
        }
    }
}
