package com.trading.dao.impl;

import com.trading.bean.Orderitem;
import com.trading.dao.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OrderitemMapper extends BaseMapper<Orderitem> {
    @Select({"select oiid,gid,gname,num,price,oid from orderitem where oiid=#{oiid} "})
    @Options(useGeneratedKeys = true, keyColumn = "oiid", keyProperty = "oiid")
    Orderitem selectByOiid(@Param("oiid") Integer oiid);

    @Select({"select oiid,gid,gname,num,price,oid from orderitem where oid=#{oid} "})
    @Options(useGeneratedKeys = true, keyColumn = "oiid", keyProperty = "oiid")
    List<Orderitem> selectByOid(@Param("oid") Integer oiid);
}
