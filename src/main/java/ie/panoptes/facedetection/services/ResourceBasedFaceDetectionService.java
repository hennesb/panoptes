package ie.panoptes.facedetection.services;

import java.io.IOException;
import org.opencv.core.Mat;
import org.springframework.core.io.Resource;
import ie.panoptes.facedetection.api.FaceDetection;

import ie.panoptes.image.transforms.api.ResourceConverter;

public class ResourceBasedFaceDetectionService extends AbstractFaceDetection implements FaceDetection<Resource, ResourceConverter<Mat>> {
	
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

}
