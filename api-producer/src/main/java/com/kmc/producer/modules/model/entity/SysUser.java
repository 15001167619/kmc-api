package com.kmc.producer.modules.model.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author 武海升
 * @date 2018/10/18 15:40
 */
@Data
@TableName("sys_user")
@EqualsAndHashCode(callSuper = false)
public class SysUser extends Model<SysUser> {

    /**
     * 主键ID
     */
    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer userId;

    private String userName;

    private String mobile;

    @Override
    protected Serializable pkVal() {
        return this.userId;
    }
}
