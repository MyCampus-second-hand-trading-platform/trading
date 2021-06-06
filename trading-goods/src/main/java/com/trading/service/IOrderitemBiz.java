package com.trading.service;

import com.trading.bean.Orderitem;

import java.util.List;

public interface IOrderitemBiz {

    Orderitem selectByOiid(Integer oiid);

    List<Orderitem> selectByOid(Integer oid);

    List<Orderitem> selectAll();

    int update(Orderitem orderitem);

    int addOrderitem(Orderitem orderitem);

    int deleteByOiid(Integer oiid);

    int deleteByOid(Integer oid);
}
