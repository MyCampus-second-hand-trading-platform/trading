package com.trading.bean;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @program: trading
 * @description:
 * @author: Joe
 * @create: 2021-05-30 10:21
 */
@Entity
@Table
@Data
public class User {
    @Id
    private Integer uid;
    private String uname;
    private String upwd;
    private String realname;
    private String tel;
    private String address;
    private Integer status;

}
