package com.franc.sample.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.franc.sample.code.Code;
import com.franc.sample.dto.MbspFindAllDTO;
import com.franc.sample.dto.MbspFindByIdDTO;
import com.franc.sample.exception.BizException;
import com.franc.sample.exception.ExceptionResult;
import com.franc.sample.service.MbspService;
import com.franc.sample.vo.MbspAndMyMbspVo;
import com.franc.sample.vo.MyMbspVO;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@RestController
@RequestMapping(value = "/api/v2/mbsp", produces = MediaTypes.HAL_JSON_VALUE)
@RequiredArgsConstructor
public class MbspV2Controller {

    private static final Logger logger = LoggerFactory.getLogger(MbspV2Controller.class);

    private final MbspService mbspService;

    private final ObjectMapper objectMapper;


    /**
     * 멤버십 리스트 조회 (멤버십 가입여부 포함)
     */
    @GetMapping
    public ResponseEntity<?> getMbsps(@RequestHeader(required = false) Long acntId,
                                      @RequestParam(required = false) Integer pageNo, @RequestParam(required = false) Integer pageLimit) throws Exception {
        MbspFindAllDTO.Response response = new MbspFindAllDTO.Response();

        // #1. 멤버십리스트 가져오기
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("acntId", acntId);
        paramMap.put("pageNo", pageNo);
        paramMap.put("pageLimit", pageLimit);
        List<MbspAndMyMbspVo> procList = mbspService.findAllAndMyMbspYn(paramMap);

        // #2. 응답처리
        response.setResultCode(Code.RESPONSE_CODE_SUCCESS);
        response.setResultMessage(Code.RESPONSE_MESSAGE_SUCCESS);

        if(!procList.isEmpty()) {
            response.setMbspCnt(procList.size());
            response.setMbspList(objectMapper.convertValue(procList,
                    TypeFactory.defaultInstance().constructCollectionType(List.class, MbspFindAllDTO.MbspInfo.class)
            ));
        }

        return new ResponseEntity<>(response, HttpStatus.OK);

    }



    /**
     * 멤버십 상세 조회 (멤버십 가입정보 포함)
     */
    @GetMapping("/{mbspId}")
    public ResponseEntity<EntityModel<?>> getMbsp(@PathVariable String mbspId, @RequestHeader(required = false) Long acntId) throws Exception {
        MbspFindByIdDTO.Response response = new MbspFindByIdDTO.Response();

        // #1. 멤버십상세 가져오기
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("mbspId", mbspId);
        paramMap.put("acntId", acntId);
        MbspAndMyMbspVo procVo = mbspService.findByIdAndMyMbspInfo(paramMap);
        if(procVo == null) {
            throw new BizException(ExceptionResult.NOT_FOUND_MBSP);
        }

        // #2. 응답처리
        response = objectMapper.convertValue(procVo, MbspFindByIdDTO.Response.class);

        MyMbspVO myMbspInfo = procVo.getMyMbspInfo();
        if(myMbspInfo != null) {
            response.setMyMbspInfo(objectMapper.convertValue(myMbspInfo, MbspFindByIdDTO.MyMbspInfo.class));
        }

        response.setResultCode(Code.RESPONSE_CODE_SUCCESS);
        response.setResultMessage(Code.RESPONSE_MESSAGE_SUCCESS);

        EntityModel entityModel = EntityModel.of(response);
        entityModel.add(linkTo(methodOn(this.getClass()).getMbsp(mbspId, acntId)).withSelfRel());
        entityModel.add(linkTo(methodOn(this.getClass()).getMbsps(acntId, Code.DEFAULT_PAGE_NO, Code.DEFAULT_PAGE_LIMIT)).withRel("getMbsps"));

        return new ResponseEntity<>(entityModel, HttpStatus.OK);

    }


}
