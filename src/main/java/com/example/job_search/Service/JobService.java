package com.example.job_search.Service;

import com.example.job_search.Model.Job;
import com.example.job_search.Repositiory.JobRepository;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class JobService implements JobProfileInterface {
    @Autowired
    JobRepository jobRepository;
    @Autowired
    MongoClient mongoClient;
    @Autowired
    MongoConverter mongoConverter;

    @Override
    public List<Job> getAllPosts() {
        return jobRepository.findAll();
    }

    @Override
    public Job addPost(Job job) {
        return jobRepository.save(job);
    }

    @Override
    public List<Job> getSearchByText(String text) {
        final List<Job> jobpost = new ArrayList<>();
        MongoDatabase database = mongoClient.getDatabase("joblisting");
        MongoCollection<Document> collection = database.getCollection("jobPost");
        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search",
                        new Document("index", "default")
                                .append("text",
                                        new Document("query", text)
                                                .append("path", Arrays.asList("Profile", "techs", "desc")))),
                new Document("$sort",
                        new Document("exp", 1L)),
                new Document("$limit", 4L)));
        result.forEach(doc -> jobpost.add(mongoConverter.read(Job.class,doc)));
        return jobpost;
    }




}
