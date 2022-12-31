package com.example.qrusingapiphase2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class qrPage extends AppCompatActivity {

    WebView mWebview;
    TextView tv2;
    Button SaveBtn, NextBtn;
    String word = "";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_page);

        mWebview = findViewById(R.id.qrWebView);
        SaveBtn = findViewById(R.id.qrSaveBtn);
        NextBtn = findViewById(R.id.qrNextBtn);
        tv2 = findViewById(R.id.qrGenTV);

        Bundle bundle = getIntent().getExtras();
        String getName = "";

        if(bundle != null){
            getName = bundle.getString("word");
            tv2.setText(getName);
        }


        SaveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        NextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(qrPage.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    public void generateQR (String word) {
        String URL = "https://api.qrserver.com/v1/create-qr-code/?size=150x150&data=" + word;


        mWebview.setWebViewClient(new WebViewClient() {
//            @SuppressWarnings("deprecation")
            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                Toast.makeText(qrPage.this, "Thanks for generating", Toast.LENGTH_SHORT).show();
            }

            @TargetApi(android.os.Build.VERSION_CODES.M)
            @Override
            public void onReceivedError(WebView view, WebResourceRequest req, WebResourceError rerr) {
                // Redirect to deprecated method, so you can use it in all SDK versions
                onReceivedError(view, rerr.getErrorCode(), rerr.getDescription().toString(), req.getUrl().toString());
            }
        });

        mWebview.loadUrl(URL);
    }
}