package com.demo.carlease.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * entity 公共字段
 * </p>
 *
 * @author 李嘉明
 * create time 2021/12/19
 */
@Getter
@Setter
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    public BaseEntity() {
        this.updateDatetime = LocalDateTime.now();
        this.deleteFlag = false;
    }

    /**
     * 主键自增长 id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 创建时间
     */
    @TableField("create_datetime")
    private LocalDateTime createDatetime;

    /**
     * 修改时间
     */
    @TableField("update_datetime")
    private LocalDateTime updateDatetime;

    /**
     * 是否删除
     */
    @TableLogic
    @TableField("delete_flag")
    private Boolean deleteFlag;
}
