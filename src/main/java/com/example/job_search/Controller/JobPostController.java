package com.example.job_search.Controller;


import com.example.job_search.Model.Job;
import com.example.job_search.Service.JobProfileInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
public class JobPostController {
    @Autowired
    JobProfileInterface jobProfileInterface;
    @ApiIgnore
    @RequestMapping(value="/")
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }

    @GetMapping("/Posts")
    public List<Job> getAllPost(){
       return jobProfileInterface.getAllPosts();
    }

    @PostMapping("/postinfo")
    public Job submitPostDetails(@RequestBody Job job){
        return jobProfileInterface.addPost(job);
    }

    @GetMapping("/Post/{text}")
    public List<Job> getAllPostwithgivenText(@PathVariable String text)
    {
        return jobProfileInterface.getSearchByText(text);
    }
}
