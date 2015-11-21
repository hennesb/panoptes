package ie.panoptes.image.io;

import static org.junit.Assert.*;

import java.awt.Image;
import java.io.IOException;

import ie.panoptes.constants.IOTestsConfig;

import org.junit.Before;
import org.junit.Test;
import org.springframework.core.io.Resource;

public class ImageIOServiceTest {
	
	private Resource imageResource;
	private ImageIOService<Image> asImage;
	private ImageIOService<byte[]> asByteArray;

	public ImageIOServiceTest() {
	}

	@Before
	public void setUp() throws Exception {
		asImage = new ImageFromResource();
		asByteArray = new ImageAsBytesFromResource();
		imageResource = new ImageResourceLoader()
		.resourceFromClasspath(IOTestsConfig.TEST_IMAGE_FILE);
		
	}

	@Test
	public void resource_to_image_and_image_not_null() throws IOException {	
		Image image = asImage.imageFrom(imageResource);
		assertNotNull(image);
	}
	
	@Test
	public void resource_to_byte_array_not_null() throws IOException{
		byte [] bytes = asByteArray.imageFrom(imageResource);
		assertTrue(bytes.length > 0);
	}
	

}
