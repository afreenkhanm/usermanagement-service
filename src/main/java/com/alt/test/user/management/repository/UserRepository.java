package com.alt.test.user.management.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.alt.test.user.management.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
