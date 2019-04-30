package com.example.cihan.eczanebul;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by cihan on 25.04.2019.
 */

public class ReceteBulAdapter extends RecyclerView.Adapter<ReceteBulAdapter.ViewHolder> {
    private ArrayList<String> list = null;
    private Context context =null;
    private Database database;
    private static final String TAG = "ReceteBulAdapter";


    public ReceteBulAdapter(Context context, ArrayList<String> list){
        this.list=list;
        this.context=context;
        database = Database.getInstance(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View v = layoutInflater.inflate(R.layout.receteilacgoster,null);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String data[] = list.get(position).split(",");
        ArrayList<String> val = database.eczaneAdresTelefon(data[0]);
        holder.ilacFiyat.setText(data[1]);
        holder.isim.setText(data[0]);
        holder.adres.setText(val.get(1));
    }

    @Override
    public int getItemCount() {
        if(list==null)
            return 0;
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView isim;
        public TextView adres;

        public TextView ilacFiyat;


        public ViewHolder(View view){
            super(view);
            isim = (TextView)view.findViewById(R.id.receteGosterIsim);
            adres = (TextView)view.findViewById(R.id.receteGosterAdres);

            ilacFiyat = (TextView)view.findViewById(R.id.receteGosterIlacFiyat);
        }
    }
}
