package top.hilyy.git.ui.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import top.hilyy.git.R;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import top.hilyy.git.databinding.FragmentNotificationsBinding;

public class NotificationsFragment extends Fragment {

    private WebView mWebView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        FragmentNotificationsBinding binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // 获取 WebView 控件
        mWebView = root.findViewById(R.id.wv_webview);

        // 设置 WebView 客户端
        mWebView.setWebViewClient(new WebViewClient());

        // 开启 JavaScript 支持（可选）
        mWebView.getSettings().setJavaScriptEnabled(true);

        // 加载网页
        mWebView.loadUrl("https://git.hilyy.top/APP/IM/index.html");

        return root;
    }
}
