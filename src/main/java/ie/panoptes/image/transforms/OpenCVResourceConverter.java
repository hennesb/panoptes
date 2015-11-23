package ie.panoptes.image.transforms;

import ie.panoptes.mappers.OpenCvTypesFromAwtTypes;
import ie.panoptes.opencv.types.OpenCVType;
import ie.panoptes.opencv.types.UnsignedEightBit;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.springframework.core.io.Resource;

public class OpenCVResourceConverter implements ResourceConverter<Mat> {
	
    private static final OpenCvTypesFromAwtTypes types = new OpenCvTypesFromAwtTypes();

    /**
     * Convert a Resource to an opencv Mat type. This defaults to an 8 bit pixel.
     */
	public Mat convert(Resource resource) throws IOException {
		InputStream stream = resource.getInputStream();
		return matrixFromByteArray(IOUtils.toByteArray(stream), new UnsignedEightBit());
	}
   
    /**
     * Convert an AWT Buffered Image type to an Opencv Mat type 3 byte BGR. 
     */
	public Mat convert(BufferedImage image) throws IOException {
		DataBufferByte buffer = (DataBufferByte) image.getRaster().getDataBuffer();
		return matrixFromByteArrayNoDecode(buffer.getData(), types.map(image.getType()));
		
	}

    /**
     * Convert a byte[] to an opencv Mat type. This defaults to an 8 bit pixel.
     */	
	public Mat convert(byte[] bytes) {
        return matrixFromByteArray(bytes, new UnsignedEightBit());
	}
	
	
	private Mat matrixFromByteArray(byte[] bytes, OpenCVType type){
		Mat matrix = new Mat(bytes.length,1, type.getType());
		matrix.put(0, 0, bytes);
		Mat theImage = Imgcodecs.imdecode(matrix, Imgcodecs.CV_LOAD_IMAGE_ANYCOLOR);
		return theImage;	
	}
	
	private Mat matrixFromByteArrayNoDecode(byte[] bytes, OpenCVType type){
		Mat theMatrix = new Mat(bytes.length,1, type.getType());
		theMatrix.put(0, 0, bytes);
		return theMatrix;	
	}
	

}
