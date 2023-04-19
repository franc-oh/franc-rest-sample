package com.franc.sample.mapper;


import com.franc.sample.vo.MbspAndMyMbspVo;
import com.franc.sample.vo.MbspVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface MbspMapper {

    MbspVO findById(@Param("mbspId")String mbspId) throws Exception;

    List<MbspAndMyMbspVo> findAllAndMyMbspYn(Map<String, Object> paramMap) throws Exception;

    MbspAndMyMbspVo findByIdAndMyMbspInfo(Map<String, Object> paramMap) throws Exception;


}
