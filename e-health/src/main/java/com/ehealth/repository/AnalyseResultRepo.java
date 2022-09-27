package com.ehealth.repository;

import com.ehealth.entity.AnalyseResults;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnalyseResultRepo extends JpaRepository<AnalyseResults, Long> {

}
