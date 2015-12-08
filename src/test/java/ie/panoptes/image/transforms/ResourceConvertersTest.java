package ie.panoptes.image.transforms;

import static org.junit.Assert.*;

import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import ie.panoptes.image.io.AbstractImageLoaderTest;
import ie.panoptes.image.transforms.api.ImageTypes;

import org.junit.Test;
import org.opencv.core.Mat;

public class ResourceConvertersTest extends AbstractImageLoaderTest{

	public ResourceConvertersTest() {
	}
	
	@Test
	public void image_read_as_bytes_and_decoded_to_open_cv_matrix() throws IOException {
		byte [] bytes = asByteArray.imageFrom(imageResource);
		Mat decodeImageAsMatrix = opencvConverter.convert(bytes);
		assertFalse(decodeImageAsMatrix.dataAddr() == 0);		
	}
	
	@Test
	public void image_read_as_stream_decoded_to_open_cv_matrix() throws IOException{
		Mat decodeImageAsMatrix = opencvConverter.convert(imageResource);
		assertFalse(decodeImageAsMatrix.dataAddr() == 0);
	}

	
	@Test
	public void image_read_as_bufferimage_decoded_to_open_cv_matrix() throws IOException{
		BufferedImage image = asImage.imageFrom(imageResource);
		Mat decodeImageAsMatrix = opencvConverter.convert(image);
		assertFalse(decodeImageAsMatrix.dataAddr() == 0);
	}
	
	@Test
	public void convert_from_mat_to_image_as_png_not_null() throws IOException{
		Mat decodeImageAsMatrix = opencvConverter.convert(imageResource);
		ImageFromMatConverter matConverter = new ImageFromMatConverter();
		BufferedImage image = matConverter.convert(decodeImageAsMatrix, ImageTypes.PNG);
		assertNotNull(image);		
	}


}