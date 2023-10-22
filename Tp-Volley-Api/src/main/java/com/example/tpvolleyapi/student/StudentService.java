package com.example.tpvolleyapi.student;

import com.example.tpvolleyapi.dao.IDao;
import com.example.tpvolleyapi.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class StudentService implements IDao<Student> {




    private StudentRepository studentRepository;


    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student create(Student o) throws Exception {
        StringUtils.cleanFullName(o);
        Optional<Student> student = studentRepository.findByFullName(o.getNom(), o.getPrenom());

        if (!student.isPresent()) {

            return studentRepository.save(o);
        }
        throw new Exception("Student Already Exists");
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public void delete(Integer id) throws Exception {

        if(studentRepository.existsById(id)){
            studentRepository.deleteById(id);
            return;
        }
      throw new Exception("That id doesn't exist");
    }


}
