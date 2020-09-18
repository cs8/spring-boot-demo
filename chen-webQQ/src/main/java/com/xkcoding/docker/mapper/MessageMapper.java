package com.xkcoding.docker.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xkcoding.docker.entity.Message;
import org.springframework.stereotype.Component;

/**
 * <p>
 * UserMapper
 * </p>
 *
 * @package: com.xkcoding.orm.mybatis.plus.mapper
 * @description: UserMapper
 * @author: yangkai.shen
 * @date: Created in 2018/11/8 16:57
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
@Component
public interface MessageMapper extends BaseMapper<Message> {
}
