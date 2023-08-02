package project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import project.dao.StudentDao;
import project.model.Student;

import javax.validation.Valid;

@Controller
@RequestMapping("")
public class StudentsController {

    private final StudentDao studentDao;

    @Autowired
    public StudentsController(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @GetMapping("")
    public String welcome(@ModelAttribute("student") Student student){
        System.out.println("Here u go");
        return "/welcome";
    }

    @PostMapping("/post")
    public String create(@ModelAttribute("student") @Valid Student student, BindingResult result, Model model){

        System.out.println(student.toString());
        if (result.hasErrors()) return "/welcome";

        studentDao.save(student);
        model.addAttribute("list", studentDao.all());
        return "/all";
    }

    @GetMapping("/all")
    public String all(Model model){
        model.addAttribute("list", studentDao.all());
        return "/all";
    }

    @GetMapping("/all/{id_db}")
    public String show(@PathVariable("id_db") int id_db, Model model) {

        model.addAttribute("student", studentDao.show(id_db));

        return "show";
    }

    @DeleteMapping("/all/{id_db}")
    public String delete(@PathVariable("id_db") int id_db){
        studentDao.delete(id_db);
        return "redirect:/all";
    }

    @GetMapping("/all/{id_db}/edit")
    public String edit(@PathVariable("id_db") int id_db, Model model){
        model.addAttribute("student", studentDao.show(id_db));
        return "/edit";
    }

    @PatchMapping("/all/{id_db}/edit")
    public String update(@PathVariable("id_db") int id_db, @ModelAttribute("student") Student student){

        studentDao.update(id_db, student);
        return "redirect:/all/{id_db}";
    }


}
