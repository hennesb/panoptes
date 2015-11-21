package ie.panoptes;


import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.opencv.core.Core;


public class BaseTestClass {

	public BaseTestClass() {		
	}

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.loadLibrary( Core.NATIVE_LIBRARY_NAME );
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

}
