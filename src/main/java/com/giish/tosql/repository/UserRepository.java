package com.giish.tosql.repository;

import com.giish.tosql.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

/**
 * Created by SAM on 2016/4/29.
 */
//@Repository
@RepositoryRestResource(path = "user", collectionResourceRel = "user")
public interface UserRepository extends PagingAndSortingRepository<User, String> {
}
