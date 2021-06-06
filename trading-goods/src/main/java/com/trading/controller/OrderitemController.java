package com.trading.controller;

import com.trading.bean.Orderitem;
import com.trading.service.IOrderitemBiz;
import com.trading.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: trading2
 * @description:
 * @author: Joe
 * @create: 2021-06-06 20:57
 */
@RestController
public class OrderitemController {
    @Autowired
    private IOrderitemBiz orderitemBiz;



    @GetMapping({"/selectByOiid/{oiid}"})
    public Result selectByOiid(@PathVariable Integer oiid) {
        try {
            Orderitem orderitem = this.orderitemBiz.selectByOiid(oiid);
            return Result.success("查询成功", orderitem);
        } catch (Exception var3) {
            var3.printStackTrace();
            return Result.failure("查询失败", var3.getMessage());
        }
    }

    @GetMapping({"/selectByOid/{oid}"})
    public Result selectByOid(@PathVariable Integer oid) {
        try {
            List<Orderitem> orderitems = this.orderitemBiz.selectByOid(oid);
            return Result.success("查询成功", orderitems);
        } catch (Exception var3) {
            var3.printStackTrace();
            return Result.failure("查询失败", var3.getMessage());
        }
    }
}
