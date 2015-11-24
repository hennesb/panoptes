package ie.panoptes.facedetection.services;

import java.io.IOException;

import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.objdetect.CascadeClassifier;
import org.springframework.core.io.Resource;

import ie.panoptes.facedetection.api.FaceDetection;
import ie.panoptes.image.io.ImageResourceLoader;
import ie.panoptes.image.transforms.OpenCVResourceConverter;
import ie.panoptes.image.transforms.ResourceConverter;

public class ResourceBasedFaceDetectionService implements FaceDetection<Resource> {
	
	private ResourceConverter<Mat> resourceConverter;
	
	public static final String PACKAGE = "ie/panoptes/config/";
	public static final String DETECT_FILE= "lbpcascade_frontalface.xml";
	public static final String PATH = PACKAGE.concat(DETECT_FILE);
	

	public boolean faceDetected(Resource resource) throws IOException {
		resourceConverter = new OpenCVResourceConverter();
		Mat matrix = resourceConverter.convert(resource);
		System.out.println("matrix is " + matrix.dataAddr());
		return openCvFaceDetected(matrix);
	}
	
	public ResourceConverter<Mat> getResourceConverter() {
		return resourceConverter;
	}

	public void setResourceConverter(ResourceConverter<Mat> resourceConverter) {
		this.resourceConverter = resourceConverter;
	}

	private boolean openCvFaceDetected(Mat image) throws IOException{
		String fileName = new ImageResourceLoader().resourceFromClasspath(PATH).getFile().getPath();
		System.out.println("Filename " + fileName);
		CascadeClassifier faceDetector = new CascadeClassifier(fileName);
	    MatOfRect faceDetections = new MatOfRect();
	    faceDetector.detectMultiScale(image, faceDetections);
	    System.out.println(String.format("Detected %s faces", faceDetections.toArray().length));
		return faceDetections.toArray().length > 0;
	}

}
