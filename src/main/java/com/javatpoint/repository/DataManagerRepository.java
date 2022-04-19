package com.javatpoint.repository;

import com.javatpoint.model.Dm_Config;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataManagerRepository extends JpaRepository<Dm_Config, Long> {

}
