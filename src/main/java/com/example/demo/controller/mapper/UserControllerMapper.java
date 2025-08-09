package com.example.demo.controller.mapper;

import com.example.demo.controller.dto.request.CreateUserDTO;
import com.example.demo.controller.dto.response.CreateUserResponseDTO;
import com.example.demo.model.UserModel;

public interface UserControllerMapper {
	UserModel dtoToModel(CreateUserDTO dto);
	
	CreateUserResponseDTO modelToDto(UserModel model);
}
