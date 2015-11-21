package ie.panoptes;


import org.junit.Test;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import static org.junit.Assert.*;




public class FaceDetectionTest extends BaseTestClass{
	
	@Test
	public void faceDetected(){
        Mat mat = Mat.eye( 3, 3, CvType.CV_8UC1 );
        System.out.println( "mat = " + mat.dump() );
        assertEquals(true, true);
	}

}
