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
import com.avssolutiion.autoheadshot.databinding.ActivityActiviteDoneBinding;
import com.avssolutiion.autoheadshot.databinding.ActivityAutoMaticBinding;

public class AutoMaticActivity extends AppCompatActivity implements MaxAdListener {

    ActivityAutoMaticBinding binding;

    public ProgressDialog dialog;

    //applovin ads
    private MaxInterstitialAd interstitialAd;
    private MaxNativeAdLoader nativeAdLoader;
    private MaxAd nativeAd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_matic);
        binding = ActivityAutoMaticBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        dialog = new ProgressDialog(this);
        dialog.setMessage("Loading...");
        dialog.setCancelable(false);


        interstitialAd = new MaxInterstitialAd(getString(R.string.inter),this);
        interstitialAd.setListener(this);
        interstitialAd.loadAd();


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
                            Toast.makeText(AutoMaticActivity.this, "Applied", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(AutoMaticActivity.this,ActiviteDoneActivity.class));

                        }
                    },4000);
                }else {
                    dialog.show();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            dialog.dismiss();
                            Toast.makeText(AutoMaticActivity.this, "Applied", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(AutoMaticActivity.this,ActiviteDoneActivity.class));


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