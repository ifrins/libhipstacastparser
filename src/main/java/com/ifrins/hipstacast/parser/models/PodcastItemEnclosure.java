package com.ifrins.hipstacast.parser.models;

public class PodcastItemEnclosure {
	public String url;
	public long length;
	public int enclosureType;
	
	public static final int TYPE_AUDIO = 0;
	public static final int TYPE_VIDEO = 1;
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public void setLength(long length) {
		this.length = length;
	}
	
	public void setType(String type) {
		this.enclosureType = TYPE_AUDIO;
	}
}
