package com.vikaspandey121.hackvsit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.app.DirectAction;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class loginActivity extends AppCompatActivity {
    Button callSignUp;
    Button login_btn;
    ImageView image;
    TextView logotext;
    TextInputLayout username,password;
    String email,pass;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();


        callSignUp = findViewById(R.id.signup_screen);
        image= findViewById(R.id.logoimage);
        logotext= findViewById(R.id.logoname);
        username= findViewById(R.id.signupusername);
        password= findViewById(R.id.signuppassword);
        login_btn= findViewById(R.id.login);
       login_btn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
                email = username.getEditText().getText().toString();
                pass = password.getEditText().getText().toString();
               mAuth.signInWithEmailAndPassword(email,pass)
                       .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                           @Override
                           public void onComplete(@NonNull Task<AuthResult> task) {
                               if(task.isSuccessful()){
                                   Toast.makeText(loginActivity.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                                   Intent intent = new Intent(loginActivity.this, Dashboard.class);
                                   startActivity(intent);
                                   finish();

                               }else{
                                   Toast.makeText(loginActivity.this, "erROR", Toast.LENGTH_SHORT).show();
                               }
                           }
                       });
           }
       });


        callSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View View) {
                Intent intent =new Intent ( loginActivity.this,signupActivity.class);
                Pair[] pairs = new Pair[6];
                pairs[0] =new Pair<View,String>(image,"logo_image");
                pairs[1] =new Pair<View,String>(logotext,"logo_text");
                pairs[2] =new Pair<View,String>(username,"username_tran");
                pairs[3] =new Pair<View,String>(password,"password_tran");
                pairs[4] =new Pair<View,String>(login_btn,"button_tran");
                pairs[5] =new Pair<View,String>(callSignUp,"login_signup_tran");

                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(loginActivity.this,pairs);
                    startActivity(intent,options.toBundle());

                }
            }
        });
    }


}
