package com.franc.sample.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.franc.sample.code.Code;
import com.franc.sample.dto.MyMbspJoinDTO;
import com.franc.sample.dto.MyMbspWithdrawalDTO;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/mbsp/my", produces = MediaTypes.HAL_JSON_VALUE)
@RequiredArgsConstructor
public class MyMbspController {

    private static final Logger logger = LoggerFactory.getLogger(MyMbspController.class);

    private final ObjectMapper objectMapper;

    @PostMapping
    public ResponseEntity<?> join(@RequestBody @Valid MyMbspJoinDTO.Request request) throws Exception {
        MyMbspJoinDTO.Response response = new MyMbspJoinDTO.Response();

        logger.info("멤버십가입_Request => {}", request.toString());


        // #2. 응답처리
        response.setResultCode(Code.RESPONSE_CODE_SUCCESS);
        response.setResultMessage(Code.RESPONSE_MESSAGE_SUCCESS);

        logger.info("멤버십가입_Response => {}", response.toString());

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<?> withdrawal(@RequestBody @Valid MyMbspWithdrawalDTO.Request request) throws Exception {
        MyMbspWithdrawalDTO.Response response = new MyMbspWithdrawalDTO.Response();

        logger.info("멤버십탈퇴_Request => {}", request.toString());


        // #2. 응답처리
        response.setResultCode(Code.RESPONSE_CODE_SUCCESS);
        response.setResultMessage(Code.RESPONSE_MESSAGE_SUCCESS);

        logger.info("멤버십탈퇴_Response => {}", response.toString());

        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

}
