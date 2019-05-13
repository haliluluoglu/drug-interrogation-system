package com.example.cihan.eczanebul;

import android.content.Context;
import android.content.Intent;
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

public class ReceteDetayAdapter extends RecyclerView.Adapter<ReceteDetayAdapter.ViewHolder>{
    private ArrayList<String> list;
    private Context context;
    private Database database=null;
    private int num;
    private float x,y;

    public ReceteDetayAdapter(Context context,ArrayList<String> list,String num,float x,float y){
        this.context=context;
        this.list=list;
        this.database=Database.getInstance(context);
        this.num=Integer.parseInt(num);
        this.x=x;
        this.y=y;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View v=layoutInflater.inflate(R.layout.eczanegoster,null);

        ViewHolder vh=new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final String put[]=list.get(position+1).split(",");
        holder.ilacAdi.setText(put[0]);
        if(!put[1].equals("-1"))
            holder.ilacMg.setText(put[1]+"MG");
        else
            holder.ilacMg.setText("İlaç Dışı Ürün");
        String str=database.receteSatinAlinma(num,put[0]);
        if(str==null||str.length()==0||str.equals("null"))
               holder.Tarih.setText("İlaç alınmadı");
        else
               holder.Tarih.setText("İlaç Alınma Tarihi: "+str);
        holder.myView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent = new Intent(context,ReceteIlacGosterActivity.class);
               intent.putExtra("isim",put[0]);
               intent.putExtra("mg",put[1]);
               intent.putExtra("x",x);
               intent.putExtra("y",y);
               context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        if(list == null)
            return 0;
        return list.size()-1;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView ilacAdi;
        TextView ilacMg;
        TextView Tarih;
        View myView;
        public ViewHolder(View v){
            super(v);
            myView=v;
            ilacAdi=(TextView)v.findViewById(R.id.eczGosterIsım);
            ilacMg=(TextView)v.findViewById(R.id.eczGosterAdres);
            Tarih=(TextView)v.findViewById(R.id.eczGosterTel);
        }
    }
}
