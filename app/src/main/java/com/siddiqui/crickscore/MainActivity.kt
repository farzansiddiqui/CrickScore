package com.siddiqui.crickscore

import android.annotation.SuppressLint
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.annotation.RequiresApi
import com.siddiqui.crickscore.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.webView.settings.safeBrowsingEnabled = true
        binding.webView.settings.javaScriptEnabled = true

        // Set a WebViewClient to handle page navigation and other events
        binding.webView.webViewClient = WebViewClient()

        binding.webView.webViewClient = object : WebViewClient() {
            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
            }
        }

        // Load a web page
        loadUrl("https://rahulrawat17.github.io/cricket-score-saver/")
    }


    override fun onBackPressed() {
        if (binding.webView.canGoBack()) {
            binding.webView.goBack()
            return
        }
        super.onBackPressed()


    }

    private fun loadUrl(url: String) {
        binding.webView.loadUrl(url)

    }
}