package br.com.guilhermea23.todolist.task;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface InterfaceTaskRepository extends JpaRepository<Task, UUID> {
    
}
