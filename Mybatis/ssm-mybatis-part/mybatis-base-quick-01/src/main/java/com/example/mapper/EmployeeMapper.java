package com.example.mapper;

import com.example.pojo.Employee;
import org.apache.ibatis.annotations.Param;

public interface EmployeeMapper {
    Employee queryByPrice(Integer price);
    Employee queryById(@Param("id") Integer id,@Param("price") Integer price);

}
