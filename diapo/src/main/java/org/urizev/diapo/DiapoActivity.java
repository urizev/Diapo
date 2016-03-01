package org.urizev.diapo;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by jcvallejo at 6/11/15.
 */
public class DiapoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int flags = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            flags |= View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_FULLSCREEN;
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            flags |= View.SYSTEM_UI_FLAG_IMMERSIVE
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        }

        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(flags);

        ArrayList<String> urls = getIntent().getStringArrayListExtra(Diapo.EXTRA_IMAGE_URLS);
        int index = getIntent().getIntExtra(Diapo.EXTRA_IMAGE_INDEX, -1);
        int width = getIntent().getIntExtra(Diapo.EXTRA_WIDTH, 0);
        int heigth = getIntent().getIntExtra(Diapo.EXTRA_HEIGHT, 0);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(android.R.id.content, DiapoFragment.newInstance(urls, index, width, heigth))
                    .commit();
        }
    }
}
