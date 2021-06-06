package com.trading.bean;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @program: trading
 * @description:
 * @author: Joe
 * @create: 2021-05-31 18:37
 */
@Entity
@Table
@Data
public class Collection {

    @Id
    private Integer coid;
    private Integer uid;
    private Integer gid;
    private String gname;
    private String gtype;

}
