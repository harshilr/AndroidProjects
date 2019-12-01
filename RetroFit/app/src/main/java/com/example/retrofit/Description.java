package com.example.retrofit;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

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

        Pokemon_ pokemon = intent.getParcelableExtra("arraylist");

        Picasso.get().load(pokemon.getImage()).into(imageView);

        nameText.setText(pokemon.getName());
        typeText.setText(pokemon.getType());
        abilityText.setText(pokemon.getAbility());
        heightText.setText(pokemon.getHeight());
        weightText.setText(pokemon.getWeight());
        descriptionText.setText(pokemon.getDescription());

        descriptionText.setMovementMethod(new ScrollingMovementMethod());








    }
}
