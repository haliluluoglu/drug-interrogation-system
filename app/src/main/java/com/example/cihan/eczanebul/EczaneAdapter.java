package com.example.cihan.eczanebul;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by cihan on 18.04.2019.
 */

public class EczaneAdapter extends RecyclerView.Adapter<EczaneAdapter.ViewHolder> {
    private ArrayList<String> list;
    private Context context = null;
    private Database database;
    public EczaneAdapter(ArrayList<String> eczane,Context context){
        list=eczane;
        this.context=context;
        database = Database.getInstance(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View v = layoutInflater.inflate(R.layout.eczanegoster,null);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position){
        ArrayList<String> adderList = database.eczaneAdresTelefon(list.get(position));
        holder.eczIsim.setText(adderList.get(0));
        holder.eczAdres.setText(adderList.get(1));
        holder.eczTelefon.setText(adderList.get(2));
    }

    @Override
    public int getItemCount() {
        if(list == null)
            return 0;
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView eczIsim;
        public TextView eczAdres;
        public TextView eczTelefon;

        public View layout;
        public ViewHolder(View itemView) {
            super(itemView);
            layout = itemView;
            eczIsim = (TextView)itemView.findViewById(R.id.eczGosterIsım);
            eczAdres = (TextView)itemView.findViewById(R.id.eczGosterAdres);
            eczTelefon = (TextView)itemView.findViewById(R.id.eczGosterTel);

        }
    }
}
