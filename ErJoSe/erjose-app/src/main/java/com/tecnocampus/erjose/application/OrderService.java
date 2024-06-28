package com.tecnocampus.erjose.application;

import com.tecnocampus.erjose.application.dto.OrderCreateDTO;
import com.tecnocampus.erjose.application.dto.OrderDTO;
import com.tecnocampus.erjose.application.exception.CourseNotFoundException;
import com.tecnocampus.erjose.application.exception.UserNotFoundException;
import com.tecnocampus.erjose.domain.*;
import com.tecnocampus.erjose.persistence.*;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final CourseRepository courseRepository;
    private final EnrollmentRepository enrollmentRepository;
    private final UserDetailsService userDetailsService;
    private final EnrollmentLessonRepository enrollmentLessonRepository;

    public OrderService(OrderRepository orderRepository,
                        UserRepository userRepository,
                        CourseRepository courseRepository,
                        EnrollmentRepository enrollmentRepository,
                        UserDetailsService userDetailsService,
                        EnrollmentLessonRepository enrollmentLessonRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.courseRepository = courseRepository;
        this.enrollmentRepository = enrollmentRepository;
        this.userDetailsService = userDetailsService;
        this.enrollmentLessonRepository = enrollmentLessonRepository;
    }

    @Transactional
    public OrderDTO createOrder(OrderCreateDTO orderCreateDTO){
        String username = userDetailsService.getAuthenticatedUsername();
        User user = userRepository.findByUsername(username).orElseThrow(() -> new UserNotFoundException(username));

        List<Course> courses = orderCreateDTO.coursesIds().stream()
                .map(courseId -> courseRepository.findById(courseId)
                .orElseThrow(() -> new CourseNotFoundException(courseId))).toList();
        Order order = new Order(user, courses);
        orderRepository.save(order);

        for (Course course : courses) {
            course.addStudent(user);
            Enrollment enrollment = new Enrollment(user, course);
            enrollmentRepository.save(enrollment);
            enrollment.createEnrollmentLessons(course.getLessons());
            user.addEnrollment(enrollment);
        }
        return new OrderDTO(order);
    }

    public List<OrderDTO> getOrders(Pageable pageable) {
        return orderRepository.getAllBy(pageable);
    }

}
