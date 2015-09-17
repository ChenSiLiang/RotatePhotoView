package com.chensl.rotatephotoview.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.chensl.rotatephotoview.R;

import uk.co.senab.photoview.PhotoView;
import uk.co.senab.photoview.PhotoViewAttacher;

/**
 * single RotatePhototView Demo
 */
public class SinglePhotoViewFragment extends Fragment {
    PhotoView photoView;
    private PhotoViewAttacher mAttacher;

    public SinglePhotoViewFragment() {
        // Required empty public constructor
    }

    public static SinglePhotoViewFragment newInstance() {
        SinglePhotoViewFragment fragment = new SinglePhotoViewFragment();
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
        return inflater.inflate(R.layout.fragment_single, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        photoView = (PhotoView) view.findViewById(R.id.photoview);
        mAttacher = new PhotoViewAttacher(photoView);
        mAttacher.setRotatable(true);
        mAttacher.setToRightAngle(true);
        photoView.setOnRotateListener(new PhotoViewAttacher.OnRotateListener() {
            @Override
            public void onRotate(int degree) {
                //do something
            }
        });
        Button resetBtn = (Button) view.findViewById(R.id.reset_btn);
        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                photoView.reset();
            }
        });
    }

    @Override
    public void onDestroyView() {
        mAttacher.cleanup();
        super.onDestroyView();
    }
}
