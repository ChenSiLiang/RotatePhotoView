package uk.co.senab.photoview.gestures;

import android.view.MotionEvent;

/**
 * Handle ImageView rotate event with two fingers
 * Created by ChenSL on 2015/9/16.
 */
public class RotateGestureDetector implements IRotateDetector {
    private int mLastAngle = 0;
    private IRotateListener mListener;
    private boolean mIsRotate;

    /**
     * set rotation listener for callback
     *
     * @param listener a  rotation listener
     */
    public void setRotateListener(IRotateListener listener) {
        this.mListener = listener;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return doRotate(event);
    }

    @Override
    public boolean isRotating() {
        return mIsRotate;
    }

    /**
     * handle rotation
     *
     * @param ev Motion event
     * @return always true.
     */
    private boolean doRotate(MotionEvent ev) {
        if (ev.getPointerCount() != 2) {
            return false;
        }
        //Calculate the angle between the two fingers
        int pivotX = (int) (ev.getX(0) + ev.getX(1)) / 2;
        int pivotY = (int) (ev.getY(0) + ev.getY(1)) / 2;
        float deltaX = ev.getX(0) - ev.getX(1);
        float deltaY = ev.getY(0) - ev.getY(1);
        double radians = Math.atan(deltaY / deltaX);
        //Convert to degrees
        int degrees = (int) (radians * 180 / Math.PI);
        /*
         * Must use getActionMasked() for switching to pick up pointer events.
         * These events have the pointer index encoded in them so the return
         * from getAction() won't match the exact action constant.
         */
        switch (ev.getActionMasked()) {
            case MotionEvent.ACTION_DOWN:
                mLastAngle = degrees;
                mIsRotate = false;
                break;
            case MotionEvent.ACTION_UP:
                mIsRotate = false;
                break;
            case MotionEvent.ACTION_POINTER_DOWN:
                mLastAngle = degrees;
                mIsRotate = false;
                break;
            case MotionEvent.ACTION_CANCEL:
            case MotionEvent.ACTION_POINTER_UP:
                mIsRotate = false;
                upRotate(pivotX, pivotY);
                mLastAngle = degrees;
                break;
            case MotionEvent.ACTION_MOVE:
                mIsRotate = true;
                int degreesValue = degrees - mLastAngle;
                if (degreesValue > 45) {
                    //Going CCW across the boundary
                    rotate(-5, pivotX, pivotY);
                } else if (degreesValue < -45) {
                    //Going CW across the boundary
                    rotate(5, pivotX, pivotY);
                } else {
                    //Normal rotation, rotate the difference
                    rotate(degreesValue, pivotX, pivotY);
                }
                //Save the current angle
                mLastAngle = degrees;
                break;
        }
        return true;
    }

    /**
     * to invoke the callback
     *
     * @param degree degree to rotate
     */
    private void rotate(int degree, int pivotX, int pivotY) {
        if (mListener != null) {
            mListener.rotate(degree, pivotX, pivotY);
        }
    }

    /**
     * to invoke the finger up action
     */
    private void upRotate(int pivotX, int pivotY) {
        if (mListener != null) {
            mListener.upRotate(pivotX, pivotY);
        }
    }
}
