package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class OrderController {
    @Resource
    private RestTemplate restTemplate;
    private static final String PAYMENT_URL = "http://cloud-payment-service";

    @GetMapping(value = "/consumer/payment/create")
    public CommonResult create(Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
    }

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class, id);
    }

    @GetMapping(value = "/consumer/payment/delete/{id}")
    public CommonResult delete(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/delete/" + id, CommonResult.class, id);
    }

    @GetMapping(value = "/consumer/payment/update")
    public CommonResult update(Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/update", payment, CommonResult.class);
    }

    @GetMapping(value = "/consumer/payment/list")
    public CommonResult list() {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/list", CommonResult.class);
    }
}
