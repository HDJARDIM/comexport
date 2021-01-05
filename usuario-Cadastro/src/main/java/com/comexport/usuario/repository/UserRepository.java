package com.comexport.usuario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.comexport.usuario.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {}