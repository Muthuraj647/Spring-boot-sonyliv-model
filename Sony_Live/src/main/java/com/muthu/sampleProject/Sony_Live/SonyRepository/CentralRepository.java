package com.muthu.sampleProject.Sony_Live.SonyRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.muthu.sampleProject.Sony_Live.Entity.Users;

public interface CentralRepository extends JpaRepository<Users,Integer>{

}
