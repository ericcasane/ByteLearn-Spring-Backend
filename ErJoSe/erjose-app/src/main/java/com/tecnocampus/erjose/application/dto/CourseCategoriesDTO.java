package com.tecnocampus.erjose.application.dto;

import java.util.List;

public record CourseCategoriesDTO(
        List<Long> categoryIds,
        List<Integer> categoryPositions
){
}
