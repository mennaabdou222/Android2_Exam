package com.example.android2exam;

import android.os.Bundle;
import android.widget.Button;
import android.widget.PopupMenu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class ModeActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager2 viewPager;
    Button setMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mode);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tabLayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.view_pager);
        setMode = findViewById(R.id.set_mode);

        PagerAdapter adapter = new PagerAdapter(this);
        viewPager.setAdapter(adapter);

        String[] titles = {"First", "Second", "Third"};

        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) -> tab.setText(titles[position])
        ).attach();

        setMode.setOnClickListener(v -> {

            PopupMenu popup = new PopupMenu(this, setMode);

            popup.getMenu().add("Light");
            popup.getMenu().add("Night");
            popup.getMenu().add("System");

            popup.setOnMenuItemClickListener(item -> {

                switch (item.getTitle().toString()) {

                    case "Light":
                        AppCompatDelegate.setDefaultNightMode(
                            AppCompatDelegate.MODE_NIGHT_NO);
                        break;

                    case "Night":
                        AppCompatDelegate.setDefaultNightMode(
                            AppCompatDelegate.MODE_NIGHT_YES);
                        break;

                    case "System":
                        AppCompatDelegate.setDefaultNightMode(
                            AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
                        break;
                }

                return true;
            });

            popup.show();
        });
    }

    @Override
    public void onBackPressed() {

        if (viewPager.getCurrentItem() != 0) {
            viewPager.setCurrentItem(0);
        } else {
            finish();
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
