package com.mocedesenhos.aadpp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.mocedesenhos.aadpp.QuickHelp.QuickHelp;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SplashScreen extends AppCompatActivity {


    @BindView(R.id.SplahScreenMainLogo)
    ImageView SplashScreenMainLogo;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this); //Bind Activity with ButterKnife
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);//Make activity full screen
        SplashScreenMainLogo.setAnimation(AnimationUtils.loadAnimation(this,R.anim.bounce));//Apply animation to imageView


        //  startAnimation();
        QuickHelp.GotoActivityWithTimer(this, HomeScreen.class);



    }
}