package ie.panoptes.image.transforms;

import java.awt.Image;

import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.springframework.core.io.Resource;

public class OpenCVResourceTransformer implements ResourceTransformer<Mat> {

	public Mat transform(Resource resource) {
		return null;
	}

	public Mat transform(Image image) {
		return null;
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
