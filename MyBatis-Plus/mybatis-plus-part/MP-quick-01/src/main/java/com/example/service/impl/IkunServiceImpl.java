package com.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.Mapper.ikunMapper;
import com.example.pojo.修仙book;
import com.example.service.IkunService;
import org.springframework.stereotype.Service;
//TODO：service层增强
/*
实现的接口要继承IService<修仙book> 《》里面写表名对于的类名。
 */
@Service
public class IkunServiceImpl extends ServiceImpl<ikunMapper, 修仙book> implements IkunService {
//ServiceImpl<ikunMapper,ikun>里面写的是service调用的Mapper和表格对应的类名。这个类里面有IService方法的其他实现。

}
