package com.trading.service.impl;

import com.trading.bean.Pic;
import com.trading.dao.impl.PicMapper;
import com.trading.service.IPicBiz;
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
public class PicBizImpl implements IPicBiz {
    @Autowired
    private PicMapper picMapper;


    @Override
    public List<Pic> selectPicByGid(Integer gid) {
        Example example = new Example(Pic.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("gid", gid);
        return this.picMapper.selectByExample(example);
    }
    @Override
    public int deleteById(Integer pid) {
        return this.picMapper.deleteByPrimaryKey(pid);
    }
    @Override
    public int deleteByGid(Integer gid) {
        Example example = new Example(Pic.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("gid", gid);
        return this.picMapper.deleteByExample(example);
    }
    @Override
    public int addPic(Pic pic) {
        return pic.getGid() != null && pic.getPic() != null && pic.getPtype() != null ? this.picMapper.insert(pic) : 0;
    }
    @Override
    public List<Pic> selectPicByGidGtype(Integer gid, String ptype) {
        Example example = new Example(Pic.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("gid", gid);
        criteria.andEqualTo("ptype", ptype);
        return this.picMapper.selectByExample(example);
    }
}
