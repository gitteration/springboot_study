package com.springboot.controller;

import com.springboot.request.PostCreate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
public class PostController {
    // http Method로는 GET, POST, PUT, PATCH, DELETE, OPTIONS, HEAD, TRACE, CONNECT가 있다
    // 글 등록으로는 POST Method 사용

    @GetMapping("/posts")
    // @Valid - 설정된 값을 검증해준다.
    public Map<String, String> post(@RequestBody @Valid PostCreate params, BindingResult result){
        if(result.hasErrors()){
            List<FieldError> fieldErrors = result.getFieldErrors();
            FieldError firstFieldError = fieldErrors.get(0);
            String fieldName = firstFieldError.getField(); // title
            String errorMessage = firstFieldError.getDefaultMessage(); // error message
            Map<String, String> error = new HashMap<>();
            error.put(fieldName, errorMessage);
            return error;
        }
        return Map.of();
//        log.info("params={}", params.toString());
//        return "Hellow Spring Boot";
    }


//    parameters을 Map으로 한번에 받을 수도 있고
//    public String post(@RequestParam Map<String, String> params){
//        log.info("params={}", params);
//        return "Hellow Spring Boot";
//    }


//    parameters을 별도로 받을 수 있다
//    public String post(@RequestParam String title, @RequestParam String content){
//            log.info("title={}, content={}", params.title, params.content);
//        return "Hellow Spring Boot";
//}
}
