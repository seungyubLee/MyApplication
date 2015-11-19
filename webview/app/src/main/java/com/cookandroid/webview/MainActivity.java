package com.cookandroid.webview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import com.cookandroid.webview.R;

public class MainActivity extends Activity {
    Button btnGo, btnBack;
    EditText edtUrl;
    WebView webView1;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtUrl = (EditText) findViewById(R.id.edtUrl);
        btnGo = (Button) findViewById(R.id.btnGo);
        btnBack = (Button) findViewById(R.id.btnBack);
        webView1 = (WebView) findViewById(R.id.webView1);

        webView1.setWebViewClient(new CookWebViewClient());
        WebSettings webSet = webView1.getSettings();
        webSet.setBuiltInZoomControls(true);

        btnGo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String url = edtUrl.getText().toString();

                if (!url.substring(0, 7).equals("http://") || !url.substring(0, 7).equals("HTTP://")) {
                    url = "http://" + url;
                    edtUrl.setText(url);
                }
                webView1.loadUrl(url);
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                webView1.goBack();
            }
        });
    }

    class CookWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return super.shouldOverrideUrlLoading(view, url);
        }
        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);

            edtUrl.setText(url);

        }
    }
}