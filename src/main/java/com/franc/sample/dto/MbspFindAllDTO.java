package com.franc.sample.dto;

import lombok.*;

import java.util.List;

public class MbspFindAllDTO {

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @ToString
    public static class Response {
        private String resultCode;
        private String resultMessage;

        private Integer mbspCnt;

        private List<MbspInfo> mbspList;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @ToString
    public static class MbspInfo {

        private String mbspId;
        private String mbspNm;
        private String mbspInfo;
        private String mbspImgUrl;
        private String myMbspYn;

    }
}
