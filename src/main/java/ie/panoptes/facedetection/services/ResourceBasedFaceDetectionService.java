package ie.panoptes.facedetection.services;

import java.io.IOException;

import org.opencv.core.Mat;
import org.springframework.core.io.Resource;

import ie.panoptes.facedetection.api.FaceDetection;
import ie.panoptes.facedetection.api.Location;
import ie.panoptes.framework.base.facedetection.FrameworkFaceDetection;
import ie.panoptes.image.transforms.api.ResourceConverter;

public class ResourceBasedFaceDetectionService extends FrameworkFaceDetection implements FaceDetection<Resource, ResourceConverter<Mat>> {
	
	private ResourceConverter<Mat> resourceConverter;	

	public boolean faceDetected(Resource resource) throws IOException {
		Mat matrix = resourceConverter.convert(resource);
		return openCvFaceDetected(matrix);
	}
	
	public ResourceConverter<Mat> getResourceConverter() {
		return resourceConverter;
	}

	public void setResourceConverter(ResourceConverter<Mat> resourceConverter) {
		this.resourceConverter = resourceConverter;
		
	}

	public boolean faceDetectedWriteResult(Resource resource, Location where)
			throws IOException {
		Mat matrix = resourceConverter.convert(resource);
		boolean detected = openCvFaceDetected(matrix);
		if (detected){
			
		}
		return detected;
	}

}
