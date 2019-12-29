package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PaymentDao {
    void create(Payment payment);

    Payment getPaymentById(Long id);

    void delete(Long id);

    void update(Payment payment);

    List<Payment> list();
}
