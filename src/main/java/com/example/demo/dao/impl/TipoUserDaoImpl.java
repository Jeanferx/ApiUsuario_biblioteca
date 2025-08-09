package com.example.demo.dao.impl;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.TipoUserDao;
import com.example.demo.dao.jpa.entity.TipoUserEntity;
import com.example.demo.dao.jpa.repository.TipoUserRepository;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.TipoUserModel;

@Repository  // <- esta anotación es clave
public class TipoUserDaoImpl implements TipoUserDao {
    @Autowired
    private TipoUserRepository repository;

    @Override
    public TipoUserModel getTipoUserById(String usertipoId) {
        Optional<TipoUserEntity> e = repository.findById(usertipoId);
        TipoUserModel model = new TipoUserModel();

        if (e.isPresent()) {
            model.setId(e.get().getId());
            model.setTipousuario(e.get().getTipousuario());
        } else {
            String errorMsg = "The user with id %s was not found";
            throw new UserNotFoundException(String.format(errorMsg, usertipoId));
        }
        return model;
    }

    @Override
    public TipoUserModel createTipoUser(TipoUserModel tipoUserModel) {
        TipoUserEntity tipoUserEntity = new TipoUserEntity();
        tipoUserEntity.setId(UUID.randomUUID().toString());  // Asignar id único
        tipoUserEntity.setTipousuario(tipoUserModel.getTipousuario());

        tipoUserEntity = repository.save(tipoUserEntity);
        tipoUserModel.setId(tipoUserEntity.getId());

        return tipoUserModel;
    }
}
