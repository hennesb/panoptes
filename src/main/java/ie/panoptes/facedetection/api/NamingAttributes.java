package ie.panoptes.facedetection.api;

public class NamingAttributes {
	
	private String suffix;
	private String prefix;
	
	public String getSuffix() {
		return suffix;
	}
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	public String getPrefix() {
		return prefix;
	}
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	
	public NamingAttributes(String prefix, String suffix){
		this.prefix = prefix;
		this.suffix = suffix;
	}
	
	

}
