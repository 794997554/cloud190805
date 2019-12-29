package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Payment;

import java.util.List;

public interface PaymentService {
    void create(Payment payment);

    void delete(Long id);

    void update(Payment payment);

    Payment getPaymentById(Long id);

    List<Payment> list();
}
