package com.example.application;

import android.os.Parcel;
import android.os.Parcelable;

public class Pokemon implements Parcelable {

    String pokemonName, pokemonImage,pokemonType,pokemonAbility, pokemonHeight, pokemonWeight,pokemonDescription ;

    public Pokemon(String pokemonName, String pokemonImage, String pokemonType, String pokemonAbility, String pokemonHeight, String pokemonWeight, String pokemonDescription) {
        this.pokemonName = pokemonName;
        this.pokemonImage = pokemonImage;
        this.pokemonType = pokemonType;
        this.pokemonAbility = pokemonAbility;
        this.pokemonHeight = pokemonHeight;
        this.pokemonWeight = pokemonWeight;
        this.pokemonDescription = pokemonDescription;
    }

    protected Pokemon(Parcel in) {
        pokemonName = in.readString();
        pokemonImage = in.readString();
        pokemonType = in.readString();
        pokemonAbility = in.readString();
        pokemonHeight = in.readString();
        pokemonWeight = in.readString();
        pokemonDescription = in.readString();
    }

    public static final Creator<Pokemon> CREATOR = new Creator<Pokemon>() {
        @Override
        public Pokemon createFromParcel(Parcel in) {
            return new Pokemon(in);
        }

        @Override
        public Pokemon[] newArray(int size) {
            return new Pokemon[size];
        }
    };

    public String getPokemonName() {
        return pokemonName;
    }

    public void setPokemonName(String pokemonName) {
        this.pokemonName = pokemonName;
    }

    public String getPokemonImage() {
        return pokemonImage;
    }

    public void setPokemonImage(String pokemonImage) {
        this.pokemonImage = pokemonImage;
    }

    public String getPokemonType() {
        return pokemonType;
    }

    public void setPokemonType(String pokemonType) {
        this.pokemonType = pokemonType;
    }

    public String getPokemonAbility() {
        return pokemonAbility;
    }

    public void setPokemonAbility(String pokemonAbility) {
        this.pokemonAbility = pokemonAbility;
    }

    public String getPokemonHeight() {
        return pokemonHeight;
    }

    public void setPokemonHeight(String pokemonHeight) {
        this.pokemonHeight = pokemonHeight;
    }

    public String getPokemonWeight() {
        return pokemonWeight;
    }

    public void setPokemonWeight(String pokemonWeight) {
        this.pokemonWeight = pokemonWeight;
    }

    public String getPokemonDescription() {
        return pokemonDescription;
    }

    public void setPokemonDescription(String pokemonDescription) {
        this.pokemonDescription = pokemonDescription;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(pokemonName);
        dest.writeString(pokemonImage);
        dest.writeString(pokemonType);
        dest.writeString(pokemonAbility);
        dest.writeString(pokemonHeight);
        dest.writeString(pokemonWeight);
        dest.writeString(pokemonDescription);
    }
}
