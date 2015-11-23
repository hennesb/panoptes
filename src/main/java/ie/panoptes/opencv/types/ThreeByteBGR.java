package ie.panoptes.opencv.types;

import org.opencv.core.CvType;


public class ThreeByteBGR implements OpenCVType {

	public int getType() {
		return CvType.CV_8UC3;
	}


}
