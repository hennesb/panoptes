package ie.panoptes.image.transforms;

import java.awt.image.BufferedImage;
import java.io.IOException;

import org.opencv.core.Mat;
import org.springframework.core.io.Resource;

import ie.panoptes.constants.IOTestsConfig;
import ie.panoptes.framework.base.NativeLibraryInitializer;
import ie.panoptes.image.io.AbstractImageLoaderTest;
import ie.panoptes.image.io.ImageAsBytesFromResource;
import ie.panoptes.image.io.ImageFromResource;
import ie.panoptes.image.io.ImageIOService;
import ie.panoptes.image.io.ImageResourceLoader;

public class ImageViewerAfterConversion extends NativeLibraryInitializer {
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
