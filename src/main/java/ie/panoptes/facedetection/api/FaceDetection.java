package ie.panoptes.facedetection.api;

import java.io.IOException;

public interface FaceDetection<T>{
	
	public boolean faceDetected(T resource) throws IOException;
	

}
