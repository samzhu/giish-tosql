package com.giish.tosql.repository;

import com.giish.tosql.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by SAM on 2016/4/29.
 */
@Repository
public interface UserRepository extends CrudRepository<User, String> {
}
