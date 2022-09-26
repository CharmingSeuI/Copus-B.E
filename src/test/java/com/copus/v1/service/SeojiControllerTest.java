package com.copus.v1.service;

import com.copus.v1.service.dto.SeojiFilter;
import com.copus.v1.service.dto.SeojiPreviewDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class SeojiControllerTest {
    @Autowired
    private SeojiController seojiController;
}