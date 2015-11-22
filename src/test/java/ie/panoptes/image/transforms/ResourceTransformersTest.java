package ie.panoptes.image.transforms;

import static org.junit.Assert.*;

import java.awt.image.BufferedImage;
import java.io.IOException;

import ie.panoptes.image.io.AbstractImageLoaderTest;

import org.junit.Ignore;
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
	
	@Test
	public void image_read_as_stream_decoded_to_open_cv_matrix() throws IOException{
		Mat decodeImageAsMatrix = opencvTranformer.transform(imageResource);
		assertFalse(decodeImageAsMatrix.dataAddr() == 0);
	}
	
	@Ignore
	@Test
	public void image_read_as_bufferimage_decoded_to_open_cv_matrix() throws IOException{
		BufferedImage image = asImage.imageFrom(imageResource);
		Mat decodeImageAsMatrix = opencvTranformer.transform(image);
		assertFalse(decodeImageAsMatrix.dataAddr() == 0);
	}

}