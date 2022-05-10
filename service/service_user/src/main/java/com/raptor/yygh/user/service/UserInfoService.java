package com.raptor.yygh.user.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.raptor.yygh.model.user.UserInfo;
import com.raptor.yygh.vo.user.LoginVo;
import com.raptor.yygh.vo.user.UserAuthVo;
import com.raptor.yygh.vo.user.UserInfoQueryVo;

import java.util.Map;

public interface UserInfoService extends IService<UserInfo> {

    //用户手机号登录
    Map<String, Object> loginUser(LoginVo loginVo);

    //根据openid判断
    UserInfo selectWxInfoOpenId(String openid);

    //用户认证接口
    void userAuth(Long userId, UserAuthVo userAuthVo);

    //用户列表（条件查询带分页）
    IPage<UserInfo> selectPage(Page<UserInfo> pageParam, UserInfoQueryVo userInfoQueryVo);

    //用户锁定功能
    void lock(long userId, Integer status);

    //用户详情功能
    Map<String, Object> show(long userId);

    //认证审批接口
    void approval(long userId, Integer authStatus);
}
