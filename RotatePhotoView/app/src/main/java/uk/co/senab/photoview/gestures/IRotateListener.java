package uk.co.senab.photoview.gestures;

/**
 * Interface for a callback for rotation
 * Created by ChenSL on 2015/9/16.
 */
public interface IRotateListener {
    /**
     * callback for rotation
     *
     * @param degree degree of rotation
     */
    void rotate(int degree);

    /**
     * MotionEvent.ACTION_POINTER_UP happens when two finger minus to only one
     * change the ImageView to 0,90,180,270
     *
     * @param upDegree imageview's degree when finger up
     */
    void upRotate();
}
