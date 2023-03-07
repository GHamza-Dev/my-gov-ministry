package io.flat.ministry.ministry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MinistryRepository extends JpaRepository<Ministry, Long> {
    Optional<Ministry> findAllByUuid(String uuid);
}