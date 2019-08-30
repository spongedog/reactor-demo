package com.zkn.demo.dao;

import com.zkn.demo.dto.data.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author 郑凯努
 * @version 1.0
 * @date 2019/8/29
 */
@Repository
public interface UserRepository extends ReactiveMongoRepository<User, Long> {
}
