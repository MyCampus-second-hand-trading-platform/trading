package com.trading.service;

import com.trading.bean.Pic;

import java.util.List;

public interface IPicBiz {
    List<Pic> selectPicByGid(Integer gid);

    int deleteById(Integer pid);

    int deleteByGid(Integer gid);

    int addPic(Pic pic);

    List<Pic> selectPicByGidGtype(Integer gid, String ptype);
}
