package com.korai.study02.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Tag(name = "Study API 2", description = "List / Map 응답 학습용 API")
@RequestMapping("/api/study2")
@RestController
public class StudyController2 {

    // ===================== List 응답 =====================

    @Operation(summary = "문자열 List 응답", description = "List<String>을 반환하면 JSON 배열로 응답됩니다. 예) [\"사과\", \"바나나\"]")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "조회 성공")
    })
    @GetMapping("/list/strings")
    public List<String> getStringList() {
        List<String> fruits = new ArrayList<>();
        fruits.add("사과");
        fruits.add("바나나");
        fruits.add("포도");
        return fruits;
    }

    @Operation(summary = "숫자 List 응답", description = "List<Integer>를 반환하면 숫자 JSON 배열로 응답됩니다. 예) [10, 20, 30]")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "조회 성공")
    })
    @GetMapping("/list/numbers")
    public List<Integer> getNumberList() {
        return List.of(10, 20, 30, 40, 50);
    }

    // ===================== Map 응답 =====================

    @Operation(summary = "단순 Map 응답", description = "Map<String, Object>를 반환하면 JSON 객체로 응답됩니다. 예) {\"name\": \"홍길동\", \"age\": 20}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "조회 성공")
    })
    @GetMapping("/map")
    public Map<String, Object> getMap() {
        // LinkedHashMap: 넣은 순서대로 JSON 키 순서가 유지됨 (HashMap은 순서 보장 X)
        Map<String, Object> student = new LinkedHashMap<>();
        student.put("name", "홍길동");
        student.put("age", 20);
        student.put("isStudent", true);
        return student;
    }

    @Operation(summary = "Map 안에 List 응답", description = "Map의 값으로 List를 넣으면 객체 안에 배열이 포함된 JSON으로 응답됩니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "조회 성공")
    })
    @GetMapping("/map/with-list")
    public Map<String, Object> getMapWithList() {
        Map<String, Object> result = new LinkedHashMap<>();
        result.put("className", "스프링부트 기초반");
        result.put("subjects", List.of("Java", "Spring", "JPA"));
        return result;
    }

    // ===================== List + Map 조합 =====================

    @Operation(summary = "Map List 응답", description = "List<Map<String, Object>>를 반환하면 객체 배열 JSON으로 응답됩니다. 목록 조회 API에서 많이 쓰는 형태입니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "조회 성공")
    })
    @GetMapping("/list/maps")
    public List<Map<String, Object>> getMapList() {
        List<Map<String, Object>> students = new ArrayList<>();

        Map<String, Object> student1 = new HashMap<>();
        student1.put("id", 1);
        student1.put("name", "홍길동");
        students.add(student1);

        Map<String, Object> student2 = new HashMap<>();
        student2.put("id", 2);
        student2.put("name", "김철수");
        students.add(student2);

        return students;
    }

    @Operation(summary = "공통 응답 형식 (Map)", description = "실무에서 자주 쓰는 {status, message, data} 형태의 응답을 Map으로 만들어 봅니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "조회 성공")
    })
    @GetMapping("/response")
    public Map<String, Object> getCommonResponse() {
        List<Map<String, Object>> data = new ArrayList<>();
        data.add(Map.of("id", 1, "title", "첫 번째 글"));
        data.add(Map.of("id", 2, "title", "두 번째 글"));

        Map<String, Object> response = new LinkedHashMap<>();
        response.put("status", 200);
        response.put("message", "조회 성공");
        response.put("count", data.size());
        response.put("data", data);
        return response;
    }
}
