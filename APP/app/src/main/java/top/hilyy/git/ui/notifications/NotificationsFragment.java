package top.hilyy.git.ui.notifications;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import top.hilyy.git.R;
import top.hilyy.git.databinding.FragmentNotificationsBinding;

public class NotificationsFragment extends Fragment {

    private WebView mWebView;
    private ProgressBar mProgressBar;

    private static final String URL = "https://git.hilyy.top/APP/IM/index.html";
    private static final String JAVASCRIPT_ENABLED = "javascript_enabled";

    @NonNull
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FragmentNotificationsBinding binding = FragmentNotificationsBinding.inflate(inflater, container, false);

        initViews(binding.getRoot());
        setupWebView();

        return binding.getRoot();
    }

    private void initViews(View root) {
        mWebView = root.findViewById(R.id.wv_webview);
        mProgressBar = root.findViewById(R.id.progress_bar);
    }

    private void setupWebView() {
        if (mWebView == null || mProgressBar == null) {
            return;
        }

        // 设置 WebView 客户端
        mWebView.setWebViewClient(new MyWebViewClient());

        // 开启 JavaScript 支持（可选）
        mWebView.getSettings().setJavaScriptEnabled(true);

        // 加载网页
        mWebView.loadUrl(URL);
    }

    private class MyWebViewClient extends WebViewClient {
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);

            if (mProgressBar != null) {
                // 显示 ProgressBar 动画
                mProgressBar.setVisibility(View.VISIBLE);
            }
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);

            if (mProgressBar != null) {
                // 隐藏 ProgressBar 动画
                mProgressBar.setVisibility(View.GONE);
            }
        }
    }
}
