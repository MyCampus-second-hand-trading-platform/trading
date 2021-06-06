package com.trading.dao.impl;

import com.trading.bean.Order;
import com.trading.dao.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper extends BaseMapper<Order> {
}
