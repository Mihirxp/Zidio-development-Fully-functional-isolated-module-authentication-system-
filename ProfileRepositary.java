package com.zidio.student_module.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.zidio.student_module.entity.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
    Profile findByStudentId(Long studentId);
}
