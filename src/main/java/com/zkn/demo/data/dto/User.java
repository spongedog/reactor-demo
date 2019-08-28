package com.zkn.demo.data.dto;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author 郑凯努
 * @version 1.0
 * @date 2019/8/23
 */
@Data
@Accessors(chain = true)
public class User {

    private Long id;

    private String name;
}
