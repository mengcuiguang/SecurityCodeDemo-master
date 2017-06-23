# SecurityCodeDemo-master
炫酷的验证码 认证

使用方法：

1、布局文件
<com.meng.securitycodedemo.SecurityCodeView
    android:layout_width="match_parent"
    android:layout_height="wrap_content"/>
    
2、MainActivity 实现接口 SecurityCodeView.InputCompleteListener

editText = (SecurityCodeView) findViewById(R.id.scv_edittext);
editText.setInputCompleteListener(this);

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

