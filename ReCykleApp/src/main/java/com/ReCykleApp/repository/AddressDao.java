package com.ReCykleApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ReCykleApp.module.Addresses;

public interface AddressDao extends JpaRepository<Addresses, Integer>{

}
