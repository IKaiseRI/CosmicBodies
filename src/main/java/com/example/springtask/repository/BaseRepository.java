package com.example.springtask.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepository<ELEMENT> extends JpaRepository<ELEMENT, Long> {
}
