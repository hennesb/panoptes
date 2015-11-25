package ie.panoptes.image.io;

import ie.panoptes.constants.IOTestsConfig;
import ie.panoptes.framework.base.NativeLibraryInitializer;
import ie.panoptes.image.io.api.ImageIOService;
import ie.panoptes.image.transforms.OpenCVResourceConverter;
import ie.panoptes.image.transforms.api.ResourceConverter;

import java.awt.Image;
import java.awt.image.BufferedImage;

import org.junit.Before;
import org.opencv.core.Mat;
import org.springframework.core.io.Resource;

/**
 * 
 * @author Brian Hennessy
 * Abstract test class that has the common initization code for handling test cases that require images , resources and
 * transformer references. 
 *
 */
public abstract class AbstractImageLoaderTest extends NativeLibraryInitializer{

	protected Resource imageResource;
	protected ImageIOService<BufferedImage> asImage;
	protected ImageIOService<byte[]> asByteArray;
	protected ResourceConverter<Mat> opencvConverter;

	public AbstractImageLoaderTest() {
		super();
	}

	@Before
	public void setUp() throws Exception {
		initImageServices();
		loadImages();
		initializeTransformers();		
	}
	
	private void initImageServices(){
		asImage = new ImageFromResource();
		asByteArray = new ImageAsBytesFromResource();
	}
	
	private void loadImages(){
		imageResource = new ImageResourceLoader()
		.resourceFromClasspath(IOTestsConfig.TEST_IMAGE_FILE);
	}
	
	private void initializeTransformers(){
		opencvConverter = new OpenCVResourceConverter();
	}

}