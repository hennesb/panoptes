package ie.panoptes.video.api;

import org.springframework.core.io.Resource;

public interface ScanMedia {
	
	public boolean scanDetectedFace(Resource resource);	

}
