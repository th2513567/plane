package com.lhc.plane.dao;

import com.lhc.plane.entity.Orders;
import com.lhc.plane.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrdersRepository extends JpaRepository<Orders, Long> {
}
