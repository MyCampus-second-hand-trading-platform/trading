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
 * @create: 2021-05-30 11:32
 */
@Entity
@Table(name ="`order`")
@Data
public class Order {
    @Id
    private Integer oid;
    private Integer buyuid;
    private Integer selluid;
    private Double totalprice;
    private String address;
    private Date date;
    private Integer status;
}
