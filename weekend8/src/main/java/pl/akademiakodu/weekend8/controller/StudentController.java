package pl.akademiakodu.weekend8.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.akademiakodu.weekend8.entity.Address;
import pl.akademiakodu.weekend8.entity.Book;
import pl.akademiakodu.weekend8.entity.Student;
import pl.akademiakodu.weekend8.entity.StudentDetails;
import pl.akademiakodu.weekend8.service.StudentService;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.List;

/**
 * Created by itml on 27.05.2017.
 */
@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentServiceCrudImpl;

    @GetMapping("/{id}")
    public ModelAndView getStudent(@PathVariable("id") Long id) {
        Student student = studentServiceCrudImpl.get(id);
        ModelAndView modelAndView = new ModelAndView("student");
        modelAndView.addObject("object", student);
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteStudent(@PathVariable("id") Long id) {
        studentServiceCrudImpl.delete(id);
        return new ModelAndView("redirect:/student");
    }

    @PostMapping("/add")
    public ModelAndView processForm(@ModelAttribute @Valid Student student, BindingResult bindingResult) {
        System.out.println(student);
        ModelAndView modelAndView = new ModelAndView("form");
        modelAndView.addObject(student);
        if (bindingResult.hasErrors()) {
            return modelAndView;
        } else {
            boolean saved = studentServiceCrudImpl.save(student);
            if (!saved) {
                bindingResult.addError(new FieldError("student", "name",
                        "Student o takim imieniu i nazwisku już istnieje" ));

                return modelAndView;
            } else {
                return new ModelAndView("redirect:/student");
            }
        }
    }

    @GetMapping("/add")
    public ModelAndView addStudentForm() {
        ModelAndView modelAndView = new ModelAndView("form");
        Student student = new Student();
        student.setStudentDetails(new StudentDetails());
        student.setAddress(new Address());
        modelAndView.addObject(student);
        return modelAndView;
    }

    @GetMapping("/update/{id}")
    public ModelAndView updateStudentForm(@PathVariable("id") Long id) {
        Student student = studentServiceCrudImpl.get(id);
        ModelAndView modelAndView = new ModelAndView("form");
        modelAndView.addObject(student);
        return modelAndView;
    }

    @GetMapping
    public ModelAndView getList(@PathParam("city") String city) {
        ModelAndView mav = new ModelAndView("list");
        if (city != null) {
            return mav.addObject("list", studentServiceCrudImpl.findByCity(city));
        } else {
            return mav.addObject("list", studentServiceCrudImpl.findAll());
        }
    }
}
