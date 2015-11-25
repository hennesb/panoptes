package ie.panoptes.facedetection.services;

import java.io.IOException;

import org.opencv.core.Mat;

import ie.panoptes.facedetection.api.FaceDetection;
import ie.panoptes.image.transforms.api.ResourceConverter;

public class FaceDetectionWithOpenCVMatrix extends AbstractFaceDetection
		implements FaceDetection<Mat, ResourceConverter<Mat>> {

	public boolean faceDetected(Mat resource) throws IOException {
		return false;
	}

	public void setResourceConverter(ResourceConverter<Mat> resourceConverter) {
		
		
	}


}
