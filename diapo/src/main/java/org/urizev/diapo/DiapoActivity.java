package org.urizev.diapo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

/**
 * Created by jcvallejo on 6/11/15.
 */
public class DiapoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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
