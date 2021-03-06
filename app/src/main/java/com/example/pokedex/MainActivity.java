package com.example.pokedex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.CallLog;
import android.util.Log;

import com.example.pokedex.models.Pokemon;
import com.example.pokedex.models.PokemonRespuesta;
import com.example.pokedex.pokeapi.PokeapiService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "POKEDEX";
    private Retrofit retrofit; //Creamos objeto de retrofit

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        retrofit = new Retrofit.Builder() //Instanciamos el objeto de retrofit
                .baseUrl("https://pokeapi.co/api/v2/") //Aquí definimos la url base (la que nunca cambia)
                .addConverterFactory(GsonConverterFactory.create()) //Convertimos lo que nos devuelva en un gson
                .build();
        obtenerDatos();
    }

    private void obtenerDatos(){
        PokeapiService service = retrofit.create(PokeapiService.class);
        Call<PokemonRespuesta> pokemonRespuestaCall = service.obtenerListaPokemon();

        pokemonRespuestaCall.enqueue(new Callback<PokemonRespuesta>() {
            @Override
            public void onResponse(Call<PokemonRespuesta> call, Response<PokemonRespuesta> response) {
                if(response.isSuccessful()){
                    PokemonRespuesta pokemonRespuesta = response.body();
                    ArrayList<Pokemon> listaPokemon = pokemonRespuesta.getResults();

                    for (int i = 0; i < listaPokemon.size(); i++){
                        Pokemon p = listaPokemon.get(i);
                        Log.i(TAG, " Pokemon: " + p.getName());
                    }

                }else{
                    Log.e(TAG, " onResponse: " + response.body());
                }
            }

            @Override
            public void onFailure(Call<PokemonRespuesta> call, Throwable t) {
                Log.e(TAG, " onFalure: " + t.getMessage());
            }
        });
    }
}