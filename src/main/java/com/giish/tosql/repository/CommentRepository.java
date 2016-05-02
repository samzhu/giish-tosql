package com.giish.tosql.repository;

import com.giish.tosql.domain.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

/**
 * Created by SAM on 2016/4/27.
 */
//@Repository
@RepositoryRestResource(path = "comment", collectionResourceRel = "comment")
public interface CommentRepository extends PagingAndSortingRepository<Comment, String> {
}
