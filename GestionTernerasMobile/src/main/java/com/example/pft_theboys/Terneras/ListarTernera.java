package com.example.pft_theboys.Terneras;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pft_theboys.JsonPlaceHolderApi;
import com.example.pft_theboys.R;
import com.example.pft_theboys.Usuario;
import com.example.pft_theboys.Terneras.TerneraApiJson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListarTernera extends AppCompatActivity {
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_ternera);

        textView = findViewById(R.id.LstTerneras);
        getTerneras();


    }

    //se esta crasheando en alguno de estos momentos
    //Metodo que se utiliza para obtener la lista de usuarios
    private void getTerneras(){
        Retrofit retrofit = new Retrofit.Builder()
                //Abajo va la ruta del servidor y el converter para entender el json
                .baseUrl("http://192.168.0.107:8083/Proyecto/rest/terneras/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        TerneraApiJson terneraApiJson = retrofit.create(TerneraApiJson.class);

        //Obtiene el usuarios con el @POST en la interfaz api
        Call<List<TerneraEntity>> call = terneraApiJson.getTerneras();
        call.enqueue(new Callback<List<TerneraEntity>>() {
            @Override
            public void onResponse(Call<List<TerneraEntity>> call, Response<List<TerneraEntity>> response) {

                if (!response.isSuccessful()) {
                    Context context = getApplicationContext();
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, "Codigo: " + response.code(), duration);
                    toast.show();

                }
                System.out.println("Hola men");

                //Aca tendria que ir la respuesta si el listado es exitoso
                List<TerneraEntity> terneraList = response.body();

                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(getApplicationContext(), "Se listaron las terneras: " ,duration);
                toast.show();


                for (TerneraEntity ternerlst : terneraList) {
                    String content = "";
                    content += "caravana_snig: " + ternerlst.getCaravana_snig() + "\n";
                    content += "guachera: " + ternerlst.getId_guachera() + "\n";
                    content += "id padre: " + ternerlst.getId_padre() + "\n";
                    content += "id madre: " + ternerlst.getId_madre() + "\n";
                    content += "fecha nto: " + ternerlst.getFecha_nto() + "\n";
                    content += "peso al nacer: " + ternerlst.getPeso_al_nacer() + "\n";
                    content += "raza: " + ternerlst.getRaza() + "\n";
                    content += "tipo de parto: " + ternerlst.getTipo_de_parto() + "\n";
                    content += "--------------------------------------------------------------"+ "\n";
                    textView.append(content);
                }

            }

            @Override
            public void onFailure(Call<List<TerneraEntity>> call, Throwable t) {
                Context context = getApplicationContext();
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, t.getMessage(), duration);
                toast.show();
                return;
            }
        }); {

        }
    }

}