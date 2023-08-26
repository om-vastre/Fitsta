package com.fitsta.fitsta.Repository;

import org.springframework.data.repository.CrudRepository;

import com.fitsta.fitsta.Entity.Task;

public interface TaskRepository extends CrudRepository<Task, Integer>{
    
}
