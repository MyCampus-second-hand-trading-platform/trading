package com.trading.bean;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @program: trading
 * @description:
 * @author: Joe
 * @create: 2021-05-31 18:45
 */
@Entity
@Table
@Data
public class Pic {
    @Id
    private Integer gid;
    private String pic;
    private String ptype;
}
