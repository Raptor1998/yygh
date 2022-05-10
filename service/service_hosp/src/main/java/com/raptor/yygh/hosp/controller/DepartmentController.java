package com.raptor.yygh.hosp.controller;

import com.raptor.yygh.common.result.Result;
import com.raptor.yygh.hosp.service.DepartmentService;
import com.raptor.yygh.vo.hosp.DepartmentVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/admin/hosp/department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    //根据医院编号，查询所有科室列表
    @ApiOperation("查询所有科室列表")
    @GetMapping("getDepList/{hoscode}")
    public Result getDepList(@PathVariable("hoscode") String hoscode){
        //大科室下面还有小科室，不止一个科室，所以将返回数据封装在DepartmentVo
        List<DepartmentVo> list = departmentService.findDepTree(hoscode);
        return Result.ok(list);
    }
}
