package com.chensl.rotatephotoview.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chensl.rotatephotoview.R;

import uk.co.senab.photoview.PhotoView;
import uk.co.senab.photoview.PhotoViewAttacher;

/**
 * single RotatePhototView Demo
 */
public class PhotoViewFragment extends Fragment {
    private PhotoViewAttacher mAttacher;

    public PhotoViewFragment() {
        // Required empty public constructor
    }

    public static PhotoViewFragment newInstance() {
        PhotoViewFragment fragment = new PhotoViewFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_photoview, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        PhotoView photoView = (PhotoView) view.findViewById(R.id.photoview);
        mAttacher = new PhotoViewAttacher(photoView);
        mAttacher.setRotatable(true);
        photoView.setOnViewRotateListener(new PhotoViewAttacher.OnViewRotateListener() {
            @Override
            public void onRotate(int degree) {
                //do something
            }
        });
    }

    @Override
    public void onDestroyView() {
        mAttacher.cleanup();
        super.onDestroyView();
    }
}
