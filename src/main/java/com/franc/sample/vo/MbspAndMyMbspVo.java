package com.franc.sample.vo;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class MbspAndMyMbspVo extends MbspVO {

    private String myMbspYn;
    private MyMbspVO myMbspInfo;

}
