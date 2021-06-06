package com.trading.bean;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @program: trading
 * @description:
 * @author: Joe
 * @create: 2021-05-30 10:27
 */
@Entity
@Table
@Data
public class Goods {

    @Id
    private Integer gid;
    private String gname;
    private String gtype;
    private Integer userid;
    private Integer num;
    private Date date;
    private Integer colnum;
    private Double price;
    private Integer status;
    private String content;
}
