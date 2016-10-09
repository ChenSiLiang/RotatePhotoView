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
public class SinglePhotoViewFragment extends Fragment {
    private PhotoView mPhotoView;
    private PhotoViewAttacher mAttacher;

    public SinglePhotoViewFragment() {
        // Required empty public constructor
    }

    public static SinglePhotoViewFragment newInstance() {
        return new SinglePhotoViewFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setRetainInstance(true);
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_single, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        mPhotoView = (PhotoView) view.findViewById(R.id.photoview);
        mAttacher = new PhotoViewAttacher(mPhotoView);
        mAttacher.setRotatable(true);
        mAttacher.setToRightAngle(true);
        mPhotoView.setOnRotateListener(new PhotoViewAttacher.OnRotateListener() {
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
