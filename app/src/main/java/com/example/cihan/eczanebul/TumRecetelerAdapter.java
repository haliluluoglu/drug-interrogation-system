package com.example.cihan.eczanebul;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.provider.ContactsContract;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by cihan on 26.04.2019.
 */

public class TumRecetelerAdapter extends RecyclerView.Adapter<TumRecetelerAdapter.ViewHolder>{
    private ArrayList<ArrayList<String>> list;
    private Context context;
    private Database database;
    private float x,y;

    public TumRecetelerAdapter(Context context,int id,float x,float y){
        this.context = context;
        database = Database.getInstance(context);
        list=database.hastaReceteSorgula(id);
        this.x=x;
        this.y=y;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View v = layoutInflater.inflate(R.layout.tumrecetelerigoster,null);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        String tarih=database.receteTarihVer(Integer.parseInt(list.get(position).get(0)));
        holder.numara.setText("Recete Numarası = "+list.get(position).get(0));
        holder.tarih.setText("Recete Tarih = "+tarih);
        holder.myView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,ReceteDetayActivity.class);
                intent.putExtra("num",list.get(position).get(0));
                intent.putExtra("list",list.get(position));
                intent.putExtra("x",x);
                intent.putExtra("x",y);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        if(list==null)
            return 0;
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView numara;
        public TextView tarih;

        public View myView;
        public ViewHolder(View v){
            super(v);
            myView=v;
            numara=(TextView)v.findViewById(R.id.receteNumara);
            tarih=(TextView)v.findViewById(R.id.receteTarih);
        }
    }
}
