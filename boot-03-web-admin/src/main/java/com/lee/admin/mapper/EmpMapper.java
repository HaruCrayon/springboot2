package com.lee.admin.mapper;

import com.lee.admin.bean.Emp;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author LiJing
 * @version 1.0
 */
@Mapper
public interface EmpMapper {
    Emp getEmpById(Integer id);
}
