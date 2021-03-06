package ie.panoptes.image.transforms;

import java.awt.image.BufferedImage;
import java.io.IOException;

import org.opencv.core.Mat;
import org.springframework.core.io.Resource;

import ie.panoptes.constants.IOTestsConfig;
import ie.panoptes.framework.base.FrameworkNativeLibraryInitializer;
import ie.panoptes.image.io.ImageAsBytesFromResource;
import ie.panoptes.image.io.ImageFromResource;
import ie.panoptes.image.io.ImageResourceLoader;
import ie.panoptes.image.io.api.ImageIOService;
import ie.panoptes.image.transforms.api.ResourceConverter;

public class ImageViewerAfterConversion extends FrameworkNativeLibraryInitializer {
	private static Resource imageResource = new ImageResourceLoader()
	.resourceFromClasspath(IOTestsConfig.TEST_IMAGE_FILE);
	private static  ImageIOService<BufferedImage> asImage = new ImageFromResource();;
	private static  ImageIOService<byte[]> asByteArray  = new ImageAsBytesFromResource();;
	private static  ResourceConverter<Mat> opencvConverter = new OpenCVResourceConverter();
	
	public static void main(String args[]) throws IOException{
		BufferedImage image = asImage.imageFrom(imageResource);
		Mat decodeImageAsMatrix = opencvConverter.convert(image);
		
	}

}
