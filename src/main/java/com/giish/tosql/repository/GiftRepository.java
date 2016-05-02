package com.giish.tosql.repository;

import com.giish.tosql.domain.Gift;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

/**
 * Created by SAM on 2016/4/26.
 */
//@Repository
@RepositoryRestResource(path = "gift", collectionResourceRel = "gift")
public interface GiftRepository extends PagingAndSortingRepository<Gift, String> {
}
