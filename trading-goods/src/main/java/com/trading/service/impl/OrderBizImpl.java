package com.trading.service.impl;

import com.trading.bean.Order;
import com.trading.dao.impl.OrderMapper;
import com.trading.service.IOrderBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @program: trading2
 * @description:
 * @author: Joe
 * @create: 2021-06-06 21:03
 */
@Service
public class OrderBizImpl implements IOrderBiz {
    @Autowired
    private OrderMapper orderMapper;

    @Override
    public List<Order> selectBySelluid(Integer selluid) {
        Example example = new Example(Order.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("selluid", selluid);
        List<Order> list = this.orderMapper.selectByExample(example);
        return list;
    }
    @Override
    public List<Order> selectByBuyuid(Integer buyuid) {
        Example example = new Example(Order.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("buyuid", buyuid);
        List<Order> list = this.orderMapper.selectByExample(example);
        return list;
    }
    @Override
    public Order selectById(Integer id) {
        return (Order)this.orderMapper.selectByPrimaryKey(id);
    }
    @Override
    public int update(Order order) {
        return this.orderMapper.updateByPrimaryKeySelective(order);
    }
    @Override
    public int deleteById(Integer id) {
        return this.orderMapper.deleteByPrimaryKey(id);
    }
    @Override
    public int addOrder(Order order) {
        return order.getAddress() != null && order.getBuyuid() != null && order.getOid() != null && order.getSelluid() != null && order.getDate() != null && order.getStatus() != null && order.getTotalprice() != null ? this.orderMapper.insert(order) : 0;
    }
}
