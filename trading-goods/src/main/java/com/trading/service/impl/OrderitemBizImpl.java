package com.trading.service.impl;

import com.trading.bean.Orderitem;
import com.trading.dao.impl.OrderitemMapper;
import com.trading.service.IOrderitemBiz;
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
public class OrderitemBizImpl implements IOrderitemBiz {
    @Autowired
    private OrderitemMapper orderitemMapper;


    @Override
    public Orderitem selectByOiid(Integer oiid) {
        Orderitem list = this.orderitemMapper.selectByOiid(oiid);
        return list;
    }
    @Override
    public List<Orderitem> selectByOid(Integer oid) {
        List<Orderitem> list = this.orderitemMapper.selectByOid(oid);
        return list;
    }
    @Override
    public List<Orderitem> selectAll() {
        return this.orderitemMapper.selectAll();
    }
    @Override
    public int update(Orderitem orderitem) {
        return this.orderitemMapper.updateByPrimaryKeySelective(orderitem);
    }
    @Override
    public int addOrderitem(Orderitem orderitem) {
        return orderitem.getGname() != null && orderitem.getNum() != null && orderitem.getOid() != null && orderitem.getGid() != null && orderitem.getPrice() != null ? this.orderitemMapper.insert(orderitem) : 0;
    }
    @Override
    public int deleteByOiid(Integer oiid) {
        return this.orderitemMapper.deleteByPrimaryKey(oiid);
    }
    @Override
    public int deleteByOid(Integer oid) {
        Example example = new Example(Orderitem.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("oid", oid);
        return this.orderitemMapper.deleteByExample(example);
    }
}
