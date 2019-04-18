package com.example.cihan.eczanebul;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by cihan on 14.04.2019.
 */

public class Database extends SQLiteOpenHelper {
    private static final String TAG = "Database";

    public static final String RECETE_TABLE="Recete";
    public static final String ILAC_TABLE="Ilac";
    public static final String ECZANE_TABLE="Eczane";
    public static final String HASTA_TABLE="Hasta";
    public static final String DOKTOR_TABLE="Doktor";
    public static final String NOBETCI_TABLE="Nobetci";
    private static Database instance=null;

    public static Database getInstance(Context context){
        if(instance==null){
            instance = new Database(context);
        }
        return instance;
    }

    public Database(Context context){
        super(context,"EczaneBul.db",null,1);
        Log.d(TAG, "Database: created");

        //ilacGir("parol",1,10.0f,50,0);
        //eczaneGir(1,"Kaya Eczanesi","Esenler","05559997766",50.0f,40.0f);
        //doktorGir(1,"Hakan","Ersoy","tcbc");
        //hastaBilgiGir("Ahmet","Demir",1);
        //doktorReceteHazirla(new String[]{"parol"},new int[]{50},1);
        //eczaneStokSorgula("Kaya Eczanesi");

        ArrayList<ArrayList<String>> list = null;
        list = hastaReceteSorgula(1);

        if(list!=null){
            Log.d(TAG, "Database: "+list.get(0).get(0));
        }

        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String create_eczane,create_hasta,create_hastaid,create_recete,create_doktor,create_ilac,create_nobetci;
        Log.d(TAG, "onCreate: starts");

        create_hastaid="CREATE TABLE HASTAID ( "+
                "ID INT, "+
                "SIFRE VARCHAR(30), "+
                "ISIM VARCHAR(30), "+
                "SOYISIM VARCHAR(30), " +
                "CONSTRAINT PRIM PRIMARY KEY (ID));";

        create_doktor="CREATE TABLE " + DOKTOR_TABLE + " ( "+
                "ID INT, "+
                "ISIM VARCHAR(30), "+
                "SOYISIM VARCHAR(30), "+
                "SIFRE VARCHAR(30), " +
                "CONSTRAINT PRIM PRIMARY KEY (ID));";

        create_hasta="CREATE TABLE " + HASTA_TABLE + " ( "+
                "ISIM VARCHAR(30), "+
                "SOYISIM VARCHAR(30), "+
                "ID INT, "+
                "ILAC_ISIM VARCHAR(30), "+
                "MG INT, " +
                "CONSTRAINT FORE FOREIGN KEY (ID) REFERENCES HASTAID(ID));";

        create_eczane="CREATE TABLE " + ECZANE_TABLE + " ( "+
                "ID INT, "+
                "SIFRE VARCHAR(30), "+
                "ISIM VARCHAR(30), "+
                "ADRES VARCHAR(30), " +
                "TELEFON VARCHAR(30), "+
                "KOORDX FLOAT, "+
                "KOORDY FLOAT, " +
                "CONSTRAINT PRIM PRIMARY KEY (ID));";

        create_ilac="CREATE TABLE " + ILAC_TABLE + " ( "+
                "ISIM VARCHAR(30), "+
                "ECZANE INT, "+
                "FIYAT FLOAT, "+
                "MG INT, " +
                "ILAC_DISI INT, " +
                "CONSTRAINT PRIM PRIMARY KEY (ISIM,ECZANE));";

        create_recete="CREATE TABLE " + RECETE_TABLE + " ( "+
                "ID INT, "+
                "ILAC VARCHAR(30), "+
                "MG INT, " +
                "KUL INT, " +
                "PRIMARY KEY (ID,ILAC));";

        create_nobetci="CREATE TABLE " + NOBETCI_TABLE + " ( "+
                "ISIM VARCHAR(30), " +
                "CONSTRAINT FORE FOREIGN KEY (ISIM) REFERENCES ECZANE(ISIM));";

        sqLiteDatabase.execSQL(create_doktor);
        sqLiteDatabase.execSQL(create_hasta);
        sqLiteDatabase.execSQL(create_recete);
        sqLiteDatabase.execSQL(create_ilac);
        sqLiteDatabase.execSQL(create_eczane);
        sqLiteDatabase.execSQL(create_nobetci);
        sqLiteDatabase.execSQL(create_hastaid);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }



    public void ilacGir(String isim, int eczane, float fiyat, int mg, int ilacdisi){
        SQLiteDatabase db = getWritableDatabase();
        String insert="insert into Ilac values('%s',%d,%f,%d,%d);";
        db.execSQL(String.format(insert,isim,eczane,fiyat,mg,ilacdisi));
    }

    public void doktorGir(int id, String isim, String soyisim, String sifre){
        SQLiteDatabase db = getWritableDatabase();
        String insert="insert into Doktor values(%d,'%s','%s','%s');";
        db.execSQL(String.format(insert,id,isim,soyisim,sifre));
    }

    public void nobetciGir(String isim){
        SQLiteDatabase db = getWritableDatabase();
        String insert="insert into Nobetci values('%s');";
        db.execSQL(String.format(insert,isim));
    }

    public void receteGir(int id, String isim, int mg, int kul){
        SQLiteDatabase db = getWritableDatabase();
        String insert="insert into Recete values(%d,'%s',%d,%d);";
        db.execSQL(String.format(insert,id,isim,mg,kul));
    }

    public void eczaneGir(int id,String sifre,String isim,String adres,String telefon,float koordx,float koordy){
        SQLiteDatabase db = getWritableDatabase();
        String insert="insert into Eczane values(%d,'%s','%s','%s','%s',%f,%f);";
        db.execSQL(String.format(insert,id,sifre,isim,adres,telefon,koordx,koordy));
    }

    public void hastaGecmisGir(String isim,String soyisim,int id,String ilacisim,int mg){
        SQLiteDatabase db = getWritableDatabase();
        String insert="insert into Hasta values('%s','%s',%d,'%s',%d);";
        db.execSQL(String.format(insert,isim,soyisim,id,ilacisim,mg));
    }

    public void hastaBilgiGir(String isim,String sifre,String soyisim,int id){
        SQLiteDatabase db = getWritableDatabase();
        String insert="insert into HASTAID values(%d,'%s','%s','%s');";
        db.execSQL(String.format(insert,id,sifre,isim,soyisim));
    }

    public float dist(float x1,float y1,float x2,float y2){
        return (float)Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
    }

    public ArrayList<String> hastaEnYakinEczane(float x, float y){//TODO eczaneyide siralayacak sekilde tekrar yaz.
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query("Eczane",new String[]{"ISIM","KOORDX","KOORDY"},null,null,null,null,null);
        boolean cont = cursor.moveToNext();
        ArrayList<Float> distList = new ArrayList<>();
        ArrayList<String> nameList = new ArrayList<>();
        while(cont){
            float x1=cursor.getFloat(1),y1=cursor.getFloat(2);
            distList.add(dist(x,x1,y,y1));
            nameList.add(cursor.getString(0));
            cont=cursor.moveToNext();
        }
        for(int i = 0; i < distList.size(); i++){
            for(int j = 0; j < distList.size()-1; j++){
                if(distList.get(j)>distList.get(j+1)){
                    float f = distList.get(j);
                    distList.set(j,distList.get(j+1));
                    distList.set(j+1,f);
                    String s = nameList.get(j);
                    nameList.set(j,nameList.get(j+1));
                    nameList.set(j+1,s);
                }
            }
        }
        return nameList;
    }

    public void doktorReceteHazirla(String ilaclar[],int mg[],int kullanici){// HATALI
        int i;
        SQLiteDatabase db=getWritableDatabase();
        Cursor cursor = db.query(true,"Recete",new String[]{"MAX(ID)"},null,null,null,null,null,null);
        cursor.moveToFirst();
        int id=cursor.getInt(0)+1;
        for(i=0;i<ilaclar.length;i++){
            receteGir(id,ilaclar[i],mg[i],kullanici);
        }
        //TODO girdiler veritabanindan alinacak
    }

    public boolean doktorSifreSorgula(String kadi,String sifre){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query("Doktor",new String[]{"ID","SIFRE"},"EXISTS (Select * from doktor where ID='"+kadi+"' and SIFRE='"+sifre+"')",null,null,null,null);
        if(cursor.getCount()!=0){
            return true;
        }
        return false;
    }

    public ArrayList<Integer> doktorIlacSorgula(String ilac){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query("Ilac",new String[]{"MG"},"ISIM='"+ilac+"'",null,null,null,null);
        boolean cont = cursor.moveToFirst();
        ArrayList<Integer> list = new ArrayList<>();
        while(cont){
            list.add(cursor.getInt(0));
            cont = cursor.moveToNext();
        }
        return list;
    }

    public boolean hastaSifreSorgula(String isim,String sifre){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query("HastaID",new String[]{"ID","SIFRE"},"EXISTS (Select * from doktor where ID='"+isim+"' and SIFRE='"+sifre+"')",null,null,null,null);
        if(cursor.getCount()!=0){
            return true;
        }
        return false;
    }

    public String[] hastaNobetciEczaneSorgula(){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query("Nobetci",null,null,null,null,null,null);
        boolean cont = cursor.moveToFirst();
        String nobetciler[]=new String[cursor.getCount()];
        int i=0;
        while(cont){
            nobetciler[i]=cursor.getString(0);
            i++;
            cont = cursor.moveToNext();
        }
        return nobetciler;
    }

    public ArrayList<ArrayList<String>> hastaIlacDisiSorgula(String isim){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query("Ilac",new String[]{"ECZANE","ILAC_DISI"},"ILAC_DISI=1",null,null,null,null);
        boolean cont = cursor.moveToFirst();
        HashMap<Integer,Boolean> map = new HashMap<>();
        ArrayList<ArrayList<String>> list = new ArrayList<>();
        while(cont){
            int eczane=cursor.getInt(0);
            if(!map.containsKey(eczane)){
                map.put(eczane,true);
                Cursor cur = db.query("Eczane",new String[]{"ISIM","ADRES"},null,null,null,null,null);
                cur.moveToFirst();
                ArrayList<String> s = new ArrayList<>();
                s.add(cur.getString(0));
                s.add(cur.getString(1));
                list.add(s);
            }
            cont=cursor.moveToNext();
        }
        return list;
    }

    public ArrayList<ArrayList<String>> hastaReceteSorgula(int id){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query("Recete",new String[]{"ILAC","ID"},"KUL="+id,null,null,null,"ID DESC");
        int i;
        cursor.moveToFirst();
        ArrayList<ArrayList<String>> list = new ArrayList<>();
        ArrayList<String> adder = new ArrayList<>();

        if(cursor.getCount()==0){
            Log.d(TAG, "hastaReceteSorgula: bos dondu");
            return null;
        }

        int num=cursor.getInt(1);
        for(i=0;i<cursor.getCount()-1;i++){
            adder.add(cursor.getString(0));
            if(cursor.getInt(1)!=num){
                num=cursor.getInt(1);
                list.add(adder);
                adder=new ArrayList<>();
            }
            cursor.moveToNext();
        }
        if(cursor.getInt(1)!=num)
            adder=new ArrayList<>();

        adder.add(cursor.getString(0));
        list.add(adder);

        return list;
    }

    public boolean eczaneSifreSorgula(String isim, String sifre){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query("Eczane",new String[]{"ID","SIFRE"},"EXISTS (Select * from doktor where ID='"+isim+"' and SIFRE='"+sifre+"')",null,null,null,null);
        if(cursor.getCount()!=0){
            return true;
        }
        return false;
    }

    public ArrayList<ArrayList<String>> eczaneStokSorgula(String isim){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query("Eczane",new String[]{"ID"},"ISIM='"+isim+"'",null,null,null,null);
        cursor.moveToFirst();
        if(cursor.getCount()==0)
            return null;

        int id=cursor.getInt(0);
        Log.d(TAG, "eczaneStokSorgula: "+id);
        cursor = db.query(true,"Ilac",new String[]{"ISIM","COUNT(ISIM)"},"Eczane="+id,null,null,null,null,null);
        ArrayList<ArrayList<String>> list = new ArrayList<>();
        boolean cont=cursor.moveToFirst();

        while(cont){
            ArrayList<String> add = new ArrayList<>();

            add.add(cursor.getString(0));
            add.add(cursor.getString(1));
            list.add(add);
            cont=cursor.moveToNext();
        }
        return list;
    }

    public void eczaneStokDus(String isim,int receteId) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query("Recete", new String[]{"ILAC", "MG"}, null, null, null, null, null);

        boolean cont = cursor.moveToFirst();

        while (cont) {
            Cursor cursor2 = db.query(true,"ILAC",new String[]{"MIN(ID)"},"ILAC='"+cursor.getString(0)+"' AND MG="+cursor.getInt(1),null,null,null,null,null);
            cursor2.moveToFirst();
            int id = cursor2.getInt(0);
            db = getWritableDatabase();
            db.execSQL("DELETE FROM ILAC WHERE ID="+id);
            cont = cursor.moveToNext();
        }
    }
}