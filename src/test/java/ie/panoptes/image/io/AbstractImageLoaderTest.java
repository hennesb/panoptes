package ie.panoptes.image.io;

import ie.panoptes.constants.IOTestsConfig;
import ie.panoptes.framework.base.AbstractFrameworkTest;
import ie.panoptes.image.io.api.ImageIOService;
import ie.panoptes.image.io.api.ImageMagicNumbers;
import ie.panoptes.image.transforms.OpenCVResourceConverter;
import ie.panoptes.image.transforms.api.ResourceConverter;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOCase;
import org.apache.commons.io.filefilter.MagicNumberFileFilter;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TemporaryFolder;
import org.opencv.core.Mat;
import org.springframework.core.io.Resource;

/**
 * 
 * @author Brian Hennessy
 * Abstract test class that has the common initization code for handling test cases that require images , resources and
 * transformer references. 
 *
 */
public abstract class AbstractImageLoaderTest extends AbstractFrameworkTest{

	protected Resource imageResource;
	protected ImageIOService<BufferedImage> asImage;
	protected ImageIOService<byte[]> asByteArray;
	protected ResourceConverter<Mat> opencvConverter;
	
	@Rule
	public TemporaryFolder testFolder = new TemporaryFolder();

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