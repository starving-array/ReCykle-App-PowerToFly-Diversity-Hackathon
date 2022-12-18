package com.ReCykleApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ReCykleApp.module.CurrentSession;


public interface SessionDao extends JpaRepository<CurrentSession, Integer> {

	public CurrentSession findByUuid(String uuid);

}