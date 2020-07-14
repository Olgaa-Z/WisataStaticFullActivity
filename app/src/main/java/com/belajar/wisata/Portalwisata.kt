package com.belajar.wisata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AlertDialog
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout

class Portalwisata : AppCompatActivity() {


    lateinit var webView: WebView
    lateinit var swipe: SwipeRefreshLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_portalwisata)

        swipe = findViewById(R.id.swipe) as SwipeRefreshLayout
        swipe.setOnRefreshListener {
            WebAction()
        }

        WebAction()
    }

    fun WebAction() {

        webView = findViewById(R.id.webview) as WebView
        webView.settings.javaScriptEnabled = true
//        webView.settings.setAppCacheEnabled(true)
        webView.loadUrl("http://www.lintasntt.com/")
        swipe.isRefreshing = true
        webView.webViewClient = object : WebViewClient() {

            override fun onReceivedError(view: WebView, errorCode: Int, description: String, failingUrl: String) {

                AlertDialog.Builder(this@Portalwisata)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setTitle("Internet Mati")
                    .setMessage("Hidupkan Koneksi Internet !")
                    .setNegativeButton("OK", null)
                    .show()

            }

            override fun onPageFinished(view: WebView, url: String) {
                // do your stuff here
                swipe.isRefreshing = false
            }

        }

    }

}
