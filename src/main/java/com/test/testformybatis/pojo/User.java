package com.test.testformybatis.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Author: L--L
 * @Date: 2022/7/8
 * @Desc:
 */
@TableName("tb_user")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    @TableId
    private int account;
    @TableField("username")
    private String username;
    @TableField
    private String phone;
    @TableField
    private String email;
}
