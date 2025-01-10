package com.global.Repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.global.Model.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {

	Optional<Student> findByStudentName(String studentName);
}
