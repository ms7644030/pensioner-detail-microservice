package com.pensionerDetail.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pensionerDetail.entities.Pensioner;

public interface PensionerRepo extends JpaRepository<Pensioner, Long>{

}
