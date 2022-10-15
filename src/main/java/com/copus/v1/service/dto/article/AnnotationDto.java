package com.copus.v1.service.dto.article;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnnotationDto {
    private String id;
    private String name;
    private String body;
}