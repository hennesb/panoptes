package ie.panoptes.image.transforms;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;



import org.apache.commons.io.IOUtils;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.springframework.core.io.Resource;

public class OpenCVResourceTransformer implements ResourceTransformer<Mat> {
	


	public Mat transform(Resource resource) throws IOException {
		InputStream stream = resource.getInputStream();
		return matrixFromByteArray(IOUtils.toByteArray(stream));
	}
   
	
	public Mat transform(BufferedImage image) throws IOException {
		ByteArrayOutputStream outStream=new ByteArrayOutputStream();
		return matrixFromByteArray(outStream.toByteArray());
	}

	
	public Mat tranform(byte[] bytes) {
        return matrixFromByteArray(bytes);
	}
	
	private Mat matrixFromByteArray(byte[] bytes){
		Mat matrix = new Mat(bytes.length,1,CvType.CV_8U);
		matrix.put(0, 0, bytes);
		Mat theImage = Imgcodecs.imdecode(matrix, Imgcodecs.CV_LOAD_IMAGE_ANYCOLOR);
		return theImage;	
	}

}
