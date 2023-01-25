package com.avssolutiion.autoheadshot;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.ads.MaxInterstitialAd;
import com.applovin.mediation.nativeAds.MaxNativeAdLoader;
import com.avssolutiion.autoheadshot.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements MaxAdListener {
    ActivityMainBinding binding;
    //applovin ads
    private MaxInterstitialAd interstitialAd;
    private MaxNativeAdLoader nativeAdLoader;
    private MaxAd nativeAd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
       Drawer();


        interstitialAd = new MaxInterstitialAd(getString(R.string.inter),this);
        interstitialAd.setListener(this);
        interstitialAd.loadAd();

       binding.img1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               if (interstitialAd.isReady()){
                   interstitialAd.showAd();
                   startActivity(new Intent(MainActivity.this,StoryActivity.class));

               }else {
                   startActivity(new Intent(MainActivity.this,StoryActivity.class));

               }
           }
       });

        binding.img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (interstitialAd.isReady()){
                    interstitialAd.showAd();
                    startActivity(new Intent(MainActivity.this,GamemodeActivity.class));

                }else {
                    startActivity(new Intent(MainActivity.this,GamemodeActivity.class));

                }

            }
        });

        binding.img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (interstitialAd.isReady()){
                    interstitialAd.showAd();
                    startActivity(new Intent(MainActivity.this,AutoMaticActivity.class));

                }else {
                    startActivity(new Intent(MainActivity.this,AutoMaticActivity.class));

                }

            }
        });


    }
    private void Drawer(){
        this.binding.navLeft.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            public boolean onNavigationItemSelected(MenuItem menuItem) {


                switch (menuItem.getItemId()) {

                    case R.id.share:

                        try {
                            Intent shareIntent = new Intent(Intent.ACTION_SEND);
                            shareIntent.setType("text/plain");
                            shareIntent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.app_name));
                            String shareMessage= "";
                            shareMessage = shareMessage + "https://play.google.com/store/apps/details?id="+getPackageName();
                            shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
                            startActivity(Intent.createChooser(shareIntent, "choose one"));
                        } catch(Exception e) {
                            //e.toString();
                        }

                        break;

                    case R.id.rates:

                        try{
                            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id="+getPackageName())));
                        }
                        catch (ActivityNotFoundException e){
                            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id="+getPackageName())));
                        }

                        break;


                    case R.id.PrivacyPolicy:

                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.privacy_policy)));
                        startActivity(browserIntent);
                        break;

                    case R.id.contact:

                        Intent i = new Intent(Intent.ACTION_SEND);
                        i.setType("message/rfc822");
                        i.putExtra(Intent.EXTRA_EMAIL  , new String[]{getString(R.string.supported_email)});
                        i.putExtra(Intent.EXTRA_SUBJECT, "subject of email");
                        i.putExtra(Intent.EXTRA_TEXT   , "body of email");
                        try {
                            startActivity(Intent.createChooser(i, "Send mail..."));
                        } catch (android.content.ActivityNotFoundException ex) {
                            Toast.makeText(MainActivity.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
                        }

                        break;


                }

                return true;
            }
        });
        this.binding.imgDrawerController.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MainActivity.this.binding.dl.openDrawer(Gravity.LEFT);
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