package com.trading.service;

import com.trading.bean.Order;

import java.util.List;

public interface IOrderBiz {
    List<Order> selectBySelluid(Integer selluid);

    List<Order> selectByBuyuid(Integer buyuid);

    Order selectById(Integer id);

    int update(Order order);

    int deleteById(Integer id);

    int addOrder(Order order);
}
