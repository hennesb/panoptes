package ie.panoptes.image.transforms;

import java.awt.image.BufferedImage;
import java.io.IOException;

import org.springframework.core.io.Resource;

public interface ResourceTransformer<T> {

	public T transform(Resource resource) throws IOException;
	
	public T transform(BufferedImage image) throws IOException;
	
	public T tranform(byte[] bytes);
}
