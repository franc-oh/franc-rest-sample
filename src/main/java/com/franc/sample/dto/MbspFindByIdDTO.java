package com.franc.sample.dto;

import lombok.*;
public class MbspFindByIdDTO {

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @ToString
    public static class Response {
        private String resultCode;
        private String resultMessage;

        private String mbspId;
        private String mbspNm;
        private String mbspInfo;
        private String mbspImgUrl;
        private String homepageUrl;

        private MyMbspInfo myMbspInfo;

    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @ToString
    public static class MyMbspInfo {

        private String statusNm;
        private String mbspGrdCd;
        private Integer totalAccumPoint;
        private String barCd;

    }
}
