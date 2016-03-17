package org.urizev.diapotest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;

import org.urizev.diapo.Diapo;
import org.urizev.diapo.DiapoActivity;

public class MainActivity extends AppCompatActivity implements DiapoTestAdapter.DiapoTestAdapterListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recycler = (RecyclerView) findViewById(R.id.recycler);
        if (recycler != null) {
            recycler.setAdapter(new DiapoTestAdapter(this));
        }
    }

    @Override
    public void onImageClicked(String link) {
        DisplayMetrics dm = getResources().getDisplayMetrics();
        int maxSide = Math.max(dm.widthPixels, dm.heightPixels);

        Intent intent = new Intent(this, DiapoActivity.class);
        intent.putExtra(Diapo.EXTRA_IMAGE_URLS, Data.IMAGE_URLS);
        intent.putExtra(Diapo.EXTRA_IMAGE_INDEX, Data.IMAGE_URLS.indexOf(link));
        intent.putExtra(Diapo.EXTRA_WIDTH, maxSide);

        this.startActivity(intent);
    }
}
