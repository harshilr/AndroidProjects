package com.example.application;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    ArrayList<Pokemon> arrayList;
    Adapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arrayList = new ArrayList<>();

        String jsonLink ="https://next.json-generator.com/api/json/get/E14trR2lD";

        try {

            String jsonData = new SyncData().execute(jsonLink).get();
            System.out.println("Data from Main :"+jsonData);

            JSONObject mainJsonObject = new JSONObject(jsonData);
            JSONArray array = mainJsonObject.getJSONArray("Pokemon");

            for (int i=0; i<array.length();i++){
                JSONObject childObject = array.getJSONObject(i);

                String name= childObject.getString("name");
                String image = childObject.getString("image");
                String type = childObject.getString("type");
                String ability = childObject.getString("ability");
                String height = childObject.getString("height");
                String weight = childObject.getString("weight");
                String description = childObject.getString("description");

                arrayList.add(new Pokemon(name,image,type,ability,height,weight,description));



            }

            adapter = new Adapter(arrayList,getApplication());
            initView();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public void initView(){

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL,false);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListner(onClickListener);

    }

    public final View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this,Description.class);
            RecyclerView.ViewHolder viewHolder=(RecyclerView.ViewHolder) v.getTag();
            int position = viewHolder.getAdapterPosition();


            intent.putExtra("arraylist",arrayList.get(position));
            startActivity(intent);

            //Toast.makeText(getApplicationContext(),arrayList.get(position).getPokemonName(),Toast.LENGTH_LONG).show();
         }
    };
}
