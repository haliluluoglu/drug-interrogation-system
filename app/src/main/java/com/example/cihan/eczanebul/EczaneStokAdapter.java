package com.example.cihan.eczanebul;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by cihan on 28.04.2019.
 */

public class EczaneStokAdapter extends RecyclerView.Adapter<EczaneStokAdapter.ViewHolder>{
    private Context context;
    private ArrayList<ArrayList<String>> list;

    public EczaneStokAdapter(Context context,ArrayList<ArrayList<String>> list){
        this.context=context;
        this.list=list;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        View v=layoutInflater.inflate(R.layout.receteilacgoster,null);

        ViewHolder vh=new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.isim.setText("İlaç İsmi= "+list.get(position).get(0));
        holder.mg.setText(list.get(position).get(1)+" MG");
        holder.adet.setText(list.get(position).get(2)+" Adet");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView isim;
        TextView mg;
        TextView adet;
        public ViewHolder(View v){
            super(v);
            isim=(TextView)v.findViewById(R.id.receteGosterIsim);
            mg=(TextView)v.findViewById(R.id.receteGosterAdres);
            adet=(TextView)v.findViewById(R.id.receteGosterIlacFiyat);
        }
    }

}
