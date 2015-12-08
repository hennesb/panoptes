package ie.panoptes.facedetection.services;

import java.io.IOException;

import org.opencv.core.Mat;

import ie.panoptes.facedetection.api.FaceDetection;
import ie.panoptes.facedetection.api.Location;
import ie.panoptes.framework.base.facedetection.FrameworkFaceDetection;
import ie.panoptes.image.transforms.api.ResourceConverter;

public class FaceDetectionWithOpenCVMatrix extends FrameworkFaceDetection
		implements FaceDetection<Mat, ResourceConverter<Mat>> {

	public boolean faceDetected(Mat resource) throws IOException {
		return this.openCvFaceDetected(resource);
	}

	public void setResourceConverter(ResourceConverter<Mat> resourceConverter) {
				
	}

	public boolean faceDetectedWriteResult(Mat resource, Location where)
			throws IOException {	
		return this.writeImageWhenFound(resource, where);
	}


}
