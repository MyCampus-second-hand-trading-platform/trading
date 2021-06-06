package com.trading.bean;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @program: trading
 * @description:
 * @author: Joe
 * @create: 2021-05-30 10:24
 */
@Entity
@Table
@Data
public class Admin {
    @Id
    private Integer aid;
    private String aname;
    private String apwd;
    private String realname;
    private String tel;
    private Integer status;
}
