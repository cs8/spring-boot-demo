package com.xkcoding.docker.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * <p>
 * 通用API接口返回
 * </p>
 *
 * @package: com.xkcoding.swagger.common
 * @description: 通用API接口返回
 * @author: yangkai.shen
 * @date: Created in 2018-11-29 11:30
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "通用PI接口返回", description = "Common Api Response")
public class ApiResponse<T> implements Serializable {
  private static final long serialVersionUID = -8987146499044811408L;
  /**
   * 通用返回状态
   */
  @ApiModelProperty(value = "通用返回状态", required = true)
  private Integer code;
  /**
   * 通用返回信息
   */
  @ApiModelProperty(value = "通用返回信息", required = true)
  private String message;
  /**
   * 通用返回数据
   */
  @ApiModelProperty(value = "通用返回数据", required = true)
  private T data;

  public static ApiResponse of(Integer code, String message, Object data) {
    return new ApiResponse(code, message, data);
  }
//  /**
//   * 构造一个有状态的API返回
//   *
//   * @param status 状态 {@link Status}
//   * @return ApiResponse
//   */
//  public static ApiResponse ofStatus(Status status) {
//    return ofStatus(status, null);
//  }
}
