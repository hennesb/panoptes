package ie.panoptes.video.services;

import org.opencv.core.Mat;
import org.opencv.videoio.VideoCapture;
import org.springframework.core.io.Resource;

import ie.panoptes.framework.base.NativeLibraryInitializer;
import ie.panoptes.video.api.ScanMedia;

public class ScanVideo extends NativeLibraryInitializer implements ScanMedia {

	
	public boolean scanDetectedFace(Resource resource) {		
		return false;
	}
	
	private boolean iterate(Resource resource){
		Mat frame = new Mat();
		VideoCapture capture = new VideoCapture();
    	capture.open(resource.getFilename());
		return false;
		
	}

}
