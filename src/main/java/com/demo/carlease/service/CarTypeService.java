package com.demo.carlease.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.demo.carlease.exception.dto.CarTypeDTO;
import com.demo.carlease.entity.CarType;
import com.demo.carlease.vo.CarTypeVO;

import java.util.List;

/**
 * <p>
 * 汽车类型表 服务类
 * </p>
 *
 * @author 李嘉明
 * @since 2021-12-19
 */
public interface CarTypeService extends IService<CarType> {

    /**
     * 获取所有汽车类型方法
     *
     * @return 汽车类型信息集合
     */
    List<CarTypeVO> getAll();

    /**
     * 新增汽车类型方法
     *
     * @param validator 汽车类型信息校验器
     * @return 新增结果 true | false
     */
    boolean add(CarTypeDTO validator);

}
