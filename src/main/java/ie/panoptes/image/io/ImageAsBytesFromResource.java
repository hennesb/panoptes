package ie.panoptes.image.io;

import ie.panoptes.framework.base.FrameworkNativeLibraryInitializer;
import ie.panoptes.image.io.api.ImageIOService;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.Resource;

public class ImageAsBytesFromResource extends FrameworkNativeLibraryInitializer implements ImageIOService<byte[]> {

	public byte[] imageFrom(Resource resource) throws IOException {
		InputStream stream = resource.getInputStream();
		return IOUtils.toByteArray(stream);		
	}

}
