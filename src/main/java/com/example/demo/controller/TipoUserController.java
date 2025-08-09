package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.controller.dto.request.CreateTipoUserDTO;
import com.example.demo.controller.dto.response.CrearTipoUserDTO;
import com.example.demo.controller.mapper.TipoUserControllerMapper;
import com.example.demo.model.TipoUserModel;
import com.example.demo.service.TipoUserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/Tipo")
public class TipoUserController {
	@Autowired
	private TipoUserService tipoUserService;
	@Autowired
	private TipoUserControllerMapper mapper;
	
	@GetMapping("/{usertipoId}")
	public TipoUserModel getTipoUserById(@PathVariable("usertipoId")String usertipoId) {
		return tipoUserService.getTipoUserById(usertipoId);
	}
	@PostMapping
	public CrearTipoUserDTO createTipoUser(@Valid @RequestBody CreateTipoUserDTO tipo_usuario) {
	    try {
	        System.out.println("TIPO USUARIO recibido: " + tipo_usuario.getTipousuario());

	        TipoUserModel model = new TipoUserModel();
	        model.setTipousuario(tipo_usuario.getTipousuario());

	        TipoUserModel saved = tipoUserService.createTipoUser(model);

	        System.out.println("TIPO USUARIO guardado con id: " + saved.getId());

	        return mapper.modelToDto(saved);
	    } catch (Exception e) {
	        e.printStackTrace();
	        throw e;
	    }
	}


	public void setMapper(TipoUserControllerMapper mapper) {
		this.mapper = mapper;
	}
}
