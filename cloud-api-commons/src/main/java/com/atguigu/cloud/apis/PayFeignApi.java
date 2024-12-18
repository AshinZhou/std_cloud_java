package com.atguigu.cloud.apis;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "cloud-payment-service")
public interface PayFeignApi {
}
