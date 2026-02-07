package com.svtu.mapper;

import com.svtu.pojo.Category;
import org.apache.ibatis.annotations.Insert;

public interface CategoryMapper {
    // 方法名=xml中的id=insert，参数=Category对象
    int insert(Category category);
}