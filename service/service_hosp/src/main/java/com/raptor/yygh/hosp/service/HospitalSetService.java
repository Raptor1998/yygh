package com.raptor.yygh.hosp.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.raptor.yygh.model.hosp.HospitalSet;
import com.raptor.yygh.vo.order.SignInfoVo;
import org.springframework.stereotype.Service;

@Service
public interface HospitalSetService extends IService<HospitalSet> {
    //根据传递过来的医院编码，查询数据库，查询签名
    String getSignKey(String hospcode);

    //获取医院签名信息
    SignInfoVo getSignInfoVo(String hoscode);
}
