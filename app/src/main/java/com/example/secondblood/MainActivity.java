package com.example.secondblood;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.concurrent.Callable;

public class MainActivity extends AppCompatActivity {

    private static EditText et_username;
    private static EditText et_password;
    private String key;
    private int i=0;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
                if (resultCode == RESULT_OK) {
                    String returnData1 = data.getStringExtra("data1");
                    String returnData2 = data.getStringExtra("data2");
                    Log.d("a", returnData1);
                    et_username.setText(returnData1);
                    et_password.setText(returnData2);
                } else if (resultCode == RESULT_CANCELED) {
                    String returnData1 = data.getStringExtra("data3");
                    String returnData2 = data.getStringExtra("data4");
                    Log.d("a", returnData1);
                    et_username.setText(returnData1);
                    et_password.setText(returnData2);
                }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_username = (EditText) findViewById(R.id.editText1);
        et_password = (EditText) findViewById(R.id.editText2);
        Button bt_register = (Button) findViewById(R.id.button6);
        Button bt_login = (Button) findViewById(R.id.button1);
        Button bt_forget = (Button) findViewById(R.id.button4);
        CheckBox checkbox = (CheckBox) findViewById(R.id.checkBox);
        CheckBox checkboxpass = (CheckBox) findViewById(R.id.checkBox2);

        checkboxpass.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    //如果选中，显示密码
                    et_password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }else{
                    //否则隐藏密码
                    et_password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });

        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = et_username.getText().toString().trim();
                String password = et_password.getText().toString().trim();

                SharedPreferences sp = getSharedPreferences("user_data", MODE_PRIVATE);
                key = sp.getString(username, "");

                switch (v.getId()) {
                    case R.id.button1:
                        if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
                            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                            startActivity(intent);
                            Toast.makeText(MainActivity.this, "账号和密码不能为空", Toast.LENGTH_LONG).show();
                        } else if (checkbox.isChecked()) {
                               if (TextUtils.isEmpty(key)){
                            Toast.makeText(MainActivity.this, "账号不存在", Toast.LENGTH_SHORT).show();
                               }else if(key.equals(password)){
                            Intent intent = new Intent(MainActivity.this, Firstpage.class);
                            startActivity(intent);
                            Toast.makeText(MainActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                               }else {
                            Toast.makeText(MainActivity.this, "密码错误", Toast.LENGTH_SHORT).show();
                               }
                        } else {
                            Toast.makeText(MainActivity.this, "请先同意用户协议", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    default:
                        break;
                }
            }
        });

        bt_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Register.class);
                startActivity(intent);
            }
        });

        bt_forget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Forget.class);
                startActivityForResult(intent, 1);
            }
        });

    }
}