package com.lhc.plane.dao;

import com.lhc.plane.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsersRepository extends JpaRepository<Users, Long> {
    public List<Users> findByUserName(String userName);
    public Users findByUserNameAndPassword(String userName,String password);
    public int countByUserName(String userName);
}
