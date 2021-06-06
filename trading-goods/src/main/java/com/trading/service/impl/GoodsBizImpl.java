package com.trading.service.impl;

import com.trading.bean.Goods;
import com.trading.dao.impl.GoodsMapper;
import com.trading.service.IGoodsBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @program: trading
 * @description:
 * @author: Joe
 * @create: 2021-06-01 20:15
 */
@Service
public class GoodsBizImpl implements IGoodsBiz {

    @Autowired
    private GoodsMapper goodsMapper;



    @Override
    public List<Goods> selectAll() {
        return goodsMapper.selectAll();
    }


    @Override
    public Goods selectById(Integer gid) {
        return goodsMapper.selectByPrimaryKey(gid);
    }

    @Override
    public int update(Goods goods) {
        return goodsMapper.updateByPrimaryKeySelective(goods);
    }

    @Override
    public int deleteById(Integer gid) {
        return goodsMapper.deleteByPrimaryKey(gid);
    }

    @Override
    public int addGoods(Goods goods) {
        if(goods.getGname()!=null && goods.getGtype()!=null && goods.getNum()!=null && goods.getPrice()!=null && goods.getUserid()!=null
                && goods.getContent()!=null  ){
            return goodsMapper.addGoods(goods);
        }
        return 0;
    }

    @Override
    public List<Goods> selectByType(String gtype) {
        Example example=new Example(Goods.class);
        Example.Criteria criteria=example.createCriteria();
        criteria.andEqualTo("gtype",gtype);
        return goodsMapper.selectByExample(example);
    }
}
