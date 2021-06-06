package com.trading.bean;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @program: trading
 * @description:
 * @author: Joe
 * @create: 2021-05-30 11:25
 */
@Entity
@Table
@Data
public class Cartitem {
    @Id
    private Integer iid;
    private Integer uid;
    private Integer gid;
    private String gname;
    private Integer cid;
    private Integer num;
    private Double price;
}
