package ie.panoptes.framework.base.facedetection;


import java.io.IOException;

import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.objdetect.CascadeClassifier;

import ie.panoptes.facedetection.api.Location;
import ie.panoptes.framework.base.FrameworkNativeLibraryInitializer;
import ie.panoptes.image.io.ImageResourceLoader;

public abstract class FrameworkFaceDetection extends FrameworkNativeLibraryInitializer{
	
	private static final String PACKAGE = "ie/panoptes/config/";
	private static final String DETECT_FILE= "lbpcascade_frontalface.xml";
	private static final String PATH = PACKAGE.concat(DETECT_FILE);

	
	protected boolean openCvFaceDetected(Mat image) throws IOException{		
		return faceDetected(image);
	}
	
	protected boolean writeImageWhenFound(Mat image, Location location) throws IOException{
		boolean faceDetected = faceDetected(image);
		if (faceDetected){
			Imgcodecs.imwrite(location.getLocation().getPath(), image);
		}
		return faceDetected;
	}
	
	private boolean faceDetected(Mat image) throws IOException{
		checkForEmptyMatrix(image);
		String fileName = new ImageResourceLoader().resourceFromClasspath(PATH).getFile().getPath();
		CascadeClassifier faceDetector = new CascadeClassifier(fileName);
	    MatOfRect faceDetections = new MatOfRect();
	    faceDetector.detectMultiScale(image, faceDetections);
		return faceDetections.toArray().length > 0;		
	}
	
	private void checkForEmptyMatrix(Mat matrix){
		if (matrix.empty()){
			throw new RuntimeException("Empty frame passed");
		}
	}

}
