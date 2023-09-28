public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findByAvailabilityOrderByTitleAsc(boolean availability);
}