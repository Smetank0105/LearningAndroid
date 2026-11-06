package com.academy.learningandroid;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import kotlin.text.HexExtensionsKt;

public class MainActivity extends AppCompatActivity {
    WebView webview;
    WebSettings webSettings;
    long backPressedTime = 0L;
    private static final int EXIT_DELAY = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webview = findViewById(R.id.webView);
        webSettings = webview.getSettings();
        webview.loadUrl("https://www.google.com");
        webSettings.setJavaScriptEnabled(true);
        webview.setWebViewClient(new WebViewClient());

        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                if(webview.canGoBack()) {
                    webview.goBack();
                    return;
                }
                long now = SystemClock.elapsedRealtime();
                if(now - backPressedTime < EXIT_DELAY){
                    finish();
                }else{
                    backPressedTime = now;
                    Toast.makeText(MainActivity.this, "Нажми еще раз, что бы выйти", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}