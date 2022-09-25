package com.vimalcvs.ads;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;


public class AdManager {


    public static void displayBanner(Activity context , AdView adView , FrameLayout adContainerView){
        adView.setAdUnitId(context.getString(R.string.ad_banner));
        adContainerView.removeAllViews();
        adContainerView.addView(adView);
        AdSize adSize = getAdSize(context , adContainerView);
        adView.setAdSize(adSize);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
    }

    private static AdSize getAdSize(Activity context , FrameLayout adContainerView) {
        Display display = context.getWindowManager().getDefaultDisplay();
        DisplayMetrics outMetrics = new DisplayMetrics();
        display.getMetrics(outMetrics);
        float density = outMetrics.density;
        float adWidthPixels = adContainerView.getWidth();
        if (adWidthPixels == 0) {
            adWidthPixels = outMetrics.widthPixels;
        }
        int adWidth = (int) (adWidthPixels / density);
        return AdSize.getCurrentOrientationAnchoredAdaptiveBannerAdSize(context, adWidth);
    }



    public static void showNativeSmall(Context context , NativeSmall template){
        template.setVisibility(View.GONE);
        AdLoader adLoader = new AdLoader.Builder(context, context.getString(R.string.ad_native))
                .forNativeAd(nativeAd -> {
                    template.setNativeAd(nativeAd);
                    template.setVisibility(View.VISIBLE);
                })
                .withAdListener(new AdListener() {
                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError adError) {
                        template.setVisibility(View.GONE);
                    }
                })
                .build();
        adLoader.loadAd(new AdRequest.Builder().build());
    }



    public static void showNativeMedium(Context context , NativeMedium template){
        template.setVisibility(View.GONE);
        AdLoader adLoader = new AdLoader.Builder(context, context.getString(R.string.ad_native))
                .forNativeAd(nativeAd -> {
                    template.setNativeAd(nativeAd);
                    template.setVisibility(View.VISIBLE);

                })
                .withAdListener(new AdListener() {
                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError adError) {
                        template.setVisibility(View.GONE);
                    }
                })
                .build();
        adLoader.loadAd(new AdRequest.Builder().build());
    }
}
