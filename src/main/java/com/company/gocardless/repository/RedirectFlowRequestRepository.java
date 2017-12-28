package com.company.gocardless.repository;

import com.company.gocardless.entity.RedirectFlowRequest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RedirectFlowRequestRepository extends CrudRepository<RedirectFlowRequest, Long> {
}
