package com.demo.carlease.dto;

import lombok.Data;

import java.util.List;

@Data
public class DeleteCarsInfo {

    private List<Long> carIdList;

}
