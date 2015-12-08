package ie.panoptes.image.transforms.api;

import java.io.IOException;
/**
 * 
 * @author int13h
 *
 * @param <From> Convert from this type
 * @param <To> Convert to this type 
 */
public interface Converter<From,To> {
	
	public To convert(From from, ImageTypes fileFormat) throws IOException;

}
