package com.example.demo.model.persist.param.ResultResumesParam;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.List;

@Data
public class ResumesData {
    @JsonProperty("resumeId")
    private String resumeId;

    @JsonProperty("filename")
    private String filename;

    @JsonProperty("parseStatus")
    private String parseStatus;

    @JsonProperty("candidateName")
    private String candidateName;

    @JsonProperty("contactEmail")
    private String contactEmail;

    @JsonProperty("contactPhone")
    private String contactPhone;

    @JsonProperty("yearsExperience")
    private Integer yearsExperience;

    @JsonProperty("skills")
    private List<String> skills;

    @JsonProperty("workExperiences")
    private List<WorkExperience> workExperiences;

    @JsonProperty("educationSummary")
    private List<Education> educationSummary;

    @JsonProperty("parsedContent")
    private String parsedContent;

    @JsonProperty("createdAt")
    private String createdAt;
}
    