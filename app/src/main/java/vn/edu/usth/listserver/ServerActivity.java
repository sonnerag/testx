package vn.edu.usth.listserver;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import vn.edu.usth.chatbox.R;

public class ServerActivity extends AppCompatActivity {
    private ViewPager viewpager;
    private PagerAdapter pageradapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listserver_activityserver);

        PagerAdapter adapter = new HomeFragmentPagerAdapter(
                getSupportFragmentManager());
        ViewPager pager = (ViewPager) findViewById(R.id.pager);

        pager.setOffscreenPageLimit(3);
        pager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab);
        tabLayout.setupWithViewPager(pager);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.server1), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Toolbar toolbar = findViewById(R.id.server_back);
        setSupportActionBar(toolbar);

        // Load the icon and resize it
        Drawable backIcon = getResources().getDrawable(R.drawable.back);
        backIcon.setBounds(0, 0, 50, 50); // Set the size here (width, height)


        // Set the resized icon
        toolbar.setNavigationIcon(backIcon);
        toolbar.setNavigationOnClickListener(v -> finish());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu,menu);
        return true;
    }

//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        int id = item.getItemId();
//        if (id == R.id.back_button) {
//            finish();
//        }
//        return true;
//    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("OnStart", "start");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("OnResume", "resume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("OnPause", "pause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("OnStop", "stop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("OnDestroy", "destroy");
    }
}
