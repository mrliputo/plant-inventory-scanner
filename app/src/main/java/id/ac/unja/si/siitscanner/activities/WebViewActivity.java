package id.ac.unja.si.siitscanner.activities;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Build;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import id.ac.unja.si.siitscanner.R;
import id.ac.unja.si.siitscanner.common.DetectConnection;

public class WebViewActivity extends AppCompatActivity {
    WebView webView;

    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) webView.goBack();
        else super.onBackPressed();
    }

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        webView = findViewById(R.id.wv);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.parseColor("#4CAF50"));
        }

        if(!DetectConnection.checkInternetConnection(this)) {
            Snackbar.make(findViewById(R.id.web_layout), "Fitur ini membutuhkan koneksi Internet. " +
                    "Mohon aktifkan WiFi atau Mobile Data Anda.", Snackbar.LENGTH_LONG).show();
        }else{
            getData();
        }

    }

    private void getData() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            webViewHander(extras.getString("link"));
        }
    }

    private void webViewHander(String link) {
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setFocusable(true);
        webView.setFocusableInTouchMode(true);
        webView.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        webView.getSettings().setCacheMode((WebSettings.LOAD_NO_CACHE));
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setDatabaseEnabled(true);
        webView.getSettings().setAppCacheEnabled(true);
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webView.loadUrl(link);
        webView.setWebViewClient(new WebViewClient());
    }
}
