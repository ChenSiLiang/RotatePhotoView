package com.chensl.rotatephotoview.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chensl.rotatephotoview.R;

import uk.co.senab.photoview.PhotoView;
import uk.co.senab.photoview.PhotoViewAttacher;

/**
 * ViewPager RotatePhototView Demo
 */
public class ViewPagerPhotoViewFragment extends Fragment {
    private static final int[] sDrawables = {R.drawable.ic_bg, R.drawable.ic_bg1, R.drawable.ic_bg2,
            R.drawable.ic_bg3};
    private ViewPager mViewPager;
    private ViewPagerAdapter mAdapter;

    public ViewPagerPhotoViewFragment() {
        // Required empty public constructor
    }

    public static ViewPagerPhotoViewFragment newInstance() {
        ViewPagerPhotoViewFragment fragment = new ViewPagerPhotoViewFragment();
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
        return inflater.inflate(R.layout.fragment_viewpager, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        mViewPager = (ViewPager) view.findViewById(R.id.viewpager);
        mAdapter = new ViewPagerAdapter();
        mViewPager.setAdapter(mAdapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    /**
     * A  adapter for ViewPager
     */
    private class ViewPagerAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return sDrawables.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            PhotoView photoView = new PhotoView(container.getContext());
            photoView.setImageResource(sDrawables[position]);
            PhotoViewAttacher attacher = new PhotoViewAttacher(photoView);
            attacher.setRotatable(true);
            attacher.setOnRotateListener(new PhotoViewAttacher.OnRotateListener() {
                @Override
                public void onRotate(int degree) {
                    //do something
                }
            });
            // Now just add PhotoView to ViewPager and return it
            container.addView(photoView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

            return photoView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);

        }
    }
}
