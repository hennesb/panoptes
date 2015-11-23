package ie.panoptes.mappers;

import ie.panoptes.opencv.types.OpenCVType;
import ie.panoptes.opencv.types.ThreeByteBGR;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

public class OpenCvTypesFromAwtTypes {
	
	private static final Map<Integer, OpenCVType> map;
	
	private static void initialize(){
		map.put(BufferedImage.TYPE_3BYTE_BGR, new ThreeByteBGR());
	}
	
	static {
		map = new HashMap<Integer, OpenCVType>();
		initialize();
	}
	
	public OpenCVType map(Integer key){
		return map.get(key);
	}
	

}
