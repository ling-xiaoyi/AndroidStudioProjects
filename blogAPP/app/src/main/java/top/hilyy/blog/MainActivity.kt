package top.hilyy.blog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.view.ViewGroup

class MainActivity : AppCompatActivity() {

//    webview
    private lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 创建WebView实例
        webView = WebView(this)

        // 设置WebView配置
        val webSettings = webView.settings
        webSettings.javaScriptEnabled = true

        // 设置WebViewClient来处理页面加载事件
        webView.webViewClient = object : WebViewClient() {
            override fun onPageFinished(view: WebView?, url: String?) {
                // 页面加载完成回调
            }

            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                // 在WebView内加载链接
                url?.let {
                    view?.loadUrl(it)
                }
                return true
            }
        }

        // 加载指定URL
        webView.loadUrl("https://git.hilyy.top")

        // 将WebView设置为Activity的内容视图，并设置LayoutParams
        setContentView(webView, ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        ))
    }

    override fun onBackPressed() {
        // 处理WebView的返回事件
        if (webView.canGoBack()) {
            webView.goBack()
        } else {
            super.onBackPressed()
        }
    }

    override fun onDestroy() {
        // 销毁WebView
        webView.destroy()
        super.onDestroy()
    }
}