package com.lhc.plane.service.impl;

import com.lhc.plane.dto.BuyTicketDto;
import com.lhc.plane.service.IUsersService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUsersService {
    @Override
    public boolean buyTicket(BuyTicketDto dto) {

        return false;
    }
}
