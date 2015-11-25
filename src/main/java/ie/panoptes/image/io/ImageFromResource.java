package ie.panoptes.image.io;

import ie.panoptes.image.io.api.ImageIOService;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.springframework.core.io.Resource;

public class ImageFromResource implements ImageIOService<BufferedImage> {

	public BufferedImage imageFrom(Resource resource) throws IOException {
	    InputStream stream = resource.getInputStream();
	    BufferedImage image = ImageIO.read(stream);
		return image;
	}

}
