package com.copus.v1.service.dto.article;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FinalDataDto {
    private String finalInfoTitle;
    private String content;
    private String DCI;
    private Optional<List<AnnotationDto>> annotations;
}