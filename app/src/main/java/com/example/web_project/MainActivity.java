package com.example.web_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText editTextUrl;
    private WebView webViewMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextUrl = findViewById(R.id.editTextUrl);
        webViewMain = findViewById(R.id.webVieMain);

        WebSettings webSettings = webViewMain.getSettings();

        webSettings.getJavaScriptEnabled();

        webViewMain.setWebViewClient(new WebViewClient());

        editTextUrl.setOnEditorActionListener((v, actionId, event) -> {
            if(actionId == EditorInfo.IME_ACTION_SEARCH){
                String url = editTextUrl.getText().toString().trim();

                if(url.startsWith("http://") == false && url.startsWith("https://")==false){
                    url = "http://"+url;
                    editTextUrl.setText(url);
                }
                goToUrl(url);

                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(v.getWindowToken(),0);
                return false;
            }
            return false;
        });
    }

    private void goToUrl(String url) {
        webViewMain.loadUrl(url);
    }

    public void Btn_Refresh(View view) {
    }
}