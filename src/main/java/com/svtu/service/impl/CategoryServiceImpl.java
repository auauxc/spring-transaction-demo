package com.svtu.service.impl;

import com.svtu.mapper.CategoryMapper;
import com.svtu.pojo.Category;
import com.svtu.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 分类Service实现类
 */
@Service("categoryService") // 名称和测试类注入的categoryService匹配，正确
public class CategoryServiceImpl implements CategoryService {

    // 注入Mapper接口
    @Autowired
    private CategoryMapper categoryMapper;

    /**
     * 新增分类列表（添加事务注解）
     * @Transactional：声明式事务注解，rollbackFor = Exception.class 确保所有异常都回滚
     */
    @Transactional(rollbackFor = Exception.class) // 事务注解正确
    @Override
    public int insertList(List<Category> categoryList) {
        int total = 0; // 累计受影响行数
        for (int i = 0; i < categoryList.size(); i++) {
            Category category = categoryList.get(i);
            // 核心修正：将insertOne改为insert（和Mapper接口/XML的方法名一致）
            int row = categoryMapper.insert(category);
            total += row;

            // 测试异常场景：第一个对象插入后抛出算术异常（取消注释触发回滚）
            if (i == 0) {
                // 取消下面这行的注释，即可触发异常，测试事务回滚
                //int a = 1 / 0;
            }
        }
        return total;
    }
}