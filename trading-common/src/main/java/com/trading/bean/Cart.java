package com.trading.bean;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @program: trading
 * @description:
 * @author: Joe
 * @create: 2021-05-30 10:26
 */
@Entity
@Table
@Data
public class Cart {
    @Id
    private Integer cid;
    private Integer uid;
    private Double totalprice;
}
