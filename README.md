# spring-transaction-demo
Spring 声明式事务实战Demo，用于测试Spring事务的正常提交、异常回滚机制，整合MyBatis + Druid连接池 + MySQL，复现标准事务业务场景。

## 技术栈
- 核心框架：Spring 5.3.27
- 持久层：MyBatis 3.5.13
- 数据库：MySQL 8.0
- 连接池：Druid 1.16
- 测试框架：Spring Test + JUnit 4.13.2
- 构建工具：Maven
- 版本控制：Git

## 项目功能
1. 测试Spring声明式事务**正常提交**：无异常抛出，数据正常持久化到数据库
2. 测试Spring声明式事务**异常回滚**：手动触发运行时异常，事务自动回滚，数据不入库
3. 基于XML配置实现Spring声明式事务管理，业务层无侵入式事务控制
4. 整合Druid实现数据库连接池管理，提升数据库连接性能

## 数据库建表语句
```sql
CREATE TABLE `t_category` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` varchar(50) NOT NULL COMMENT '分类名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT '事务测试分类表';