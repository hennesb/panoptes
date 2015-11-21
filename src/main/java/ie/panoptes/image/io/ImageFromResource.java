package ie.panoptes.image.io;

import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.springframework.core.io.Resource;

public class ImageFromResource implements ImageIOService<Image> {

	public Image imageFrom(Resource resource) throws IOException {
	    InputStream stream = resource.getInputStream();
		Image image = ImageIO.read(stream);
		return image;
	}

}
