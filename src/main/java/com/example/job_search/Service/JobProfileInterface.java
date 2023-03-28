package com.example.job_search.Service;

import com.example.job_search.Model.Job;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface JobProfileInterface {

    List<Job> getAllPosts();

   Job addPost(Job job);


    List<Job> getSearchByText(String text);

}
