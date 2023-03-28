package com.example.job_search.Model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "jobPost")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Job {
    private String Profile;
    private String desc;
    private int exp;

    private String[]  techs;
}
