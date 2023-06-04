package com.example.customer.Controller;

import com.example.customer.Entity.Course;
import com.example.customer.Entity.Customer;
import com.example.customer.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


//
//can be used
//

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping("/getAllCourse")
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @PostMapping("/save")
    public Course createCourse(@RequestBody Course course) {
        return courseService.createCourse(course);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable(value = "id") int courseId, @RequestBody Course courseDetails) {
        final Course updatedCourse = courseService.updateCourse(courseId, courseDetails);
        return ResponseEntity.ok(updatedCourse);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCourse(@PathVariable(value = "id") int courseId) {
        boolean deleteCourse = courseService.deleteCourse(courseId);
        return "deleted";
    }
}

//
//Can be used
//
//@RestController
//@RequestMapping("/course")
//public class CourseController {
//    @Autowired
//    private CourseService courseService;
//
//    @GetMapping("/getAllCourse")
//    public String getAllCourses(Model model) {
//        List<Course> courses = courseService.getAllCourses();
//        model.addAttribute("courses", courses);
//        return "course";
//    }
//
//    @GetMapping("/create")
//    public String createCourseForm(Model model) {
//        model.addAttribute("course", new Course());
//        return "createCourse";
//    }
//
//    @PostMapping("/save")
//    public String createCourse(@ModelAttribute("course") Course course) {
//        courseService.createCourse(course);
//        return "redirect:/course/getAllCourse";
//    }
//
//    @GetMapping("/update/{id}")
//    public String updateCourseForm(@PathVariable("id") int courseid, Model model) {
//        Course course = courseService.getCourseById(courseid);
//        model.addAttribute("course", course);
//        return "updateCourse";
//    }
//
//    @PostMapping("/update/{id}")
//    public String updateCourse(@PathVariable("id") int courseid, @ModelAttribute("course") Course course) {
//        courseService.updateCourse(courseid, course);
//        return "redirect:/course/getAllCourse";
//    }
//
//    @GetMapping("/delete/{id}")
//    public String deleteCourse(@PathVariable("id") int courseid) {
//        courseService.deleteCourse(courseid);
//        return "redirect:/course/getAllCourse";
//    }
//}
