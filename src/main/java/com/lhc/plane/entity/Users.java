package com.lhc.plane.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String userName;
    @Column
    private String password;
    @Column
    private String sex;
    @Column
    private String email;
    @Column
    private String name;
    @Column
    private String idcard;
    @Column
    private String account;
    @OneToMany(targetEntity = Orders.class, cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="users_id")
    private List<Orders> ordersList;
}
