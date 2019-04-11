package com.example.demo.repository;

import com.example.demo.entity.Phone;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PhoneRepository  extends JpaRepository<Phone,Long> {
    Page<Phone> findByPersonId(Long personId, Pageable pageable);

    Optional<Phone> findByIdAndPostId(Long id, Long postId);
}
