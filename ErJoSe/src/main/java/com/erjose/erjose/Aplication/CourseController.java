@Controller
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public List<CourseDTO> getAllAvailableCourses() {
        List<Course> courses = courseRepository.findByAvailabilityOrderByTitleAsc(true);
        return courses.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public CourseDTO createCourse(String title, String description, String imageUrl) {
        Course course = new Course();
        course.setTitle(title);
        course.setDescription(description);
        course.setDateOfPublication(LocalDate.now());
        course.setDateOfLastUpdate(LocalDate.now());
        course.setImageUrl(imageUrl);
        course.setCurrentPrice(0.0);
        course.setAvailability(false);

        Course savedCourse = courseRepository.save(course);
        return mapToDTO(savedCourse);
    }

    public CourseDTO updateCourse(Long courseId, UpdateCourseDTO updateDTO) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new NoSuchElementException("Course not found"));

        course.setTitle(updateDTO.getTitle());
        course.setDescription(updateDTO.getDescription());
        course.setImageUrl(updateDTO.getImageUrl());
        course.setDateOfLastUpdate(LocalDate.now());

        Course savedCourse = courseRepository.save(course);
        return mapToDTO(savedCourse);
    }

    public CourseDTO updatePrice(Long courseId, UpdatePriceDTO updateDTO) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new NoSuchElementException("Course not found"));

        course.setCurrentPrice(updateDTO.getCurrentPrice());
        Course savedCourse = courseRepository.save(course);
        return mapToDTO(savedCourse);
    }

    public CourseDTO updateAvailability(Long courseId, UpdateAvailabilityDTO updateDTO) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new NoSuchElementException("Course not found"));

        course.setAvailability(updateDTO.isAvailability());
        Course savedCourse = courseRepository.save(course);
        return mapToDTO(savedCourse);
    }

    private CourseDTO mapToDTO(Course course) {
        CourseDTO dto = new CourseDTO();
        dto.setId(course.getId());
        dto.setTitle(course.getTitle());
        dto.setDescription(course.getDescription());
        dto.setDateOfPublication(course.getDateOfPublication());
        dto.setDateOfLastUpdate(course.getDateOfLastUpdate());
        dto.setImageUrl(course.getImageUrl());
        dto.setCurrentPrice(course.getCurrentPrice());
        dto.setAvailability(course.isAvailability());
        return dto;
    }
}
