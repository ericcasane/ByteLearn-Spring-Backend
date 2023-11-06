package com.tecnocampus.erjose.application.dto;

import java.util.List;

public record CourseCategoryDTO (
        List<Long> categoryIds,
        int position
){
}
