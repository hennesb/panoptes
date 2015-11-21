package ie.panoptes.framework.base;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.opencv.core.CvType;
import org.opencv.core.Mat;

public class NonBaseTestClassFrameworkTester {

	public NonBaseTestClassFrameworkTester() {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void framework_base_class_loads_opencv(){
		FrameWorkInitializerTest frameworkTester = new FrameWorkInitializerTest();
		Mat mat = Mat.eye( 3, 3, CvType.CV_8UC1 );
		assertNotNull(mat);
	}
	
	private class FrameWorkInitializerTest extends NativeLibraryInitializer{
		
	}

}
