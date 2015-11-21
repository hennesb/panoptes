package ie.panoptes.image.io;

import java.io.IOException;

import org.springframework.core.io.Resource;

public interface ImageIOService<T> {
	/**
	 * 
	 * @param <T>
	 * @param resource
	 * @return Any generic type that can reference the contents of an image
	 * @see org.springframework.core.io.Resource
	 * Using the Spring Resource interface , which allow an image to be created from a variety of resource types
	 */
	public  T imageFrom(Resource resource) throws IOException;
	

}
