package com.example.nasa.contactlist;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity {
    EditText et_username, et_password, et_confirmpassword;
    Button btn_create;
    String username="",password="",confirmPassword="";
    SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        et_username = findViewById(R.id.et_username);
        et_password = findViewById(R.id.et_password);
        et_confirmpassword = findViewById(R.id.et_confirm_password);
        btn_create = findViewById(R.id.btn_create);

        btn_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                   username=et_username.getText().toString();
                   password=et_password.getText().toString();
                   confirmPassword=et_confirmpassword.getText().toString();

                   boolean valid=true;
                if(TextUtils.isEmpty(username)){
                    valid = false;
                    et_username.setError("Username is empty");
                }
                if(TextUtils.isEmpty(password)){
                    valid = false;
                    et_password.setError("Password is empty");
                }
                if(TextUtils.isEmpty(confirmPassword)){
                    valid = false;
                    et_confirmpassword.setError("Confirm password is empty");
                }
                if(!TextUtils.equals(password, confirmPassword)){
                    valid = false;
                    et_confirmpassword.setError("Password is not matched");
                }
                if(valid){

                    preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                    // save the value in username and password key
                    saveValue("username", username);
                    saveValue("password", password);
                    // show the message to user
                    Toast.makeText(getApplicationContext(), "New UserCreated", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
    public void saveValue(String key, String value) {
        preferences.edit().putString(key, value).commit();
    }

}
