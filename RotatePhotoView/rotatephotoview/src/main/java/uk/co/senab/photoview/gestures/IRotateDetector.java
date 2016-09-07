package uk.co.senab.photoview.gestures;

import android.view.MotionEvent;

/**
 * Interface to detect rotation
 * Created by ChenSL on 2015/9/16.
 */
public interface IRotateDetector {
    /**
     * handle rotation in onTouchEvent
     *
     * @param event The motion event.
     * @return True if the event was handled, false otherwise.
     */
    boolean onTouchEvent(MotionEvent event);

    /**
     * is the Gesture Rotate
     *
     * @return true:rotating;false,otherwise
     */
    boolean isRotating();
}
