package com.zkn.demo.dto.data;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;

/**
 * @author 郑凯努
 * @version 1.0
 * @date 2019/8/23
 */
@Data
@Accessors(chain = true)
public class User {

    @Id
    private Long id;

    private String name;
}
