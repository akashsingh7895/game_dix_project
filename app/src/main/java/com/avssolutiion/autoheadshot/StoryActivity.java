package com.avssolutiion.autoheadshot;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.ads.MaxInterstitialAd;
import com.applovin.mediation.nativeAds.MaxNativeAdLoader;
import com.avssolutiion.autoheadshot.databinding.ActivityStoryBinding;

public class StoryActivity extends AppCompatActivity implements MaxAdListener {

    ActivityStoryBinding binding;
    //applovin ads
    private MaxInterstitialAd interstitialAd;
    private MaxNativeAdLoader nativeAdLoader;
    private MaxAd nativeAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityStoryBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


//        dialog = new ProgressDialog(this);
//        dialog.setMessage("Loading...");
//        dialog.setCancelable(false);


        interstitialAd = new MaxInterstitialAd(getString(R.string.inter),this);
        interstitialAd.setListener(this);
        interstitialAd.loadAd();


        binding.backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        binding.c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (interstitialAd.isReady()){
                    interstitialAd.showAd();
                    Intent intent = new Intent(StoryActivity.this,StorySelectActivity.class);
                    intent.putExtra("value",1);
                    startActivity(intent);
                }else {
                    Intent intent = new Intent(StoryActivity.this,StorySelectActivity.class);
                    intent.putExtra("value",1);
                    startActivity(intent);
                }


            }
        });

        binding.c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (interstitialAd.isReady()){
                    interstitialAd.showAd();
                    Intent intent = new Intent(StoryActivity.this,StorySelectActivity.class);
                    intent.putExtra("value",2);
                    startActivity(intent);
                }else {
                    Intent intent = new Intent(StoryActivity.this,StorySelectActivity.class);
                    intent.putExtra("value",2);
                    startActivity(intent);
                }


            }
        });


        binding.c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                if (interstitialAd.isReady()){
                    interstitialAd.showAd();
                    Intent intent = new Intent(StoryActivity.this,StorySelectActivity.class);
                    intent.putExtra("value",3);
                    startActivity(intent);
                }else {
                    Intent intent = new Intent(StoryActivity.this,StorySelectActivity.class);
                    intent.putExtra("value",3);
                    startActivity(intent);
                }


            }
        });

        binding.c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (interstitialAd.isReady()){
                    interstitialAd.showAd();
                    Intent intent = new Intent(StoryActivity.this,StorySelectActivity.class);
                    intent.putExtra("value",4);
                    startActivity(intent);
                }else {
                    Intent intent = new Intent(StoryActivity.this,StorySelectActivity.class);
                    intent.putExtra("value",4);
                    startActivity(intent);
                }


            }
        });

        binding.c5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                if (interstitialAd.isReady()){
                    interstitialAd.showAd();
                    Intent intent = new Intent(StoryActivity.this,StorySelectActivity.class);
                    intent.putExtra("value",5);
                    startActivity(intent);
                }else {
                    Intent intent = new Intent(StoryActivity.this,StorySelectActivity.class);
                    intent.putExtra("value",5);
                    startActivity(intent);
                }


            }
        });

        binding.c6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                if (interstitialAd.isReady()){
                    interstitialAd.showAd();
                    Intent intent = new Intent(StoryActivity.this,StorySelectActivity.class);
                    intent.putExtra("value",6);
                    startActivity(intent);
                }else {
                    Intent intent = new Intent(StoryActivity.this,StorySelectActivity.class);
                    intent.putExtra("value",6);
                    startActivity(intent);
                }


            }
        });





    }

    @Override
    public void onAdLoaded(MaxAd ad) {

    }

    @Override
    public void onAdDisplayed(MaxAd ad) {

    }

    @Override
    public void onAdHidden(MaxAd ad) {

    }

    @Override
    public void onAdClicked(MaxAd ad) {

    }

    @Override
    public void onAdLoadFailed(String adUnitId, MaxError error) {

    }

    @Override
    public void onAdDisplayFailed(MaxAd ad, MaxError error) {

    }
}