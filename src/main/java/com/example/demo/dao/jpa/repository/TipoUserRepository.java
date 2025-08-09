package com.example.demo.dao.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.dao.jpa.entity.TipoUserEntity;

public interface TipoUserRepository extends JpaRepository<TipoUserEntity, String> {
    // no necesita métodos adicionales si solo usas findById y save
}
