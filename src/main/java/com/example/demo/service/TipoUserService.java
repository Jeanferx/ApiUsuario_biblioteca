package com.example.demo.service;

import com.example.demo.model.TipoUserModel;

public interface TipoUserService {
    TipoUserModel getTipoUserById(String usertipoId);
    TipoUserModel createTipoUser(TipoUserModel tipoUserModel);
}
