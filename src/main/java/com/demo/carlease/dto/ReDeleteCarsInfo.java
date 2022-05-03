package com.demo.carlease.dto;

import lombok.Data;

import java.util.List;

/**
 * <p>
 *     恢复汽车维修状态
 * </p>
 * <p>create file on 2022/5/3</p>
 *
 * @author TierneyJohn
 */
@Data
public class ReDeleteCarsInfo {

    private List<Long> carIdList;
}
