package com.example.tpvolleyapi.student;

import org.hibernate.annotations.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {

    @Query("SELECT s FROM Student s WHERE LOWER(s.nom) = LOWER(:nom) AND LOWER(s.prenom) = LOWER(:prenom)")
    Optional<Student> findByFullName(String nom,String prenom);

}
