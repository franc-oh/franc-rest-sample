package com.franc.sample.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ExceptionResult {

    NOT_FOUND_ACNT(HttpStatus.BAD_REQUEST, "존재하지 않는 회원입니다."),
    NOT_ACTIVE_ACNT(HttpStatus.BAD_REQUEST, "해당 회원은 현재 정지(탈퇴) 상태 입니다."),
    NOT_FOUND_MBSP(HttpStatus.BAD_REQUEST, "존재하지 않는 멤버십입니다."),
    NOT_ACTIVE_MBSP(HttpStatus.BAD_REQUEST, "해당 멤버십은 현재 정지 상태 입니다."),
    ALREADY_JOIN_MY_MBSP(HttpStatus.BAD_REQUEST, "이미 가입한 멤버십입니다."),
    CREATE_BARCODE_FAIL(HttpStatus.BAD_REQUEST, "바코드 생성에 실패했습니다."),
    REJOIN_NOT_YET(HttpStatus.BAD_REQUEST, "탈퇴 당일은 재가입이 불가합니다."),
    NOT_JOIN_MBSP(HttpStatus.BAD_REQUEST, "멤버십 가입이력이 없습니다."),
    ALREADY_WITHDRAWAL_MBSP(HttpStatus.BAD_REQUEST, "이미 탈퇴한 멤버십입니다."),
    NOT_FOUND_MBSP_TO_BARCODE(HttpStatus.BAD_REQUEST, "해당 바코드로 가입한 내역이 없습니다."),
    NOT_ACTIVE_FRANCHISEE(HttpStatus.BAD_REQUEST, "해당 가맹점은 현재 정지 상태 입니다."),



    PARAMETER_NOT_VALID(HttpStatus.BAD_REQUEST, "잘못된 요청 데이터입니다."),
    UNKNOWN_EXCEPTION(HttpStatus.INTERNAL_SERVER_ERROR, "오류가 발생했습니다. <br/>고객센터(1588-9999)로 문의주세요.");

    private final HttpStatus code;
    private final String message;
}
