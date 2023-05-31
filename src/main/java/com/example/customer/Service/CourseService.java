package com.example.customer.Service;

import com.example.customer.Entity.Course;
import com.example.customer.Entity.Customer;
import com.example.customer.Repository.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
    public class CourseService {
        @Autowired
        private CourseRepo courseRepo;

        public List<Course> getAllCourses() {
            return courseRepo.findAll();
        }

        public Course createCourse(Course course) {

            return courseRepo.save(course);
        }

        public Course updateCourse(int courseid, Course courseDetails)  {
            if (courseRepo.existsById(courseid)) {
                Course course = courseRepo.getById(courseid);

                course.setCourseName(courseDetails.getCourseName());
                course.setDescription(courseDetails.getDescription());
                courseRepo.save(course);
            }
            else {
                System.out.println("Course Id not found");
            }
            return null;
        }

        public Course getCourseById(int courseid) {
            Optional<Course> courseOptional = courseRepo.findById(courseid);
            return courseOptional.orElse(null);
        }
        public boolean deleteCourse(int courseid) {
            if (courseRepo.existsById(courseid)) {
                courseRepo.deleteById(courseid);
            }
            else{
                System.out.println("Course Id not found");
            }
            return true;
        }
    }
