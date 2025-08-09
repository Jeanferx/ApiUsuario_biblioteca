package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.TipoUserDao;
import com.example.demo.model.TipoUserModel;
import com.example.demo.service.TipoUserService;
@Service
public class TipoUserServiceImpl implements TipoUserService {
    @Autowired
    private TipoUserDao tipoUserDao;
    
    public TipoUserServiceImpl(TipoUserDao tipoUserDao) {
        this.tipoUserDao = tipoUserDao;
    }
    
    @Override
    @Transactional
    public TipoUserModel getTipoUserById(String usertipoId) {
        System.out.println("Peticion de obtener el user con id " + usertipoId);
        return tipoUserDao.getTipoUserById(usertipoId);
    }

    @Override
    @Transactional
    public TipoUserModel createTipoUser(TipoUserModel tipo_usuario) {
        System.out.println("Creando un tipo de usuario nuevo");
        return tipoUserDao.createTipoUser(tipo_usuario);
    }
}
