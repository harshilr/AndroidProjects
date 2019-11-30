package com.example.retrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

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
        Call<Pokemon> call = dataService.getPokemons();
        call.enqueue(new Callback<Pokemon>() {
            @Override
            public void onResponse(Call<Pokemon> call, Response<Pokemon> response) {

                Pokemon pokemon = response.body();

                try {

                    arrayList = new ArrayList<>(pokemon.getPokemon());
                    generateRecycle(arrayList);
                }
                catch (NullPointerException e){
                    System.out.println(e.getMessage());
                }
            }

            @Override
            public void onFailure(Call<Pokemon> call, Throwable t) {

                Toast.makeText(getApplicationContext(),"Something is WRONG!"+t.getMessage(),Toast.LENGTH_LONG).show();

            }
        });

    }


    public void generateRecycle(ArrayList<Pokemon_> arrayListPokemon){

        adapter = new Adapter(arrayListPokemon,getApplicationContext());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
    }

}
