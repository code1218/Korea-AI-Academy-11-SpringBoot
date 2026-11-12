package com.korai.study02.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Study API", description = "학습용 기본 CRUD 테스트 API")
@RequestMapping("/api/study")
@RestController
public class StudyController {

    private String test;

    @Operation(summary = "데이터 등록 (POST)", description = "새로운 학습 데이터를 생성합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "등록 성공"),
            @ApiResponse(responseCode = "400", description = "잘못된 요청")
    })
    @PostMapping("/a")
    public String post() {
        return "";
    }

    @Operation(summary = "데이터 조회 (GET)", description = "학습 데이터를 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "조회 성공"),
            @ApiResponse(responseCode = "404", description = "데이터를 찾을 수 없음")
    })
    @GetMapping("/b")
    public String get() {
        return "";
    }

    @Operation(summary = "데이터 수정 (PUT)", description = "기존 학습 데이터를 수정합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "수정 성공"),
            @ApiResponse(responseCode = "400", description = "잘못된 요청"),
            @ApiResponse(responseCode = "404", description = "수정할 데이터를 찾을 수 없음")
    })
    @PutMapping("/c")
    public String put() {
        return "";
    }

    @Operation(summary = "데이터 삭제 (DELETE)", description = "학습 데이터를 삭제합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "삭제 성공"),
            @ApiResponse(responseCode = "404", description = "삭제할 데이터를 찾을 수 없음")
    })
    @DeleteMapping("/d")
    public String delete() {
        return "";
    }
}

