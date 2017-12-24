package com.img.app.service;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.img.app.controller.model.ImgModel;
import com.img.app.repository.ImageRespository;

@Service
public class ImageServiceImpl implements ImageService{
	
	@Autowired
	private ImageRespository imageRespository;
	
	public ImgModel<byte[]> getMemberImage(Integer groupId, Integer memberId) throws Exception {

		ImgModel<BufferedImage> image = imageRespository.getImage(groupId, memberId);

	    ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    ImageIO.write(image.getBufferImage(), "png", baos);
	    byte[] imageData = baos.toByteArray();
		
		
		return new ImgModel<byte[]>() {{setBufferImage(imageData);setHttpStatus(image.getHttpStatus());}};
	}

}
