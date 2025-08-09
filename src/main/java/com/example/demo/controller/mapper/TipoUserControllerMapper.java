package com.example.demo.controller.mapper;

import com.example.demo.controller.dto.request.CreateTipoUserDTO;
import com.example.demo.controller.dto.response.CrearTipoUserDTO;
import com.example.demo.model.TipoUserModel;

public interface TipoUserControllerMapper {
	TipoUserModel dtoToModel(CreateTipoUserDTO dto);
	
	CrearTipoUserDTO modelToDto(TipoUserModel model);
}
