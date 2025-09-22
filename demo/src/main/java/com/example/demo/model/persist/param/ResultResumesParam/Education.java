package com.example.demo.model.persist.param.ResultResumesParam;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Education {
    @JsonProperty("school")
    private String school;

    @JsonProperty("degree")
    private String degree;

    @JsonProperty("duration")
    private String duration;
}
    