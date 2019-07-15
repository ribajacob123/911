package com.example.ASSURE;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Registration_Page extends AppCompatActivity {

    private TextView alreadylogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration__page);
        setupview();

        alreadylogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Registration_Page.this, MainActivity.class);
                startActivity(intent);

            }
        });
    }
    private void setupview(){
        alreadylogin = (TextView)findViewById(R.id.tvinfo);
    }
}
