@RestController
@RequestMapping("/api/courses")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping("/available")
    public List<CourseDTO> getAllAvailableCourses() {
        return courseService.getAllAvailableCourses();
    }

    @PostMapping
    public CourseDTO createCourse(@RequestBody CreateCourseRequest request) {
        return courseService.createCourse(request.getTitle(), request.getDescription(), request.getImageUrl());
    }

    @PutMapping("/{courseId}")
    public CourseDTO updateCourse(@PathVariable Long courseId, @RequestBody UpdateCourseDTO updateDTO) {
        return courseService.updateCourse(courseId, updateDTO);
    }

    @PatchMapping("/{courseId}/price")
    public CourseDTO updatePrice(@PathVariable Long courseId, @RequestBody UpdatePriceDTO updateDTO) {
        return courseService.updatePrice(courseId, updateDTO);
    }

    @PatchMapping("/{courseId}/availability")
    public CourseDTO updateAvailability(@PathVariable Long courseId, @RequestBody UpdateAvailabilityDTO updateDTO) {
        return courseService.updateAvailability(courseId, updateDTO);
    }
}
