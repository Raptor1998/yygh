package com.raptor.yygh.msm.service;


import com.raptor.yygh.vo.msm.MsmVo;

public interface MsmService {
    //通过整合短信服务进行发送
    boolean send(String phone, String code);

    //使用mq发送短信
    boolean send(MsmVo msmVo);
}
