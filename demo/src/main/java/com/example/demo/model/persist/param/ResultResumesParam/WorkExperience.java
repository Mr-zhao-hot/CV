package com.example.demo.model.persist.param.ResultResumesParam;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class WorkExperience {
    @JsonProperty("company")
    private String company;

    @JsonProperty("position")
    private String position;

    @JsonProperty("duration")
    private String duration;

    @JsonProperty("description")
    private String description;
}
    