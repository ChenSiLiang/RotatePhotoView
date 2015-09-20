# RotatePhotoView
Adding **Rotation with two finger function**  on [PhotoView](https://github.com/search?utf8=%E2%9C%93&q=PhotoView)

#Set Up
##jar
download the `RotatePhotoView.jar` and add to your project.
##Gradle
coming very soon. :)

#Usage
##in code
you need to enable rotation, by default it's **false**.

	PhotoViewAttacher attacher = new PhotoViewAttacher(mImageView);
	attacher.setRotatable(true);

set rotate listener

	photoView.setOnViewRotateListener(new PhotoViewAttacher.OnViewRotateListener() {
        @Override
        public void onRotate(int degree) {
             //do something
        }
    });

enable recover to `Right Angle`(0,90,180,270),by default it's **false**.

    mAttacher.setToRightAngle(true);

other functions just as `PhotoView`.



don't forget to **clear** when leave,for example.

	@Override
    public void onDestroy() {
        attacher.cleanup();
        super.onDestroy();
    }
##in xml
	 <uk.co.senab.photoview.PhotoView
        android:id="@+id/photoview"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content" />

#With Volley
let the `PhotoView` extends `Volley.NetworkImageView` instead of `ImageView`.

#Waring
Catch `IllegalArgumentException` when working with `ViewPager`,see `HackyViewPager` for more details. 


#License
	Copyright 2011, 2012 Chris Banes
	
	Licensed under the Apache License, Version 2.0 (the "License");
	you may not use this file except in compliance with the License.
	You may obtain a copy of the License at
	
	   http://www.apache.org/licenses/LICENSE-2.0
	
	Unless required by applicable law or agreed to in writing, software
	distributed under the License is distributed on an "AS IS" BASIS,
	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	See the License for the specific language governing permissions and
	limitations under the License.