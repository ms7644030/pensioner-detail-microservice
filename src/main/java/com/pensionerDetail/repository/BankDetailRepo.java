package com.pensionerDetail.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pensionerDetail.entities.Bankdetail;


public interface BankDetailRepo extends JpaRepository<Bankdetail, Long>{

}
