package com.mayendrams.cekrek;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mayendrams.cekrek.database.api_interface;
import com.mayendrams.cekrek.database.api_client;
import com.mayendrams.cekrek.model.ModelLogin;
import com.mayendrams.cekrek.SharedPreference.Session;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Register extends AppCompatActivity {

    Session session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button button = findViewById(R.id.btnlogin);
        final EditText emaillogin = findViewById(R.id.edemaillogin);
        final EditText pwdlogin = findViewById(R.id.pwdlogin);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emaillogin.getText().toString().trim();
                String pwd = pwdlogin.getText().toString().trim();
                login(email, pwd);
//            onBackPressed();


            }
        });
    }

//    @Override
//    public void onBackPressed() {
//        // do something on back.
//        return;
//    }

    private void login(final String email, final String password) {
        session = new Session(this);

//        registerView.showProgress();
        api_interface api = api_client.getApiClient().create(api_interface.class);

        Call<ModelLogin> call = api.login(email, password);

        call.enqueue(new Callback<ModelLogin>() {
            @Override
            public void onResponse(@NonNull Call<ModelLogin> call, @NonNull Response<ModelLogin> response) {

                if (response.isSuccessful() && response.body() != null) {
                    Boolean suksess = response.body().isSuccess();
                    if (suksess) {

                        String nama = response.body().getNama();
                        String email = response.body().getEmail();
                        String photo = response.body().getFotoprofil();
//                        registerView.hideProgress();
                        session.createSession(nama, email, photo);
                        Toast.makeText(Register.this,"Berhasil", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(Register.this, MainActivity.class));
                        finish();

                    } else {
                        String pesan=response.body().getMessage();
                        Toast.makeText(Register.this, "Gagal", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<ModelLogin> call, @NonNull Throwable t) {

            }
        });

    }
}
