package ie.panoptes.facedetection.services;


import java.io.IOException;

import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.objdetect.CascadeClassifier;

import ie.panoptes.framework.base.NativeLibraryInitializer;
import ie.panoptes.image.io.ImageResourceLoader;

public abstract class AbstractFaceDetection extends NativeLibraryInitializer{
	
	private static final String PACKAGE = "ie/panoptes/config/";
	private static final String DETECT_FILE= "lbpcascade_frontalface.xml";
	private static final String PATH = PACKAGE.concat(DETECT_FILE);
	
	protected boolean openCvFaceDetected(Mat image) throws IOException{
		String fileName = new ImageResourceLoader().resourceFromClasspath(PATH).getFile().getPath();
		CascadeClassifier faceDetector = new CascadeClassifier(fileName);
	    MatOfRect faceDetections = new MatOfRect();
	    faceDetector.detectMultiScale(image, faceDetections);
		return faceDetections.toArray().length > 0;
	}

}
