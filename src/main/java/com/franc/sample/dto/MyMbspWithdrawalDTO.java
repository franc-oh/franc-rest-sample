package com.franc.sample.dto;

import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class MyMbspWithdrawalDTO {

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @ToString
    public static class Request {
        @NotNull
        @Min(1)
        private Long acntId;

        @NotNull
        private String mbspId;
    }


    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @ToString
    public static class Response {
        private String resultCode;
        private String resultMessage;
    }
}
