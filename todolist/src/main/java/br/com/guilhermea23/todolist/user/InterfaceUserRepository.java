package br.com.guilhermea23.todolist.user;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;


public interface InterfaceUserRepository extends JpaRepository <User, UUID> {
    User findByUsername(String username);
}
