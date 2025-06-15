package com.example.library.repository;


import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.library.model.Member;



@Repository
public interface MemberRepository extends JpaRepository<Member, UUID> {
    boolean existsByEmailOrPhone(String email, String phone);
}

