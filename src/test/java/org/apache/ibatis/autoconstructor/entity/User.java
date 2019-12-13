package org.apache.ibatis.autoconstructor.entity;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class User {
  private Long id;

  private String name;

  private Timestamp creatTime;

  private Integer age;
}
