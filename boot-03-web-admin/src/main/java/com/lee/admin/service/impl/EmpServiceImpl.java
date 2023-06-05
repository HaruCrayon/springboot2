package com.lee.admin.service.impl;

import com.lee.admin.bean.Emp;
import com.lee.admin.mapper.EmpMapper;
import com.lee.admin.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author LiJing
 * @version 1.0
 */
@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    EmpMapper empMapper;

    public Emp getEmpById(Integer id) {
        return empMapper.getEmpById(id);
    }
}
