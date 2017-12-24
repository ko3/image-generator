package com.img.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.img.app.controller.model.ImgModel;
import com.img.app.service.ImageService;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.http.MediaType.IMAGE_PNG_VALUE;

@RestController
public class ImgController {
	
	@Autowired
	private ImageService imageService;
	
	@RequestMapping(value="/api/image/{groupId}/{memberId}", method = GET,produces = IMAGE_PNG_VALUE)
	public ResponseEntity<byte[]> getImage(@PathVariable Integer groupId,
											@PathVariable Integer memberId) throws Exception{
		
		
	    ImgModel<byte[]> imgModel = imageService.getMemberImage(groupId, memberId);
 		return new ResponseEntity<byte[]>(imgModel.getBufferImage(), imgModel.getHttpStatus());
	}

}
