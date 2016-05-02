package com.giish.tosql.repository;

import com.giish.tosql.domain.Comment;
import com.giish.tosql.domain.Installation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by SAM on 2016/4/27.
 */
@Repository
public interface InstallationRepository extends PagingAndSortingRepository<Installation, String> {
}
