package com.guispin.spring.noesis.recruiting.repository;

import com.guispin.spring.noesis.recruiting.domain.JobOffer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobOfferRepository extends CrudRepository<JobOffer, Long> {
}
