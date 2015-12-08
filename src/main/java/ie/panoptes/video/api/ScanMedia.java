package ie.panoptes.video.api;

import java.io.IOException;

import org.springframework.core.io.Resource;

public interface ScanMedia{
	
	public boolean scanDetectedFace(Resource resource) throws IOException;	
		

}
