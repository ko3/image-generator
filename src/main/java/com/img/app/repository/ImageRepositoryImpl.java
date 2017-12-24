package com.img.app.repository;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import com.img.app.controller.model.ImgModel;

@Repository
public class ImageRepositoryImpl implements ImageRespository{
	
	public ImgModel<BufferedImage> getImage(Integer groupId, Integer memberId){
		
		BufferedImage bufferImage = new BufferedImage(900,600,BufferedImage.TYPE_INT_ARGB);
		formatImage(bufferImage);
		
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
	
	private void formatImage(BufferedImage bufferImage) {
		Graphics2D graphics = bufferImage.createGraphics();
		graphics.setBackground(Color.white);
		graphics.fillRect(0, 0, 900, 600);
		graphics.setColor(Color.black);
		graphics.setFont(new Font("TimesRoman", Font.PLAIN, 50)); 
		
		graphics.drawString("Hello!!", 70, 70);
		
		graphics.drawImage(getLogo(), null, 100, 100);
		
		graphics.dispose();
	}
}
