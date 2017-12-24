package com.img.app.controller.model;

import org.springframework.http.HttpStatus;

public class ImgModel<T> {
	
	private T bufferImage;
	
	private HttpStatus httpStatus;

	public T getBufferImage() {
		return bufferImage;
	}

	public void setBufferImage(T bufferImage) {
		this.bufferImage = bufferImage;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}
	
	

}
