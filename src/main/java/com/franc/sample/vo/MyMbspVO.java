package com.franc.sample.vo;

import com.franc.sample.code.MbspGrd;
import com.franc.sample.code.Status;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Getter
@ToString
@EqualsAndHashCode(of = {"acntId", "mbspId"})
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class MyMbspVO {

    private Long acntId;
    private String mbspId;

    @Builder.Default
    private Character status = Status.USE.getCode();

    @Builder.Default
    private Integer totalAccumPoint = 0;

    @Builder.Default
    private String mbspGrdCd = MbspGrd.COMMON.getCode();
    private LocalDateTime insertDate;

    @Builder.Default
    private LocalDateTime withdrawalDate = null;


    // 조회용
    private String statusNm;
    private String mbspGrdNm;




    public void setStatus(Character status) {
        this.status = status;
        this.statusNm = Status.of(status).getName();
    }

    public void setMbspGrdCd(String mbspGrdCd) {
        this.mbspGrdCd = mbspGrdCd;
        this.mbspGrdNm = MbspGrd.of(mbspGrdCd).getName();
    }

}
