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
import com.avssolutiion.autoheadshot.databinding.ActivityGamemodeBinding;

public class GamemodeActivity extends AppCompatActivity implements MaxAdListener {

    ActivityGamemodeBinding binding;

    public ProgressDialog dialog;

    //applovin ads
    private MaxInterstitialAd interstitialAd;
    private MaxNativeAdLoader nativeAdLoader;
    private MaxAd nativeAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGamemodeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        dialog = new ProgressDialog(this);
        dialog.setMessage("Loading...");
        dialog.setCancelable(false);


        interstitialAd = new MaxInterstitialAd(getString(R.string.inter),this);
        interstitialAd.setListener(this);
        interstitialAd.loadAd();



        binding.tv6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.tv6.setBackground(getDrawable(R.drawable.rigt_conners));
                binding.tv7.setBackground(getDrawable(R.drawable.blanck_back));
                binding.tv8.setBackground(getDrawable(R.drawable.blanck_back));

            }
        });
        binding.tv7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.tv6.setBackground(getDrawable(R.drawable.blanck_back));
                binding.tv7.setBackground(getDrawable(R.drawable.rigt_conners));
                binding.tv8.setBackground(getDrawable(R.drawable.blanck_back));

            }
        });
        binding.tv8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.tv6.setBackground(getDrawable(R.drawable.blanck_back));
                binding.tv7.setBackground(getDrawable(R.drawable.blanck_back));
                binding.tv8.setBackground(getDrawable(R.drawable.rigt_conners));

            }
        });

        binding.tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.tv1.setBackground(getDrawable(R.drawable.rigt_conners));
                binding.tv2.setBackground(getDrawable(R.drawable.blanck_back));


            }
        });
        binding.tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.tv1.setBackground(getDrawable(R.drawable.blanck_back));
                binding.tv2.setBackground(getDrawable(R.drawable.rigt_conners));


            }
        });

        binding.backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
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
                            Toast.makeText(GamemodeActivity.this, "Applied", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(GamemodeActivity.this,ActiviteDoneActivity.class));

                        }
                    },4000);
                }else {
                    dialog.show();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            dialog.dismiss();
                            Toast.makeText(GamemodeActivity.this, "Applied", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(GamemodeActivity.this,ActiviteDoneActivity.class));


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