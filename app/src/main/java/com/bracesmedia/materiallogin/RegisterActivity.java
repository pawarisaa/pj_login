package com.bracesmedia.materiallogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {
    EditText username, userpassword, useremail, usercontact;
    Button btnRegister;

    private static final String registerUrl = "http//10.199.120.100/login-register/registeruser.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        username = findViewById(R.id.regUsername);
        userpassword = findViewById(R.id.regUserPassword);
        useremail = findViewById(R.id.regUserEmail);
        usercontact = findViewById(R.id.regUserContactNO);

        btnRegister = findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registernewuser();
            }
        });
    }

    private void registernewuser() {
        StringRequest request = new StringRequest(Request.Method.POST, registerUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(response.contains("successs")){
                    Toast.makeText(getApplicationContext(),"Succecss Register ",Toast.LENGTH_LONG).show();
                    Intent intent=new Intent(RegisterActivity.this,MainActivity.class);

                    startActivity(intent);
                }else {
                    Toast.makeText(getApplicationContext(),"Error Register",Toast.LENGTH_SHORT).show();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("registeruser","true");
                params.put("username", username.getText().toString().trim());
                params.put("userpassword", userpassword.getText().toString().trim());
                params.put("useremail",useremail.getText().toString().trim());
                params.put("usercontact", usercontact.getText().toString().trim());

                return params;
            }
        };
        Volley.newRequestQueue(this).add(request);
    }
}
