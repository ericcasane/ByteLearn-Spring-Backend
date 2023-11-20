package com.tecnocampus.erjose.application;

import com.tecnocampus.erjose.application.dto.OrderDTO;
import com.tecnocampus.erjose.application.exception.CourseNotFoundException;
import com.tecnocampus.erjose.application.exception.UserNotFoundException;
import com.tecnocampus.erjose.domain.Course;
import com.tecnocampus.erjose.domain.Enrollment;
import com.tecnocampus.erjose.domain.Order;
import com.tecnocampus.erjose.domain.User;
import com.tecnocampus.erjose.persistence.CourseRepository;
import com.tecnocampus.erjose.persistence.EnrollmentRepository;
import com.tecnocampus.erjose.persistence.OrderRepository;
import com.tecnocampus.erjose.persistence.UserRepository;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final CourseRepository courseRepository;
    private final EnrollmentRepository enrollmentRepository;

    public OrderService(OrderRepository orderRepository,
                        UserRepository userRepository,
                        CourseRepository courseRepository,
                        EnrollmentRepository enrollmentRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.courseRepository = courseRepository;
        this.enrollmentRepository = enrollmentRepository;
    }

    @Transactional
    public OrderDTO createOrder(OrderDTO orderDTO){
        //String username = userService.getAuthenticatedUsername();
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByUsername(username).orElseThrow(() -> new UserNotFoundException(username));

        List<Course> courses = orderDTO.coursesIds().stream()
                .map(courseId -> courseRepository.findById(courseId)
                .orElseThrow(() -> new CourseNotFoundException(courseId))).toList();
        Order order = new Order(user, courses);
        orderRepository.save(order);

        for (Course course : courses) {
            Enrollment enrollment = new Enrollment(user, course);
            enrollmentRepository.save(enrollment);
        }
        return new OrderDTO(order);
    }

    public List<OrderDTO> getOrders() {
        return orderRepository.findAll().stream().map(OrderDTO::new).toList();
    }

}
