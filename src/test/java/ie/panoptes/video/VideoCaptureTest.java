package ie.panoptes.video;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.opencv.core.Mat;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import ie.panoptes.constants.IOTestsConfig;
import ie.panoptes.facedetection.api.FaceDetection;
import ie.panoptes.facedetection.services.FaceDetectionWithOpenCVMatrix;
import ie.panoptes.framework.base.AbstractFrameworkTest;
import ie.panoptes.image.io.ImageResourceLoader;
import ie.panoptes.image.transforms.api.ResourceConverter;
import ie.panoptes.video.services.ScanVideo;


public class VideoCaptureTest extends AbstractFrameworkTest {
	
	private static final String TEST_VIDEO = "Test.mpg";

	private Resource resourceNoFace;
	
	private ScanVideo mediaScanner;
	//private FaceDetectionWithOpenCVMatrix detector ;
	private FaceDetection<Mat, ResourceConverter<Mat>> detector;
	
	@Before
	public void setUp() throws IOException{
		detector = new FaceDetectionWithOpenCVMatrix();
		mediaScanner = new ScanVideo();
		mediaScanner.setFaceDetection(detector);
		resourceNoFace = new ImageResourceLoader()
		.resourceFromClasspath(IOTestsConfig.TEST_PACKAGE + IOTestsConfig.VIDEO_PACKAGE + IOTestsConfig.VIDEO_NO_FACE);
	}

	public VideoCaptureTest() {
	}
	
    @Ignore
	@Test
	public void image_detected_in_video() throws IOException {
       //assertFalse(mediaScanner.scanDetectedFace(resourceNoFace));
		assertFalse(mediaScanner.scanDetectedFace(new FileSystemResource(TEST_VIDEO)));
	}


	
}