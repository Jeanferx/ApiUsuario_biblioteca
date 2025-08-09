package com.example.demo.controller.mapper.impl;

import org.springframework.stereotype.Component;

import com.example.demo.controller.dto.request.CreateTipoUserDTO;
import com.example.demo.controller.dto.response.CrearTipoUserDTO;
import com.example.demo.controller.mapper.TipoUserControllerMapper;
import com.example.demo.model.TipoUserModel;

/**
 * Este codigo se ve demasiado feo, existen herramientas que lo hacen automaticamente como mapstruct
 * Pero ya llegaremos a eso, por ahora tocara manual
 * */
@Component
public class TipoUserControllerMapperImpl implements TipoUserControllerMapper{
	@Override
	public TipoUserModel dtoToModel(CreateTipoUserDTO dto) {
		if(dto == null)
			return null;
		
		TipoUserModel model = new TipoUserModel();
		model.setTipousuario(dto.getTipousuario());
		return model;
	}
	
	@Override
	public CrearTipoUserDTO modelToDto(TipoUserModel model) {
		if(model == null)
			return null;
		
		CrearTipoUserDTO dto = new CrearTipoUserDTO();
		dto.setId(model.getId());
		return dto;
	}
}
