package com.img.app.repository;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import com.img.app.controller.model.ImgModel;

import static com.img.app.util.ImageUtil.formatImage;;

@Repository
public class ImageRepositoryImpl implements ImageRespository{
	
	public ImgModel<BufferedImage> getImage(Integer groupId, Integer memberId){
		
		BufferedImage bufferImage = new BufferedImage(900,600,BufferedImage.TYPE_INT_ARGB);
		formatImage(bufferImage, groupId, memberId, getLogo());
		
		return new ImgModel<BufferedImage>() {{setBufferImage(bufferImage);setHttpStatus(HttpStatus.OK);}};
	}
	
	private BufferedImage getLogo() {
		
		BufferedImage logo = null;
		try {
			logo = ImageIO.read(getClass().getResourceAsStream("dobor.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return logo;
	}
}
