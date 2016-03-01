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

/**
 * Created by jcvallejo on 5/11/15.
 */
public class DiapoFragment extends DialogFragment {

    private ViewPager mPager;
    private DiapoPagerAdapter mAdapter;
    private ArrayList<String> mUrls;
    private int mWidth;
    private int mHeight;

    public static Fragment newInstance(ArrayList<String> urls, int index, int width, int heigth) {
        Fragment fragment = new DiapoFragment();

        Bundle args = new Bundle();
        args.putStringArrayList(Diapo.EXTRA_IMAGE_URLS, urls);
        args.putInt(Diapo.EXTRA_IMAGE_INDEX, index);
        args.putInt(Diapo.EXTRA_WIDTH, width);
        args.putInt(Diapo.EXTRA_HEIGHT, heigth);

        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mUrls = getArguments().getStringArrayList(Diapo.EXTRA_IMAGE_URLS);
        mWidth = getArguments().getInt(Diapo.EXTRA_WIDTH, 0);
        mHeight = getArguments().getInt(Diapo.EXTRA_HEIGHT, 0);
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
            return ZoomImageFragment.newInstance (mUrls.get(position), mWidth, mHeight);
        }

        @Override
        public int getCount() {
            return mUrls.size();
        }
    }
}
