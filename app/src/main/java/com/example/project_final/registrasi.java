package com.example.project_final;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class registrasi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrasi);
        final EditText txtCpName = findViewById(R.id.isiCpName);
        final EditText txtUsername = findViewById(R.id.isiUsername);
        final EditText txtPassword = findViewById(R.id.isiPassword);
        Button btnRegistrasi = findViewById(R.id.btnRegistrasi);
        //Tambahkan sebuah listener untuk event tombol di klik
        btnRegistrasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Membuat deklarasi String untuk memperoleh nilai Text dari input
                String str_cpName = txtCpName.getText().toString();
                String str_username = txtUsername.getText().toString();
                String str_password = txtPassword.getText().toString();

                //Deklarasikan sebuah intent yang mengarahkan ke aktivitas login
                Intent i = new Intent(registrasi.this,login.class);

                //metode putExtra memungkinkan pengiriman data ke aktivitas login
                i.putExtra("completeName",str_cpName);
                i.putExtra("Username",str_username);
                i.putExtra("Password", str_password);

                //jalankan intent tersebut
                startActivity(i);
            }
        });
    }
}