package com.ehealth.repository;

import com.ehealth.entity.Analyse;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface AnalyseRepository extends JpaRepository<Analyse, Long> {

}
