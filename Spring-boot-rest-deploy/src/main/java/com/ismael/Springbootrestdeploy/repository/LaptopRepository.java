package com.ismael.Springbootrestdeploy.repository;

import com.ismael.Springbootrestdeploy.entities.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LaptopRepository extends JpaRepository<Laptop,Long> {



}
