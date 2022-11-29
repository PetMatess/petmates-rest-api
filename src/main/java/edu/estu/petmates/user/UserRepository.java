package edu.estu.petmates.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String email);

    //Optional<User> findByEmail(String email);



}
