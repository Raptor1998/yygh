package com.raptor.yygh.order.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.raptor.yygh.common.result.Result;
import com.raptor.yygh.enums.OrderStatusEnum;
import com.raptor.yygh.model.order.OrderInfo;
import com.raptor.yygh.order.service.OrderService;
import com.raptor.yygh.vo.order.OrderCountQueryVo;
import com.raptor.yygh.vo.order.OrderQueryVo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author raptor
 * @description ServiceOrderController
 * @date 2022/5/10 10:34
 */
@Api(tags = "订单接口")
@RestController
@RequestMapping("/admin/order/orderInfo")
public class ServiceOrderController {
    @Autowired
    private OrderService orderService;

    //获取分页列表
    @GetMapping("{page}/{limit}")
    public Result index(@PathVariable Long page,
                        @PathVariable Long limit,
                        OrderQueryVo orderQueryVo){

        Page<OrderInfo> pageParam = new Page<>(page, limit);
        IPage<OrderInfo> pageModel = orderService.selectPage(pageParam, orderQueryVo);
        return Result.ok(pageModel);
    }

    //获取订单状态
    @GetMapping("getStatusList")
    public Result getStatusList() {
        return Result.ok(OrderStatusEnum.getStatusList());
    }

    //获取订单
    @GetMapping("show/{id}")
    public Result get(@PathVariable Long id) {
        Map<String, Object> map = orderService.show(id);
        return Result.ok(map);
    }

    //获取订单统计数量
    @PostMapping("inner/getCountMap")
    public Map<String, Object> getCountMap(@RequestBody OrderCountQueryVo orderCountQueryVo) {
        return orderService.getCountMap(orderCountQueryVo);
    }
}
