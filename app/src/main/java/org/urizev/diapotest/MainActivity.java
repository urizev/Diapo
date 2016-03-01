package org.urizev.diapotest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;

import org.urizev.diapo.Diapo;
import org.urizev.diapo.DiapoActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.getMenuInflater().inflate(R.menu.main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_see_all) {
            this.openSlideShow();
        }
        return super.onOptionsItemSelected(item);
    }

    private void openSlideShow() {
        DisplayMetrics dm = getResources().getDisplayMetrics();
        int maxSide = Math.max(dm.widthPixels, dm.heightPixels);

        Intent intent = new Intent(this, DiapoActivity.class);
        intent.putExtra(Diapo.EXTRA_IMAGE_URLS, Data.IMAGE_URLS);
        intent.putExtra(Diapo.EXTRA_IMAGE_INDEX, 0);
        intent.putExtra(Diapo.EXTRA_WIDTH, maxSide);

        this.startActivity(intent);
    }
}
