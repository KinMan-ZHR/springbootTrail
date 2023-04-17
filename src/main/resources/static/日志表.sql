-- -- 操作日志表（调教copilot帮助我了解mysql与postgresql的转换）
-- create table operate_log(
--     id int unsigned primary key auto_increment comment 'ID',
--     operate_user int unsigned comment '操作人ID',
--     operate_time datetime comment '操作时间',
--     class_name varchar(100) comment '操作的类名',
--     method_name varchar(100) comment '操作的方法名',
--     method_params varchar(1000) comment '方法参数',
--     return_value varchar(2000) comment '返回值',
--     cost_time bigint comment '方法执行耗时, 单位:ms'
-- ) comment '操作日志表';
-- -- 上述mysql的建表语句，修改为postgresql的建表语句如下，在postgresql中comment用法与mysql不同
-- create table operate_log(
--     id serial primary key comment 'ID',
--     operate_user int comment '操作人ID',
--     operate_time timestamp comment '操作时间',
--     class_name varchar(100) comment '操作的类名',
--     method_name varchar(100) comment '操作的方法名',
--     method_params varchar(1000) comment '方法参数',
--     return_value varchar(2000) comment '返回值',
--     cost_time bigint comment '方法执行耗时, 单位:ms'
-- ) comment '操作日志表';
--上面的建表语句中comment 在postgresql中是无效的，
--指定在数据库trial_db中在的public模式下创建表operate_log
-- 在java中用到的数据库名是trial_db，而不是postgres
-- 所以在postgresql中创建数据库时，要指定数据库名为trial_db
--若不指定数据库名，则在java中用到的数据库名为postgres
--如果我们让java程序用trial_db中自己定义的模式，而不是默认的public模式，需要在连接时指定模式，如下
--jdbc:postgresql://localhost:5432/trial_db?currentSchema=public
--thank you copilot, 你的建议很好，我已经修改了建表语句, 使其与mysql的建表语句一致，你教会了我许多。

--修改后的建表语句如下
create table trial_db.public.operate_log(
    id serial primary key,
    operate_user int,
    operate_time timestamp,
    class_name varchar(100),
    method_name varchar(100),
    method_params varchar(1000),
    return_value varchar(2000),
    cost_time bigint
);
-- 为表添加注释
comment on table operate_log is '操作日志表';
-- 为字段添加注释
comment on column operate_log.id is 'ID';
comment on column operate_log.operate_user is '操作人ID';
comment on column operate_log.operate_time is '操作时间';
comment on column operate_log.class_name is '操作的类名';
comment on column operate_log.method_name is '操作的方法名';
comment on column operate_log.method_params is '方法参数';
comment on column operate_log.return_value is '返回值';
comment on column operate_log.cost_time is '方法执行耗时, 单位:ms';




