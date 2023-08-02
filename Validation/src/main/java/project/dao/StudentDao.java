package project.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import project.model.Student;

import java.util.List;

@Component
public class StudentDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public StudentDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Student> all(){
        return jdbcTemplate.query("select * from student", new BeanPropertyRowMapper<Student>(Student.class));
    }

    public Student show(int id_db){
        return jdbcTemplate.query("select * from student where id_db = ?", new Object[]{id_db},
                new BeanPropertyRowMapper<>(Student.class)).stream().findAny().orElse(null);
    }

    public void save(Student student) {
        jdbcTemplate.update("insert into student (name,id,email,gpa) values (?,?,?,?)", student.getName(), student.getId(), student.getEmail(), student.getGpa());
    }

    public void update(int id_db, Student student){
        System.out.println(student.toString());
        jdbcTemplate.update("update student set name = ?, id = ?, email = ?, gpa = ? where id_db = ?",
                student.getName(), student.getId(), student.getEmail(), student.getGpa(), id_db);
    }

    public void delete(int id_db){
        jdbcTemplate.update("delete from student where id_db = ?" , id_db);
    }
}
