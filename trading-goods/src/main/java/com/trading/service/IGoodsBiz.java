package com.trading.service;

import com.trading.bean.Goods;

import java.util.List;

/**
 * @program: trading
 * @description:
 * @author: Joe
 * @create: 2021-06-01 19:27
 */
public interface IGoodsBiz {
    public List<Goods> selectAll();


    public Goods selectById(Integer gid);

    public int update(Goods goods);

    public int deleteById(Integer gid);

    public int addGoods(Goods goods);

    List<Goods> selectByType(String gtype);
}
