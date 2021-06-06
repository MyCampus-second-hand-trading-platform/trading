package com.trading;

import com.trading.bean.Goods;
import com.trading.service.IGoodsBiz;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = TradingGoodsApplication.class)
class TradingGoodsApplicationTests {

    @Autowired
    private IGoodsBiz goodsBiz;

    @Test
    void contextLoads() {
        Goods goods=new Goods();
        goods.setGname("手机");
        goods.setGtype("电子用品");
        goods.setNum(1);
        goods.setPrice(2500.0);
        goods.setContent("好用");
        goods.setUserid(1);
        System.out.println(goodsBiz.addGoods(goods));
    }

    @Test
    void selectAll(){
        System.out.println(goodsBiz.selectAll());
    }

    @Test
    void selectById(){
        System.out.println(goodsBiz.selectById(1));
    }

    @Test
    void update(){
        Goods goods=new Goods();
        goods.setGid(1);
        goods.setContent("9成新，明亮");
        System.out.println(goodsBiz.update(goods));
    }

    @Test
    void deleteById(){
        System.out.println(goodsBiz.deleteById(2));
    }


}
