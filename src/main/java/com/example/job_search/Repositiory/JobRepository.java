package com.example.job_search.Repositiory;

import com.example.job_search.Model.Job;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends MongoRepository<Job,String> {

}
