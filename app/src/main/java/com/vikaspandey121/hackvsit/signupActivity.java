package com.vikaspandey121.hackvsit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class signupActivity extends AppCompatActivity {
    FirebaseAuth firebaseAuth;
    ProgressDialog progressDialog;
    TextInputLayout username,signemail,signpassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        firebaseAuth = FirebaseAuth.getInstance();


        Button btn = findViewById(R.id.signup);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signemail = findViewById(R.id.signupEmail);
                signpassword=findViewById(R.id.signpassword);
               // String name = username.getEditText().getText().toString();
                //String email=signemail.getEd
                String email = signemail.getEditText().getText().toString();
                String password = signpassword.getEditText().getText().toString();



                    if(!email.equalsIgnoreCase(""))
                    {
                        if(!password.equalsIgnoreCase(""))
                        {
                            registerUser(email,password);

                        }
                        else
                        {

                            Toast.makeText(signupActivity.this, "Please Enter Password", Toast.LENGTH_SHORT).show();
                        }
                    }


            }
        });
            }
    public void registerUser(final String email,String password){

       // progressDialog.setMessage("Please wait...");
        //progressDialog.show();

        firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(task.isSuccessful()){

                 //   progressDialog.dismiss();
                    //databaseuser.child("USER").setValue(name);


                    Toast.makeText(signupActivity.this, "User is Registered Successfully", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(signupActivity.this,loginActivity.class);
                    startActivity(intent);
                    finish();
                }
                else{
                  //  progressDialog.dismiss();
                    Toast.makeText(signupActivity.this, "Error registering user", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    }
