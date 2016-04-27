package com.giish.tosql.repository;

import com.giish.tosql.domain.Trade;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by SAM on 2016/4/27.
 */
@Repository
public interface TradeRepository extends CrudRepository<Trade, String> {
}
