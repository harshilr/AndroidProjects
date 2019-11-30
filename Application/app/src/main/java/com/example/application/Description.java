package com.example.application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Description extends AppCompatActivity {



    ImageView imageView;
    TextView nameText,typeText,abilityText,heightText,weightText,descriptionText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        imageView = findViewById(R.id.imagePokemon);
        nameText = findViewById(R.id.namePokemon);
        typeText = findViewById(R.id.typePokemon);
        abilityText= findViewById(R.id.abilityPokemon);
        heightText = findViewById(R.id.heightPokemon);
        weightText = findViewById(R.id.weightPokemon);
        descriptionText = findViewById(R.id.descriptionPokemon);

        Intent intent = getIntent();
        //ArrayList<Pokemon>arrayList = (ArrayList<Pokemon>) getIntent().getSerializableExtra("arraylist");

        Pokemon pokemon = intent.getParcelableExtra("arraylist");

        Picasso.get().load(pokemon.getPokemonImage()).into(imageView);

        nameText.setText(pokemon.getPokemonName());
        typeText.setText(pokemon.getPokemonType());
        abilityText.setText(pokemon.getPokemonAbility());
        heightText.setText(pokemon.getPokemonHeight());
        weightText.setText(pokemon.getPokemonWeight());
        descriptionText.setText(pokemon.getPokemonDescription());

        descriptionText.setMovementMethod(new ScrollingMovementMethod());








    }
}
