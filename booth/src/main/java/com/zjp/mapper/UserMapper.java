package com.zjp.mapper;

import com.zjp.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zjp
 * @since 2023-03-30
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
