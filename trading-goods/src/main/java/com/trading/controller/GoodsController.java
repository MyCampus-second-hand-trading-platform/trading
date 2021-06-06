package com.trading.controller;

import com.trading.bean.Goods;
import com.trading.bean.Pic;
import com.trading.service.IGoodsBiz;
import com.trading.service.IPicBiz;
import com.trading.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: trading
 * @description:
 * @author: Joe
 * @create: 2021-06-01 22:04
 */
@RestController
public class GoodsController {
    @Autowired
    private IGoodsBiz goodsBiz;
    @Autowired
    private IPicBiz picBiz;


    @GetMapping({"selectByGid/{gid}"})
    public Result selectByGid(@PathVariable Integer gid) {
        Goods goods = goodsBiz.selectById(gid);
        Result r=new Result();
        if (goods != null) {
            r.setCode(1);
            r.setData(goods);
            r.setMsg("查询成功");
        } else {
            r.setCode(0);
            r.setData((Object)null);
            r.setMsg("查询失败");
        }
        return r;
    }

    @GetMapping({"/selectByGtype/{gtype}"})
    public Result selectByGtype(@PathVariable String gtype) {
        Result r = new Result();
        if (gtype != null) {
            List<Goods> list = this.goodsBiz.selectByType(gtype);
            if (!list.isEmpty() && list.size() > 0) {
                r.setData(list);
                r.setCode(1);
                r.setMsg("查询成功");
            } else {
                r.setData((Object)null);
                r.setCode(0);
                r.setMsg("查询失败");
            }
        }

        return r;
    }

    @GetMapping({"/selectAllGoods"})
    public Result selectAllGoods() {
        Result r = new Result();
        List<Goods> list = this.goodsBiz.selectAll();
        if (!list.isEmpty() && list.size() > 0) {
            r.setData(list);
            r.setCode(1);
            r.setMsg("查询成功");
        } else {
            r.setData(list);
            r.setCode(0);
            r.setMsg("暂无商品");
        }

        return r;
    }

    @PostMapping({"/updateGoods"})
    public Result update(@RequestBody Goods goods) {
        Result r = new Result();
        if (goods != null) {
            r.setCode(this.goodsBiz.update(goods));
            if (r.getCode() == 1) {
                r.setMsg("修改成功");
            } else {
                r.setMsg("修改失败");
            }
        }

        return r;
    }

    @GetMapping({"/deleteByGid/{gid}"})
    public Result deleteByGid(@PathVariable Integer gid) {
        Result r = new Result();
        if (gid != null) {
            r.setCode(this.goodsBiz.deleteById(gid));
            if (r.getCode() == 1) {
                r.setMsg("删除成功");
            } else {
                r.setMsg("删除失败");
            }
        }

        r.setMsg("gid为空");
        return r;
    }

    @PostMapping({"/addGoods"})
    public Result addGoods(@RequestBody Goods goods) {
        Result r = new Result();
        if (goods != null) {
            r.setCode(this.goodsBiz.addGoods(goods));
            if (r.getCode() == 1) {
                r.setMsg("添加成功");
            } else {
                r.setMsg("添加失败");
            }
        }

        r.setMsg("goods为空");
        return r;
    }

    @GetMapping({"/selectPic/{gid}"})
    public Result selectPic(@PathVariable Integer gid) {
        List<Pic> pics = this.picBiz.selectPicByGid(gid);
        return !pics.isEmpty() && pics.size() > 0 ? Result.success("查询成功", pics) : Result.failure("查询失败", (Object)null);
    }

    @GetMapping({"/deletePicByPid/{pid}"})
    public Result deleteByPid(@PathVariable Integer pid) {
        int result = this.picBiz.deleteById(pid);
        return result == 1 ? Result.success("删除成功", (Object)null) : Result.failure("删除失败", (Object)null);
    }

    @GetMapping({"/deletePicByGid/{gid}"})
    public Result deletePicByGid(@PathVariable Integer gid) {
        int result = this.picBiz.deleteByGid(gid);
        return result == 1 ? Result.success("删除成功", (Object)null) : Result.failure("删除失败", (Object)null);
    }

    @PostMapping({"/addPic"})
    public Result addPic(@RequestBody Pic pic) {
        int i = this.picBiz.addPic(pic);
        return i == 1 ? Result.success("添加成功", (Object)null) : Result.failure("添加失败", (Object)null);
    }

    @GetMapping({"/selectPicByGidGtype/{gid}&&{ptype}"})
    public Result selectPicByGidGtype(@PathVariable Integer gid, @PathVariable String ptype) {
        List<Pic> pics = this.picBiz.selectPicByGidGtype(gid, ptype);
        return !pics.isEmpty() && pics.size() > 0 ? Result.success("查询成功", pics) : Result.failure("查询失败", (Object)null);
    }
}
