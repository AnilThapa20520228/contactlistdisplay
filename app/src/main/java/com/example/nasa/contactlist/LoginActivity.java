package com.example.nasa.contactlist;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText et_username, et_password;
    Button btn_login, btn_signup;
    String username="",password="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        et_username = findViewById(R.id.et_username);
        et_password = findViewById(R.id.et_password);
        btn_login = findViewById(R.id.btn_login);
        btn_signup = findViewById(R.id.btn_signup);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                username = et_username.getText().toString();
                password = et_password.getText().toString();
                // check the values are null or empty (simply we called it as form validation)
                boolean success = true;
                if(TextUtils.isEmpty(username)){
                    et_username.setError("Username is empty");
                    success = false;
                }
                if(TextUtils.isEmpty(password)){
                    et_password.setError("Password is empty");
                    success = false;
                }
                if(success){
                    // check the username and password
                    // get the username and password from saved value
                    SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                    String userName = pref.getString("username", "");
                    String pass = pref.getString("password", "");
                    if(TextUtils.equals(username, userName) && TextUtils.equals(password, pass)){
                        // creditials matched
                        // open the contactlist page
                        Intent intent=new Intent(LoginActivity.this,ContactListActivity.class);
                        intent.putExtra("uname",username);
                        startActivity(intent);




                    }else{
                        Toast.makeText(getApplicationContext(), "Username and password not matched", Toast.LENGTH_SHORT).show();
                    }

                }
            }

        });

        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,SignupActivity.class));
            }
        });



    }
}
