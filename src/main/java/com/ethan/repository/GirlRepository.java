package com.ethan.repository;

import com.ethan.domain.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by lingxingu on 2017/3/18.
 */
public interface GirlRepository extends JpaRepository<Girl, Integer>{

    List<Girl> findByAge(Integer age);
}
