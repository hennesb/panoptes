package ie.panoptes.image.io;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.Resource;

public class ImageAsBytesFromResource implements ImageIOService<byte[]> {

	public byte[] imageFrom(Resource resource) throws IOException {
		InputStream stream = resource.getInputStream();
		return IOUtils.toByteArray(stream);		
	}

}
