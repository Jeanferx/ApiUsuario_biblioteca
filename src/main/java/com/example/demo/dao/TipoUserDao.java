package com.example.demo.dao;

import com.example.demo.model.TipoUserModel;

public interface TipoUserDao {
	TipoUserModel getTipoUserById(String usertipoId);
	TipoUserModel createTipoUser(TipoUserModel tipoUserModel);
}
