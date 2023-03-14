package com.example.pft_theboys.Terneras;

import static java.lang.Integer.parseInt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.pft_theboys.R;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AgregarTernera extends AppCompatActivity {


    TerneraEntity ternera = new TerneraEntity();
    private Button btnAgregarTer;
    private EditText caravanaSnigTxt;
    private EditText guacheraTxt;
    private EditText padreTxt;
    private EditText madreTxt;
    private EditText fechaNtoTxt;
    private EditText pesoNacerTxt;
    private EditText raza;
    private Spinner spinnerTipPart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_ternera);

        caravanaSnigTxt = findViewById(R.id.caravanaTxt);
        guacheraTxt     = findViewById(R.id.guacheraTxt);
        padreTxt        = findViewById(R.id.padreTxt);
        madreTxt        = findViewById(R.id.madreTxt);
        pesoNacerTxt    = findViewById(R.id.pesAlNacTxt);
        raza            = findViewById(R.id.razaTxt);
        fechaNtoTxt     = findViewById(R.id.fecNacTxt);
        btnAgregarTer   = findViewById(R.id.guardarBtn);
        spinnerTipPart  = findViewById(R.id.spinnerTipPart);



        btnAgregarTer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String fechaStr = fechaNtoTxt.getText().toString();
                System.out.println(fechaNtoTxt.getText().toString());
                Date fechaNto = null;

                String parto = spinnerTipPart.getSelectedItem().toString();

                try {
                    fechaNto = new SimpleDateFormat("dd/MM/yyyy").parse(fechaStr);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                System.out.println(fechaNto);
                System.out.println(caravanaSnigTxt.getText().toString());
                System.out.println(guacheraTxt.getText().toString());
                System.out.println(padreTxt.getText().toString());
                System.out.println(madreTxt.getText().toString());
                System.out.println(pesoNacerTxt.getText().toString());
                System.out.println(raza.getText().toString());



                ternera.setCaravana_snig(caravanaSnigTxt.getText().toString());
                ternera.setId_guachera(parseInt(guacheraTxt.getText().toString()));
                ternera.setId_padre(parseInt(padreTxt.getText().toString()));
                ternera.setId_madre(parseInt(madreTxt.getText().toString()));
                ternera.setPeso_al_nacer(parseInt(pesoNacerTxt.getText().toString()));
                ternera.setRaza(raza.getText().toString());
                ternera.setTipo_de_parto(parto);
                altaTerneras(ternera);

            }
        });

    }

    //se esta crasheando en alguno de estos momentos
    //Metodo que se utiliza para obtener la lista de usuarios
    private void altaTerneras(TerneraEntity ternera){
        Retrofit retrofit = new Retrofit.Builder()
                //Abajo va la ruta del servidor y el converter para entender el json
                .baseUrl("http://192.168.0.107:8083/Proyecto/rest/terneras/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        TerneraApiJson terneraApiJson = retrofit.create(TerneraApiJson.class);

        //Obtiene el usuarios con el @POST en la interfaz api
        Call<TerneraEntity> call = terneraApiJson.agregTernera(ternera);
        call.enqueue(new Callback<TerneraEntity>() {
            @Override
            public void onResponse(Call<TerneraEntity> call, Response<TerneraEntity> response) {

                if (!response.isSuccessful()) {
                    Context context = getApplicationContext();
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, "Codigo: " + response.code(), duration);
                    toast.show();

                }
                System.out.println("Hola men");

                //Aca tendria que ir la respuesta si el listado es exitoso

                if (response.isSuccessful()) {
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(getApplicationContext(), "Se creo una nueva ternera: ", duration);
                    toast.show();
                }

            }

            @Override
            public void onFailure(Call<TerneraEntity> call, Throwable t) {
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