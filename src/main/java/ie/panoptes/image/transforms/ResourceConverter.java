package ie.panoptes.image.transforms;

import java.awt.image.BufferedImage;
import java.io.IOException;

import org.springframework.core.io.Resource;

public interface ResourceConverter<T> {

	public T convert(Resource resource) throws IOException;
	
	public T convert(BufferedImage image) throws IOException;
	
	public T convert(byte[] bytes);
}
