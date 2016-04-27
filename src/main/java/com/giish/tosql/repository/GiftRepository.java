package com.giish.tosql.repository;

import com.giish.tosql.domain.Gift;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by SAM on 2016/4/26.
 */
@Repository
public interface GiftRepository extends CrudRepository<Gift, String> {
}
