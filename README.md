# RotatePhotoView
Adding **Rotation with two finger function**  on [PhotoView](https://github.com/search?utf8=%E2%9C%93&q=PhotoView)

#Usage
##in code
you need to enable rotation, by default it's **false**.

other functions just as `PhotoView`.

	PhotoViewAttacher attacher = new PhotoViewAttacher(mImageView);
	attacher.setRotatable(true);
	//set rotate listener
	photoView.setOnViewRotateListener(new PhotoViewAttacher.OnViewRotateListener() {
        @Override
        public void onRotate(int degree) {
             //do something
        }
    });

don't forget to **clear** when leave

	@Override
    public void onDestroyView() {
        attacher.cleanup();
        super.onDestroyView();
    }
##in xml
	 <uk.co.senab.photoview.PhotoView
        android:id="@+id/photoview"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:src="@drawable/ic_bg" />

#with Volley
let the `PhotoView` extends `Volley.NetworkImageView` instead of `ImageView`.

#Gradle
coming very soon. :)

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