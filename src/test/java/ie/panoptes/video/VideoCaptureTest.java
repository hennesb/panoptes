package ie.panoptes.video;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;
import org.opencv.core.Mat;
import org.opencv.videoio.VideoCapture;

import ie.panoptes.framework.base.AbstractFrameworkTest;


public class VideoCaptureTest extends AbstractFrameworkTest {
	
	private static final String TEST_VIDEO = "######";

	public VideoCaptureTest() {
	}

    @Ignore
	@Test
	public void open_video_file_mpg_format() {
		Mat frame = new Mat();
    	VideoCapture capture = new VideoCapture();
    	capture.open(TEST_VIDEO);
    	boolean isOpened = capture.isOpened();
    	System.out.println("Is opened " + capture.isOpened());
    	while(true){
    		
    		capture.read(frame);
    		System.out.println("Read frame " + frame.dataAddr());
    	
    		
    		if (frame.empty()){
    			break;
    		}
    		
    	}
    	capture.release();
    	assertTrue(isOpened);
	}

}
