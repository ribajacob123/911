package com.example.ASSURE;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {


    private TextView userLogin;
    private EditText name;
    private EditText password;
    private Button signin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupview();


        userLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Registration_Page.class);
                startActivity(intent);

            }
        });

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (name.getText().toString().equals("user") & password.getText().toString().equals("pass")) {
                    Intent myintent = new Intent(getBaseContext(), Second_activity.class);
                    startActivity(myintent);
                } else if (name.getText().toString().isEmpty() & password.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter required login credentials.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Username or Password is incorrect", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.share){
            ApplicationInfo api = getApplicationContext().getApplicationInfo();
            String apkpath = api.sourceDir;
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("application/vnd.android.package-archive");
            intent.putExtra(Intent.EXTRA_STREAM,Uri.fromFile(new File(apkpath)));
            startActivity(Intent.createChooser(intent,"Share via"));
        }
        return true;
    }

    private void setupview(){
        userLogin = (TextView)findViewById(R.id.tv1info);
        name = (EditText)findViewById(R.id.etname);
        password = (EditText)findViewById(R.id.etpassword);
        signin = (Button)findViewById(R.id.btnsignin);
    }
}
