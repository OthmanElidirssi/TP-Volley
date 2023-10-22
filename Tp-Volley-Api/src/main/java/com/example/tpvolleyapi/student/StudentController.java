package com.example.tpvolleyapi.student;


import com.example.tpvolleyapi.dao.IDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/student")
public class StudentController {


    private IDao<Student> studentService;

    @Autowired
    public StudentController(IDao<Student> studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveStudent(@RequestBody Student student) {
        try {
            studentService.create(student);
            return ResponseEntity.ok("{\"message\": \"Student created successfully\"}");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/all")
    public List<Student> getAllStudents(){
        return studentService.findAll();
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> saveStudent(@PathVariable Integer id) {
        try {
            studentService.delete(id);
            return ResponseEntity.ok("{\"message\": \"Student deleted Successfully\"}");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }


}
