package ie.panoptes.image.transforms;

import static org.junit.Assert.*;

import java.io.IOException;

import ie.panoptes.image.io.AbstractImageLoaderTest;
import ie.panoptes.image.io.ImageAsBytesFromResource;
import ie.panoptes.image.io.ImageFromResource;
import ie.panoptes.image.io.ImageIOService;

import org.junit.Before;
import org.junit.Test;
import org.opencv.core.Mat;

public class ResourceTransformersTest extends AbstractImageLoaderTest{

	public ResourceTransformersTest() {
	}
	

	@Test
	public void image_read_as_bytes_and_decoded_to_open_cv_matrix() throws IOException {
		byte [] bytes = asByteArray.imageFrom(imageResource);
		Mat decodeImageAsMatrix = opencvTranformer.tranform(bytes);
		assertFalse(decodeImageAsMatrix.dataAddr() == 0);
		
	}

}
