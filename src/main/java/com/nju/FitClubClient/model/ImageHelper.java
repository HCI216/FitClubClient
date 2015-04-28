package com.nju.FitClubClient.model;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "ImageHelper")
public class ImageHelper {
	private byte[] bytes;
	private long position;

	public byte[] getBytes() {
		return bytes;
	}

	public void setBytes(byte[] bytes) {
		this.bytes = bytes;
	}

	public long getPosition() {
		return position;
	}

	public void setPosition(long position) {
		this.position = position;
	}

}
