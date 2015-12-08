package ie.panoptes.video.services;

import java.io.File;
import java.io.IOException;

import org.opencv.core.Mat;
import org.opencv.videoio.VideoCapture;
import org.springframework.core.io.Resource;

import ie.panoptes.facedetection.api.FaceDetection;
import ie.panoptes.facedetection.api.Location;
import ie.panoptes.facedetection.api.NamingAttributes;
import ie.panoptes.framework.base.FrameworkNativeLibraryInitializer;
import ie.panoptes.image.transforms.api.ResourceConverter;
import ie.panoptes.video.api.ScanMedia;

public class ScanVideo extends FrameworkNativeLibraryInitializer implements
		ScanMedia {
	

	private FaceDetection<Mat, ResourceConverter<Mat>> faceDetector;
    /**
     * 
     */
	public boolean scanDetectedFace(Resource resource) throws IOException {
		return processVideoFrames(resource);
	}

	private boolean detectFace(Mat frame, int count)
			throws IOException {		
			return faceDetected(frame, count);
	}

	private boolean processVideoFrames(Resource resource) throws IOException {
		boolean faceFound = false;
		VideoCapture capture = new VideoCapture();
		Mat frame = new Mat();
		System.out.println("File path " + resource.getFile().getPath());
		capture.open(resource.getFile().getPath());
		int numberOfFrames = 0;
		if (capture.isOpened()) {
			
			while (true) {
				capture.read(frame);		
				if (frame.empty()) {
					break;
				}
				numberOfFrames++;
				if (detectFace(frame, numberOfFrames)){
					System.out.println("Face found in frame " + numberOfFrames);
					faceFound = true;
				}
			}
			capture.release();
		}
		return faceFound;
	}
	
	private boolean faceDetected(Mat matrix, int count) throws IOException{
		Location location = new Location(new File("/home/int13h/poc/got_ya/" + count), new NamingAttributes(count + "", ".png"));
		return faceDetector.faceDetectedWriteResult(matrix, location);
	}

	public void setFaceDetection(
			FaceDetection<Mat, ResourceConverter<Mat>> faceDetector)
			throws IOException {
		this.faceDetector = faceDetector;
		
	}






}
