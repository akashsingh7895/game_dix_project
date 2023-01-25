package com.avssolutiion.autoheadshot;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.ads.MaxInterstitialAd;
import com.applovin.mediation.nativeAds.MaxNativeAdLoader;
import com.avssolutiion.autoheadshot.databinding.ActivityStorySelectBinding;

public class StorySelectActivity extends AppCompatActivity implements MaxAdListener {

    ActivityStorySelectBinding binding;
    int number = 0;
    int value;

    public ProgressDialog dialog;

    //applovin ads
    private MaxInterstitialAd interstitialAd;
    private MaxNativeAdLoader nativeAdLoader;
    private MaxAd nativeAd;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityStorySelectBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        dialog = new ProgressDialog(this);
        dialog.setMessage("Loading...");
        dialog.setCancelable(false);


        interstitialAd = new MaxInterstitialAd(getString(R.string.inter),this);
        interstitialAd.setListener(this);
        interstitialAd.loadAd();


        value = getIntent().getIntExtra("value",0);

        if (value==1){
            binding.c1.setImageDrawable(getDrawable(R.drawable.c1));
        }else if (value==2){
            binding.c1.setImageDrawable(getDrawable(R.drawable.c2));
        }else if (value==3){
            binding.c1.setImageDrawable(getDrawable(R.drawable.c3));
        }else if (value==4){
            binding.c1.setImageDrawable(getDrawable(R.drawable.c4));
        }else if (value==5){
            binding.c1.setImageDrawable(getDrawable(R.drawable.c5));
        }else if (value==6){
            binding.c1.setImageDrawable(getDrawable(R.drawable.c6));
        }




        binding.backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        binding.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number++;
                binding.text.setText(String.valueOf(number));
            }
        });


        binding.minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (number>0){
                    number--;
                    binding.text.setText(String.valueOf(number));
                }else {
                    Toast.makeText(StorySelectActivity.this, "Please Increment story", Toast.LENGTH_SHORT).show();
                }

            }
        });


        binding.buttonActivate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (interstitialAd.isReady()){
                    interstitialAd.showAd();
                    dialog.show();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            dialog.dismiss();
                            Toast.makeText(StorySelectActivity.this, "Applied", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(StorySelectActivity.this,ActiviteDoneActivity.class));

                        }
                    },4000);
                }else {
                    dialog.show();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            dialog.dismiss();
                            Toast.makeText(StorySelectActivity.this, "Applied", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(StorySelectActivity.this,ActiviteDoneActivity.class));


                        }
                    },4000);
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