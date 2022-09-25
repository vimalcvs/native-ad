package com.vimalcvs.ads;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.google.android.gms.ads.AdView;
import com.vimalcvs.ads.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        loadBanner();
        loadNativeSmall();
        loadNativeMedium();
    }

    private void loadBanner() {
        AdView adView = new AdView(this);
        AdManager.displayBanner(this, adView, binding.bannerContainer);
    }

    private void loadNativeSmall() {
        AdManager.showNativeSmall(this, binding.nativeSmall);
    }
    private void loadNativeMedium() {
        AdManager.showNativeMedium(this, binding.nativeMedium);
    }

}