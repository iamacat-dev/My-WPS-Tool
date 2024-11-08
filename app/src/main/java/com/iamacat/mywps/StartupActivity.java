package com.iamacat.mywps;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class StartupActivity extends AppCompatActivity {

    private CustomViewPager viewPager;
    private OnboardingAdapter onboardingAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_startup);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        SharedPreferences sharedPreferences = getSharedPreferences("onboardingPrefs", MODE_PRIVATE);
        boolean isOnBoardingCompleted = sharedPreferences.getBoolean("isBoardingCompleted", false);

        if (isOnBoardingCompleted) {
            startActivity(new Intent(StartupActivity.this, MainActivity.class));
            finish();
            return;
        }

        viewPager = findViewById(R.id.viewPager);
        onboardingAdapter = new OnboardingAdapter(getSupportFragmentManager());
        viewPager.setAdapter(onboardingAdapter);
    }

    @Override
    public void onBackPressed() {
        if (viewPager.getCurrentItem() > 0) {
            viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
        } else {
            super.onBackPressed();
        }
    }
}