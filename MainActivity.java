package com.example.iis5.gridview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

//creating MainActivity which extends AppCompatActivity
public class MainActivity extends AppCompatActivity {
//declaring widgets from layout resource file
    private GridView gridView;
    private ImageView androidimageview;
    private ArrayList<Integer>androidversionlist;
    private ArrayList<String>androidtitlelist;
    private TextView androidtextview;
    private Myadapter adapter;

//this method is called when main class is created
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("my app","doing something");
        //find view bt id for the gridview
        gridView = (GridView) findViewById(R.id.grid_view);
//creating Arraylist object and adding the list to it from the drawable file
        androidversionlist = new ArrayList<>();
        androidversionlist.add(R.drawable.gingerbread);
        androidversionlist.add(R.drawable.honeycomb);
        androidversionlist.add(R.drawable.icecreamsandwich);
        androidversionlist.add(R.drawable.jellybean);
        androidversionlist.add(R.drawable.kitkat);
        androidversionlist.add(R.drawable.lolipop);
//adding list names to it
        androidtitlelist = new ArrayList<>();
        androidtitlelist.add("GINGERBREAD");
        androidtitlelist.add("HONEYCOMB");
        androidtitlelist.add("ICECREAM SANDWICH");
        androidtitlelist.add("JELLY BEAN");
        androidtitlelist.add("KITKAT");
        androidtitlelist.add("LOLLIPOP");

        //creating adapter which sets to the gridview
        adapter = new Myadapter();
        gridView.setAdapter(adapter);

    }
    //creating a subclass called myadapter which extends Baseadapter and implementing methods toit
    public class Myadapter extends BaseAdapter {

        @Override
        public int getCount() {
            return androidversionlist.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }
//here in getview method getting Layoutinflater which inflates the row layout
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            viewholder holder;
            if (convertView == null){
                convertView = getLayoutInflater().inflate(R.layout.row,parent,false);
                //creating viewholder object
                holder = new viewholder();
                holder.bindview(convertView);
                convertView.setTag(holder);
                Log.e("MainActivity","convertview is null");
            }
            else {
                holder = (viewholder)convertView.getTag();

            }
            holder.androidimageview.setImageResource(androidversionlist.get(position));
            holder.androidtextview.setText(androidtitlelist.get(position));
            return convertView;
        }
    }//takina a class as viewholder
    public class viewholder{
        ImageView androidimageview;
        TextView androidtextview;
        void bindview(View convertview){
            Log.e("MainActivity","convertview is not null");
            androidimageview = (ImageView)convertview.findViewById(R.id.android_image_view);
            androidtextview = (TextView)convertview.findViewById(R.id.android_text_view);


        }
    }


}
