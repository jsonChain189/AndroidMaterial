package com.example.pagedesign1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pagedesign1.connection.SharedPrefManager;
import com.example.pagedesign1.model.User;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView id,userName,userEmail,gender;
    Button btnLogout;

    // Animation setup
    Animation zoom;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        zoom = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom);
        img = findViewById(R.id.image);
        img.startAnimation(zoom);

        Handler h = new Handler();
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(i);
                finish();
            }
        },4000);


//        setContentView(R.layout.activity_main);
//
//        if(SharedPrefManager.getInstance(this).isLoggedIn()){
//            id = findViewById(R.id.textViewId);
//            userName = findViewById(R.id.textViewUsername);
//            userEmail = findViewById(R.id.textViewEmail);
//            gender = findViewById(R.id.textViewGender);
//            btnLogout = findViewById(R.id.buttonLogout);
//            User user = SharedPrefManager.getInstance(this).getUser();
//
//            id.setText(String.valueOf(user.getId()));
//            userEmail.setText(user.getEmail());
//            gender.setText(user.getGender());
//            userName.setText(user.getName());
//
//            btnLogout.setOnClickListener(this);
//        }
//        else{
//            Intent intent = new Intent(MainActivity.this,LoginActivity.class);
//            startActivity(intent);
//            finish();
//        }
    }

    @Override
    public void onClick(View v) {
        if(v.equals(btnLogout)){
            SharedPrefManager.getInstance(getApplicationContext()).logout();
        }
    }
}