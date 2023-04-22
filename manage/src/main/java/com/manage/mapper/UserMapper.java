package com.manage.mapper;

import com.manage.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zjp
 * @since 2023-04-18
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
