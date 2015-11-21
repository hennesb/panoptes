package ie.panoptes.image.io;

import static org.junit.Assert.*;

import java.awt.Image;
import java.io.IOException;

import org.junit.Test;

public class ImageIOServiceTest extends AbstractImageLoaderTest {
	
	public ImageIOServiceTest() {
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
