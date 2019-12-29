package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        paymentService.create(payment);
        return new CommonResult(200,"success",payment);
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        System.out.println("get:8001");
        Payment payment = paymentService.getPaymentById(id);
        return new CommonResult(200,"success",payment);
    }

    @GetMapping(value = "/payment/delete/{id}")
    public CommonResult delete(@PathVariable("id") Long id) {
        paymentService.delete(id);
        return new CommonResult(200,"success",null);
    }

    @PostMapping(value = "/payment/update")
    public CommonResult update(@RequestBody Payment payment) {
        paymentService.update(payment);
        return new CommonResult(200,"success",null);
    }

    @GetMapping(value = "/payment/list")
    public CommonResult list() {
        System.out.println("list:8001");
        List<Payment> list = paymentService.list();
        return new CommonResult(200,"success",list);
    }
}
