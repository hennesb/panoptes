package ie.panoptes.facedetection.api;

import java.io.File;
import java.io.IOException;

public class Location {
	
	private File file;
	private NamingAttributes namingAttributes;
	
	public Location(File file, NamingAttributes attributes){
		this.file = file;
		this.namingAttributes = attributes;
	}
	
	public Location(){
		
	}
	
	public void setLocation(File file) throws IOException{
		this.file = file;
	}
	
	public File getLocation(){
		return this.file;
	}
	
	public void setNamingAttributes(NamingAttributes fileNamingAttributes){
		this.namingAttributes = fileNamingAttributes;
	}
	
	public NamingAttributes getNamingAttributes(){
		return this.namingAttributes;
	}

}
