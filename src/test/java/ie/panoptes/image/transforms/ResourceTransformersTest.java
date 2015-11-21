package ie.panoptes.image.transforms;

import static org.junit.Assert.*;
import ie.panoptes.image.io.ImageFromResource;
import ie.panoptes.image.io.ImageIOService;

import org.junit.Before;
import org.junit.Test;
import org.opencv.core.Mat;

public class ResourceTransformersTest {
	
	private ResourceTransformer<Mat> opencvTranformer;
	private ImageIOService io;
	

	public ResourceTransformersTest() {
	}

	@Before
	public void setUp() throws Exception {
		opencvTranformer = new OpenCVResourceTransformer();
		io = new ImageFromResource();
	}

	@Test
	public void mat_from_inputstream() {
		
	}

}
