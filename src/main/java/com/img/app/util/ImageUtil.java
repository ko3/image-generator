package com.img.app.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class ImageUtil {
	
	public static void formatImage(BufferedImage bufferImage, Integer groupId, Integer memberId, BufferedImage logo) {
		Graphics2D graphics = bufferImage.createGraphics();
		graphics.setBackground(Color.white);
		graphics.fillRect(0, 0, 900, 600);
		graphics.setColor(Color.black);
		graphics.setFont(new Font("TimesRoman", Font.PLAIN, 50)); 
		
		graphics.drawString("Hello!!", 70, 70);
		graphics.drawString(groupId.toString(), 250, 70);
		graphics.drawString(memberId.toString(), 450, 70);
		
		graphics.drawImage(logo, null, 100, 100);
		
		graphics.dispose();
	}

}
