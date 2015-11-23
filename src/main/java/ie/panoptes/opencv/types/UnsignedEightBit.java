package ie.panoptes.opencv.types;

import org.opencv.core.CvType;

public class UnsignedEightBit implements OpenCVType {

	public int getType() {
		return CvType.CV_8U;
	}

}
