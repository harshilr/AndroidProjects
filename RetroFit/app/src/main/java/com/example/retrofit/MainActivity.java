package com.example.retrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    Adapter adapter;
    ArrayList<Pokemon_> arrayList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        DataService dataService = RetroFitClient.getRetrofitInstance().create(DataService.class);

        Call<List<Pokemon_>> call = dataService.getPokemonArray();
        call.enqueue(new Callback<List<Pokemon_>>() {
            @Override
            public void onResponse(Call<List<Pokemon_>> call, Response<List<Pokemon_>> response) {

                arrayList = new ArrayList<>(response.body());
                generateRecycle(arrayList);


            }

            @Override
            public void onFailure(Call<List<Pokemon_>> call, Throwable t) {

            }
        });




//        Call<Pokemon> call = dataService.getPokemons();
//        call.enqueue(new Callback<Pokemon>() {
//            @Override
//            public void onResponse(Call<Pokemon> call, Response<Pokemon> response) {
// @GET("NympVMn2P")
//                Pokemon pokemon = response.body();
//
//                try {
//
//                    arrayList = new ArrayList<>(pokemon.getPokemon());
//                    generateRecycle(arrayList);
//                }
//                catch (NullPointerException e){
//                    System.out.println(e.getMessage());
//                }
//            }
//

//            @Override
//            public void onFailure(Call<Pokemon> call, Throwable t) {
//
//                Toast.makeText(getApplicationContext(),"Something is WRONG!"+t.getMessage(),Toast.LENGTH_LONG).show();
//
//            }
//        });

    }


    public void generateRecycle(ArrayList<Pokemon_> arrayListPokemon){

        adapter = new Adapter(arrayListPokemon,getApplicationContext());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
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

            intent.putExtra("arraylist", arrayList.get(position));
            startActivity(intent);

            //Toast.makeText(getApplicationContext(),arrayList.get(position).getPokemonName(),Toast.LENGTH_LONG).show();
        }
    };
}