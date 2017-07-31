package pl.akademiakodu.weekend8.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.akademiakodu.weekend8.entity.Student;
import pl.akademiakodu.weekend8.service.CourseService;
import pl.akademiakodu.weekend8.service.StudentService;

/**
 * Created by itml on 10.06.2017.
 */
@Controller
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseServiceImpl;

    @GetMapping
    public ModelAndView list() {
        return list(null);
    }

    @GetMapping("{id}")
    public ModelAndView list(@PathVariable("id") Long studentId) {
        ModelAndView mav = new ModelAndView("course/list");
        mav.addObject("studentId", studentId);
        mav.addObject("list", courseServiceImpl.findAll());
        return mav;
    }

    @GetMapping("/enroll/{cid}/{id}")
    public ModelAndView enroll(@PathVariable("cid") Long courseId, @PathVariable("id") Long studentId) {
        ModelAndView mav = new ModelAndView("redirect:/course/" + studentId);
        courseServiceImpl.enroll(courseId, studentId);
        return mav;
    }
}
