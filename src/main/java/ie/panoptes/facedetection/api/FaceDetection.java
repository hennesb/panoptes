package ie.panoptes.facedetection.api;

import java.io.IOException;

public interface FaceDetection<T, C>{
	
	public boolean faceDetected(T resource) throws IOException;
	
	public void setResourceConverter(C resourceConverter);
	

}
