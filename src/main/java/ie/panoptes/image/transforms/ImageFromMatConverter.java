package ie.panoptes.image.transforms;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.imgcodecs.Imgcodecs;

import ie.panoptes.image.transforms.api.Converter;
import ie.panoptes.image.transforms.api.ImageTypes;

public class ImageFromMatConverter implements Converter<Mat, BufferedImage> {
    /**
     * 
     */
	public BufferedImage convert(Mat image, ImageTypes type) throws IOException {
		MatOfByte bytemat = new MatOfByte();
		Imgcodecs.imencode(type.toString(), image, bytemat);
		byte[] bytes = bytemat.toArray();
		InputStream in = new ByteArrayInputStream(bytes);
		BufferedImage img = null;
		img = ImageIO.read(in);
		return img;
	}

}
