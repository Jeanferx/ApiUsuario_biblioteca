package com.example.demo.controller.mapper.impl;

import org.springframework.stereotype.Component;

import com.example.demo.controller.dto.request.CreateUserDTO;
import com.example.demo.controller.dto.response.CreateUserResponseDTO;
import com.example.demo.controller.mapper.UserControllerMapper;
import com.example.demo.model.UserModel;

/**
 * Este codigo se ve demasiado feo, existen herramientas que lo hacen automaticamente como mapstruct
 * Pero ya llegaremos a eso, por ahora tocara manual
 * */
@Component
public class UserControllerMapperImpl implements UserControllerMapper {
	@Override
	public UserModel dtoToModel(CreateUserDTO dto) {
		if(dto == null)
			return null;
		
		UserModel model = new UserModel();
		model.setName(dto.getName());
		model.setDateOfBirth(dto.getDateOfBirth());
		model.setEmail(dto.getEmail());
		model.setPasswd(dto.getPasswd());
		return model;
	}

	@Override
	public CreateUserResponseDTO modelToDto(UserModel model) {
		if(model == null)
			return null;
		
		CreateUserResponseDTO dto = new CreateUserResponseDTO();
		dto.setId(model.getId());
		return dto;
	}

}
