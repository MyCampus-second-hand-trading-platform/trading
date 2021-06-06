package com.trading.bean;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @program: trading
 * @description:
 * @author: Joe
 * @create: 2021-05-30 11:50
 */
@Entity
@Table
@Data
public class Orderitem {

    @Id
    private Integer oiid;
    private Integer gid;
    private String gname;
    private Integer num;
    private Double price;
    private Integer oid;

}

