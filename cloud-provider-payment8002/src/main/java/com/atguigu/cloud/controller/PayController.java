package com.atguigu.cloud.controller;

import com.atguigu.cloud.entities.Pay;
import com.atguigu.cloud.entities.PayDTO;
import com.atguigu.cloud.resp.ResultData;
import com.atguigu.cloud.service.PayService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("pay")
public class PayController {
    @Resource
    private PayService payService;

    @PostMapping("add")
    @Operation(summary = "新增", description = "新增支付流水方法吗,json 串做参数")
    public ResultData<String> addPay(@RequestBody Pay pay) {
        System.out.println(pay.toString());
        int i = payService.add(pay);
        return ResultData.success("成功返回记录" + i);
    }

    @DeleteMapping("delete/{id}")
    public ResultData<String> deletePay(@PathVariable("id") Integer id) {
        System.out.println("删除的 id" + id);
        int i = payService.delete(id);
        return ResultData.success("成功删除记录" + i);
    }

    @PutMapping("update")
    public ResultData<String> updatePay(@RequestBody PayDTO payDto) {
        Pay pay = new Pay();
        BeanUtils.copyProperties(payDto, pay);
        int i = payService.update(pay);
        return ResultData.success("成功修改数据" + i);
    }


    @GetMapping("get/{id}")
    public ResultData<Pay> getPayById(@PathVariable("id") Integer id) {
        return ResultData.success(payService.getPayById(id));
    }

    @GetMapping("get")
    public ResultData<List<Pay>> getPayDTO() {
        return ResultData.success(payService.getPayList());
    }

    @Value("${server.port}")
    private String port;

    @GetMapping("get/info")
    public String getInfoByConsul(@Value("${atguigu.info}") String info) {
        return "atguiguInfo :" + info + "\t" + "port:" + port;
    }

}
