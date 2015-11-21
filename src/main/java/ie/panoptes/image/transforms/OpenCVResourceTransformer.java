package ie.panoptes.image.transforms;

import java.awt.Image;

import org.opencv.core.Mat;
import org.springframework.core.io.Resource;

public class OpenCVResourceTransformer implements ResourceTransformer<Mat> {

	public Mat transform(Resource resource) {
		return null;
	}

	public Mat transform(Image image) {
		return null;
	}

	public Mat tranform(byte[] bytes) {
		return null;
	}

}
