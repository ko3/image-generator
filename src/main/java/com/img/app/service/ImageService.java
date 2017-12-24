package com.img.app.service;

import com.img.app.controller.model.ImgModel;

public interface ImageService {
	
	ImgModel<byte[]> getMemberImage(Integer groupId, Integer memberId) throws Exception;

}
