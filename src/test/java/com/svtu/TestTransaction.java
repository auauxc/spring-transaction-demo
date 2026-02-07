package com.svtu;

import com.svtu.pojo.Category;
import com.svtu.service.CategoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * 事务测试类
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml") // 加载Spring配置文件
public class TestTransaction {

    // 注入Service
    @Autowired
    private CategoryService categoryService;


    @Test
    public void testTransactionSuccess() {

        List<Category> categoryList = new ArrayList<>();
        categoryList.add(new Category("d1"));
        categoryList.add(new Category("d2"));

        int total = categoryService.insertList(categoryList);
        System.out.println("正常场景：新增行数 = " + total);
    }

    /**
     * 测试事务异常场景
     * 插入第一个分类后抛出算术异常，事务回滚
     */
    @Test
    public void testTransactionFail() {
        // 构建分类列表
        List<Category> categoryList = new ArrayList<>();
        categoryList.add(new Category("d1"));
        categoryList.add(new Category("d2"));

        try {
            // 调用新增方法（会抛出异常）
            int total = categoryService.insertList(categoryList);
            System.out.println("异常场景：新增行数 = " + total);
        } catch (Exception e) {
            System.out.println("异常场景：捕获到异常 = " + e.getMessage());
        }
    }
}