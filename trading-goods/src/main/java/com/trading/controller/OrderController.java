package com.trading.controller;

import com.trading.bean.Order;
import com.trading.bean.Orderitem;
import com.trading.service.IOrderBiz;
import com.trading.service.IOrderitemBiz;
import com.trading.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;

/**
 * @program: trading2
 * @description:
 * @author: Joe
 * @create: 2021-06-06 20:57
 */
@RestController
public class OrderController {
    @Autowired
    private IOrderBiz orderBiz;
    @Autowired
    private IOrderitemBiz orderitemBiz;


    @GetMapping({"selectByOid/{id}"})
    public Result selectByOid(@PathVariable Integer oid) {
        Result r = new Result();
        if (oid != null) {
            Order order = this.orderBiz.selectById(oid);
            if (order != null) {
                r.setData(order);
                r.setCode(1);
                r.setMsg("查询成功");
            } else {
                r.setCode(0);
                r.setMsg("查询失败");
            }
        }

        return r;
    }

    @GetMapping({"/selectByBuyuid/{buyuid}"})
    public Result selectByBuyuid(@PathVariable Integer buyuid) {
        Result r = new Result();
        if (buyuid != null) {
            List<Order> list = this.orderBiz.selectByBuyuid(buyuid);
            if (!list.isEmpty() && list.size() > 0) {
                r.setData(list);
                r.setCode(1);
                r.setMsg("查询卖家购买订单成功");
            } else {
                r.setCode(0);
                r.setMsg("查询卖家订单失败");
            }
        }

        return r;
    }

    @GetMapping({"/selectBySelluid/{selluid}"})
    public Result selectBySelluid(@PathVariable Integer selluid) {
        Result r = new Result();
        if (selluid != null) {
            List<Order> list = this.orderBiz.selectBySelluid(selluid);
            if (!list.isEmpty() && list.size() > 0) {
                r.setData(list);
                r.setCode(1);
                r.setMsg("查询买家购买订单成功");
            } else {
                r.setCode(0);
                r.setMsg("查询买家订单失败");
            }
        }

        return r;
    }

    @PostMapping({"/updateOrder"})
    public Result updateOrder(@RequestBody Order order) {
        Result r = new Result();
        if (order != null) {
            int result = this.orderBiz.update(order);
            if (result == 1) {
                r.setCode(1);
                r.setMsg("修改订单成功");
            } else {
                r.setCode(0);
                r.setMsg("修改订单失败");
            }
        }

        return r;
    }

    @PostMapping({"/addOrderAndOrderitem"})
    public Result addOrderAndOrderitem(@RequestBody Order order, @RequestBody List<Orderitem> orderitems) {
        Result r = new Result();
        Double totalprice = 0.0D;
        Boolean flag = true;
        Orderitem orderitem;
        if (!orderitems.isEmpty() && orderitems.size() > 0) {
            for(Iterator var6 = orderitems.iterator(); var6.hasNext(); totalprice = totalprice + orderitem.getPrice()) {
                orderitem = (Orderitem)var6.next();
                int f = this.orderitemBiz.addOrderitem(orderitem);
                if (f == 0) {
                    flag = false;
                    r.setCode(0);
                    r.setMsg("添加购物车项失败");
                    return r;
                }
            }
        }

        order.setTotalprice(totalprice);
        int f1 = this.orderBiz.addOrder(order);
        if (f1 == 0) {
            flag = false;
        }

        if (flag) {
            r.setCode(1);
            r.setMsg("添加成功");
        } else {
            r.setCode(0);
            r.setMsg("添加失败");
        }

        return r;
    }

    @GetMapping({"deleteByOid"})
    public Result deletByOid(@PathVariable Integer oid) {
        Result r = new Result();
        Boolean flag = true;
        if (oid != null) {
            if (this.orderitemBiz.deleteByOid(oid) == 0) {
                flag = false;
                r.setCode(0);
                r.setMsg("删除购物车项失败");
                return r;
            }

            if (this.orderBiz.deleteById(oid) == 0) {
                flag = false;
            }

            if (flag) {
                r.setCode(1);
                r.setMsg("删除成功");
            } else {
                r.setCode(0);
                r.setMsg("删除失败");
            }
        }

        return r;
    }
}
