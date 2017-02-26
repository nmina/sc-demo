package com.demo.cassandra.repositories;

import com.demo.cassandra.repositories.entities.Feeds;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;

/**
 * Created by nikko on 2/25/17.
 */
public interface FeedsRepository extends CassandraRepository<Feeds> {

    @Query("SELECT * FROM feeds") //use this only if there's a filter, otherwise, just use .findAll()
    Iterable<Feeds> getAllFeeds();


}
