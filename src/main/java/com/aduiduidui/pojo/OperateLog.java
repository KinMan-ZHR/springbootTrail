package com.aduiduidui.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OperateLog {

  private Integer id;
  private Integer operateUser;
  private LocalDateTime operateTime;
  private String className;
  private String methodName;
  private String methodParams;
  private String returnValue;
  private long costTime;


}
