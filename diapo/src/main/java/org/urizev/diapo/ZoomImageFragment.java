package org.urizev.diapo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import org.urizev.diapo.view.ZoomImageView;

import uk.co.senab.photoview.PhotoViewAttacher;

/**
 * Created by jcvallejo on 5/11/15.
 */
public class ZoomImageFragment extends Fragment implements Callback {
    private static final String EXTRA_IMAGE_URL = "url";
    private ZoomImageView mZoomImage;
    private PhotoViewAttacher mAttacher;

    public static Fragment newInstance(String url) {
        Fragment fragment = new ZoomImageFragment();

        Bundle args = new Bundle();
        args.putString(EXTRA_IMAGE_URL, url);
        fragment.setArguments(args);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.mZoomImage = new ZoomImageView(getActivity());

        this.mAttacher = new PhotoViewAttacher(mZoomImage);

        return mZoomImage;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        int w = getResources().getDisplayMetrics().widthPixels;
        int h = getResources().getDisplayMetrics().heightPixels;
        String url = getArguments().getString(EXTRA_IMAGE_URL);
        Picasso.with(getActivity())
                .load(url)
                .resize(w, 0)
                .into(this.mZoomImage, this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mAttacher.cleanup();
    }

    @Override
    public void onSuccess() {
        this.mAttacher.update();
    }

    @Override
    public void onError() {

    }
}
