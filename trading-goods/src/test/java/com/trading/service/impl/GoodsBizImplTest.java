package com.trading.service.impl;

import com.trading.bean.Goods;
import com.trading.service.IGoodsBiz;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GoodsBizImplTest {

    @Autowired
    private IGoodsBiz goodsBiz;

    @Test
    void selectAll() {

    }

    @Test
    void selectById() {
    }

    @Test
    void update() {
    }

    @Test
    void deleteById() {
    }

    @Test
    void addGoods() {
        Goods goods=new Goods();
        goods.setGname("台灯");
        goods.setGtype("电子用品");
        goods.setNum(1);
        goods.setPrice(19.0);
        goods.setContent("明亮");
        goods.setUserid(1);
        System.out.println(goodsBiz.addGoods(goods));
    }
}