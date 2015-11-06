package org.urizev.diapo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jcvallejo on 5/11/15.
 */
public class DiapoFragment extends DialogFragment {
    public static final String EXTRA_IMAGE_URLS = "imageUrls";
    public static final String EXTRA_IMAGE_INDEX = "imageIndex";

    private ViewPager mPager;
    private DiapoPagerAdapter mAdapter;
    private ArrayList<String> mUrls;

    public static Fragment newInstance (ArrayList<String> urls, int index) {
        Fragment fragment = new DiapoFragment();

        Bundle args = new Bundle();
        args.putStringArrayList(EXTRA_IMAGE_URLS, urls);
        args.putInt(EXTRA_IMAGE_INDEX, index);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mUrls = getArguments().getStringArrayList(EXTRA_IMAGE_URLS);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_diapo, container, false);

        this.mPager = (ViewPager) view.findViewById(R.id.fragment_diapo_pager);

        this.mAdapter = new DiapoPagerAdapter (getChildFragmentManager());

        this.mPager.setAdapter(mAdapter);

        return view;
    }

    private class DiapoPagerAdapter extends FragmentStatePagerAdapter {
        public DiapoPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return ZoomImageFragment.newInstance (mUrls.get(position));
        }

        @Override
        public int getCount() {
            return mUrls.size();
        }
    }
}
