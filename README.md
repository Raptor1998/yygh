# spring cloud - 预约挂号项目

[B站相关视频](https://www.bilibili.com/video/BV1V5411K7rT)

## 模块说明

+ common  通用模块
  + common_util   异常处理、统一返回等
  + rabbit_util  mq发送
  + service_util  公共配置、redis、swagger等
+ hospital_manager  模拟的医院方接口
+ model    数据模型
+ service   各个服务
  + service_cmn   数据字典
  + service_hosp  医院管理
  + service_msm 短信服务
  + service_order  订单服务
  + service_oss   对象存储
  + service_statistics  统计，模块
  + service_task   定时任务
  + service_user  用户管理
+ service_client  rpc
  + service_cmn_client  数据字典远程
  + service_hosp_client  医院管理远程
  + service_order_client  订单管理远程
  + service_user_client  用户管理远程
+ service_gateway   网关
