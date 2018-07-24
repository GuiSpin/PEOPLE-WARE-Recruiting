package com.guispin.spring.noesis.recruiting.repository;

import com.guispin.spring.noesis.recruiting.domain.Applicant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicantRepository extends CrudRepository<Applicant, Long> {
}
