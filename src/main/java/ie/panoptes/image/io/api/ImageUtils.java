package ie.panoptes.image.io.api;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;

public class ImageUtils {
	
	public static byte[] byteArrayFromImage(BufferedImage image){
		DataBufferByte buffer = (DataBufferByte) image.getRaster().getDataBuffer();
		return buffer.getData();
	}

}
