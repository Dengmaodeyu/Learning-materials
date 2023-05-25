package com.xixicc.authservice.service.impl;

import com.xixicc.authservice.entity.User;
import com.xixicc.authservice.dao.UserMapper;
import com.xixicc.authservice.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author pcc
 * @since 2023-05-22
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
