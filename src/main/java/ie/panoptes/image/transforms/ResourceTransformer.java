package ie.panoptes.image.transforms;

import java.awt.Image;

import org.springframework.core.io.Resource;

public interface ResourceTransformer<T> {

	public T transform(Resource resource);
	
	public T transform(Image image);
	
	public T tranform(byte[] bytes);
}
