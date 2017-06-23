package com.meng.securitycodedemo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SecurityCodeView.InputCompleteListener {

    private SecurityCodeView editText;
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initListener();
    }

    private void initView() {
        editText = (SecurityCodeView) findViewById(R.id.scv_edittext);
        text = (TextView) findViewById(R.id.tv_text);
    }

    private void initListener() {
        editText.setInputCompleteListener(this);
    }

    @Override
    public void inputComplete() {
        Toast.makeText(getApplicationContext(), "验证码是：" + editText.getEditContent(), Toast.LENGTH_LONG).show();

        if (!editText.getEditContent().equals("123456")) {
            text.setText("验证码输入错误");
            text.setTextColor(Color.RED);
        }
    }

    @Override
    public void deleteContent(boolean isDelete) {
        if (isDelete){
            text.setText("输入验证码表示同意《用户协议》");
            text.setTextColor(Color.BLACK);
        }
    }
}
