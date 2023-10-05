package top.hilyy.git.ui.notifications;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NotificationsViewModel extends ViewModel {
    private final MutableLiveData<String> mText;
    public NotificationsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("首页");
    }
    public LiveData<String> getText() {
        return mText;
    }
}

