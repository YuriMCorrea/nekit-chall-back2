package com.nekit.desafio.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nekit.desafio.entities.User;
import com.nekit.desafio.entities.UserSkill;

@Repository
public interface UserSkillRepository extends JpaRepository<UserSkill, Integer>{

	Page<UserSkill> findByUser(User user, Pageable paginacao);

}
