package com.example.demo.dao.jpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tipo_usuario")
@Data
public class TipoUserEntity {

    @Id
    private String id;

    private String userTipo;

}
