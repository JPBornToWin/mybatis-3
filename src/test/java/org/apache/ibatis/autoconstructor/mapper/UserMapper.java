/**
 *    Copyright 2009-2019 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.apache.ibatis.autoconstructor.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.autoconstructor.entity.User;

import java.util.List;

@Mapper
public interface UserMapper {
  @Select("SELECT * FROM user WHERE id = #{id}")
  User getUser(final int id);

  @Select("SELECT * FROM user")
  List<User> getUsers();

  @Insert("insert into user (name, create_time, age) values(#{name}, #{creatTime}, #{age})")
  Integer saveUser(User user);
}
