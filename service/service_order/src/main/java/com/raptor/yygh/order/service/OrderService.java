package com.raptor.yygh.order.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.raptor.yygh.model.order.OrderInfo;
import com.raptor.yygh.vo.order.OrderCountQueryVo;
import com.raptor.yygh.vo.order.OrderQueryVo;

import java.util.Map;

public interface OrderService extends IService<OrderInfo> {
    //生成挂号订单
    Long saveOrder(String scheduleId, Long patientId);

    //根据订单id查询订单详情信息
    OrderInfo getOrder(String orderId);

    //订单列表（条件查询带分页）
    IPage<OrderInfo> selectPage(Page<OrderInfo> pageParam, OrderQueryVo orderQueryVo);

    //获取订单
    Map<String,Object> show(Long orderId);

    //取消预约
    Boolean cancelOrder(Long orderId);

    //就诊通知
    void patientTips();

    //预约统计方法
    Map<String, Object> getCountMap(OrderCountQueryVo orderCountQueryVo);
}
