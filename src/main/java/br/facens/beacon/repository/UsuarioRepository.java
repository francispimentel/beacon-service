package br.facens.beacon.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.facens.beacon.model.UsuarioModel;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long>{

}
