package cn.krguang.linephonetest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.xuchongyang.easyphone.EasyLinphone;
import com.xuchongyang.easyphone.callback.PhoneCallback;
import com.xuchongyang.easyphone.callback.RegistrationCallback;

import org.linphone.core.LinphoneCall;

public class MainActivity extends AppCompatActivity {

    private String TAG = "gggg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EasyLinphone.startService(this);
        EasyLinphone.addCallback(new RegistrationCallback() {
            @Override
            public void registrationOk() {
                super.registrationOk();
                // do something
                Log.d(TAG, "registrationOk: 登录成功");
            }

            @Override
            public void registrationFailed() {
                super.registrationFailed();
                // do something
                Log.d(TAG, "registrationFailed: 登陆失败");
            }
        }, new PhoneCallback() {
            @Override
            public void incomingCall(LinphoneCall linphoneCall) {
                super.incomingCall(linphoneCall);
                // do something
            }

            @Override
            public void callConnected() {
                super.callConnected();
                // do something
            }

            @Override
            public void callEnd() {
                super.callEnd();
                // do something
            }
        });

    }

    public void login(View view) {

        // 配置 Sip 账户信息
        EasyLinphone.setAccount("1006", "123456", "192.168.18.117:5060");
        // 注册到 Sip 服务器
        EasyLinphone.login();
    }
}
