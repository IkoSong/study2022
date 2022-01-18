package com.slhcode.springboot.rpc.service;

// UserRpcServiceImpl.java

import com.slhcode.springboot.rpc.api.UserRpcService;
import com.slhcode.springboot.rpc.dto.UserAddDTO;
import com.slhcode.springboot.rpc.dto.UserDTO;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolationException;

@Service
public class UserRpcServiceImpl implements UserRpcService {

    @Override
    public UserDTO get(Integer id) {

        return new UserDTO().setId(id)
                .setName("没有昵称：" + id)
                .setGender(id % 2 + 1); // 1 - 男；2 - 女
    }

    @Override
    public Integer add(UserAddDTO addDTO) throws ConstraintViolationException {
        return (int) (System.currentTimeMillis() / 1000); // 嘿嘿，随便返回一个 id
    }

}