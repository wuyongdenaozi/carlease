package com.demo.carlease.dto;

import lombok.Data;

import java.util.List;

/**
 * <p>
 *     新增汽车维修状态
 * </p>
 */
@Data
public class DeleteCarsInfo {

    private List<Long> carIdList;

}
