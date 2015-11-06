package org.urizev.diapo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import org.urizev.diapo.DiapoFragment;

import java.util.ArrayList;

/**
 * Created by jcvallejo on 6/11/15.
 */
public class DiapoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ArrayList<String> urls = getIntent().getStringArrayListExtra(DiapoFragment.EXTRA_IMAGE_URLS);
        int index = getIntent().getIntExtra(DiapoFragment.EXTRA_IMAGE_INDEX, -1);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(android.R.id.content, DiapoFragment.newInstance(urls, index))
                    .commit();
        }
    }
}
