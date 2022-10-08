package com.copus.v1.controller.dto;

import com.copus.v1.service.enums.SearchFilter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PreviewRequest {
    private String filter;
    private String keyword;
}