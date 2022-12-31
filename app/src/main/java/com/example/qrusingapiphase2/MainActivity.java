package com.example.qrusingapiphase2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.qrGenET);
        button = findViewById(R.id.qrGenBtn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String word = editText.getText().toString().trim();
//                generateQR(word);
                Intent intent = new Intent(MainActivity.this, qrPage.class);
                intent.putExtra("word", word);
                startActivity(intent);

            }
        });

    }
}