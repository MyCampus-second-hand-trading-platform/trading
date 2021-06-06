package com.trading.dao.impl;

import com.trading.bean.Goods;
import com.trading.dao.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

@Mapper
public interface GoodsMapper extends BaseMapper<Goods> {

    @Insert("insert into goods values(default, #{gname},#{gtype},#{userid},#{num},now(),null,#{price},1,#{content} )")
    @Options(useGeneratedKeys = true, keyColumn = "gid" ,keyProperty = "gid")
    public int addGoods(Goods goods);
}
