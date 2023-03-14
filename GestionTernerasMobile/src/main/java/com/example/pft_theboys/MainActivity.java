package com.example.pft_theboys;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ImageButton;

import com.example.pft_theboys.Terneras.ListarTernera;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    //Este es el elemento de la interfaz
    private TextView UsuarioTxt;
    private TextView contrasTxt;
    private Button btnLogin;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UsuarioTxt = findViewById(R.id.UsuarioTxt);
        contrasTxt = findViewById(R.id.contrasTxt);
        btnLogin   = findViewById(R.id.btnLogin);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click
                if(UsuarioTxt.getText().toString().isEmpty() || contrasTxt.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Complete los campos", Toast.LENGTH_SHORT).show();
                }else{
                    System.out.println("usuario: "+(UsuarioTxt.getText().toString()));
                    System.out.println("contrasenia: "+contrasTxt.getText().toString());

                    //Cuando el login es exitoso vamos al menu principal
                    //Intent miIntent = new Intent(MainActivity.this,MenuPrincipal.class);
                    //startActivity(miIntent);

                    Login(UsuarioTxt.getText().toString(), contrasTxt.getText().toString());
                }


            }
        });
    }

    //se esta crasheando en alguno de estos momentos
    //Metodo que se utiliza para obtener la lista de usuarios
    private void Login(String user,String pass){
        Retrofit retrofit = new Retrofit.Builder()
                //Abajo va la ruta del servidor y el converter para entender el json
                .baseUrl("http://192.168.0.107:8083/Proyecto/rest/usuarios/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        //Obtiene el usuarios con el @POST en la interfaz api
        Call<Usuario> call = jsonPlaceHolderApi.LoginUsuario(user,pass);
        call.enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                if (!response.isSuccessful()){
                    Context context = getApplicationContext();
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context,"Codigo: " + response.code() , duration);
                    toast.show();
                }
                //Aca tendria que ir la respuesta si el login es exitoso
                if (response.isSuccessful()){
                    Context context = getApplicationContext();
                    int duration = Toast.LENGTH_SHORT;

                    //Cuando el login es exitoso vamos al menu principal
                    Intent miIntent = new Intent(MainActivity.this,MenuPrincipal.class);
                    startActivity(miIntent);


                    Toast toast = Toast.makeText(context, "Login exitoso", duration);
                    toast.show();
                }
            }

            //En caso que la respuesta de retrofit falle va a mostrar un error
            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {
                Context context = getApplicationContext();
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, t.getMessage(), duration);
                toast.show();
                return;
            }
        });
    }
}
