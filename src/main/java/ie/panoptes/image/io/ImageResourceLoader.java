package ie.panoptes.image.io;


import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

public class ImageResourceLoader {
	/**
	 * 	
	 * @param location
	 * @see org.springframework.core.io.Resource
	 * @return a @link org.springframework.core.io.Resource 
	 * 
	 * This method take the location of the file on the classpath and return a resource object that can be used to read its
	 * contents.
	 */
	public Resource resourceFromClasspath(String location){
		return new DefaultResourceLoader().getResource(ResourceLoader.CLASSPATH_URL_PREFIX + location);	  	
	}
	
}
