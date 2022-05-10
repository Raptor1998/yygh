package com.raptor.yygh.user.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.raptor.yygh.common.result.Result;
import com.raptor.yygh.model.user.UserInfo;
import com.raptor.yygh.user.service.UserInfoService;
import com.raptor.yygh.vo.user.LoginVo;
import com.raptor.yygh.vo.user.UserInfoQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author raptor
 * @description UserInfoController
 * @date 2022/5/9 15:54
 */
@RestController
@RequestMapping("/admin/user")
public class UserInfoController {
    @Autowired
    private UserInfoService userInfoService;

    //用户列表（条件查询带分页）
    @GetMapping("{page}/{limit}")
    public Result list(@PathVariable("page") long page,
                       @PathVariable("limit") long limit,
                       UserInfoQueryVo userInfoQueryVo){
        Page<UserInfo> pageParam = new Page<>(page,limit);
        IPage<UserInfo> pageModel = userInfoService.selectPage(pageParam,userInfoQueryVo);
        return Result.ok(pageModel);
    }

    //用户锁定功能
    @GetMapping("lock/{userId}/{status}")
    public Result lock(@PathVariable("userId") long userId,
                       @PathVariable("status") Integer status){
        userInfoService.lock(userId,status);
        return Result.ok();
    }

    //用户详情功能
    @GetMapping("show/{userId}")
    public Result show(@PathVariable("userId") long userId){
        Map<String,Object> map = userInfoService.show(userId);
        return Result.ok(map);
    }

    //认证审批接口
    @GetMapping("approval/{userId}/{authStatus}")
    public Result approval(@PathVariable("userId") long userId,
                           @PathVariable("authStatus") Integer authStatus){
        userInfoService.approval(userId,authStatus);
        return Result.ok();
    }

}
