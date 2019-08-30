package com.zkn.demo.dto.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author 郑凯努
 * @version 1.0
 * @date 2019/8/29
 */
@Data
@AllArgsConstructor
@Document(collection = "event")
public class Event {

    @Id
    private Long id;

    private String message;
}
