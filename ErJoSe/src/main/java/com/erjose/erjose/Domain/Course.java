@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private LocalDate dateOfPublication;
    private LocalDate dateOfLastUpdate;
    private String imageUrl;
    private double currentPrice;
    private boolean availability;

    // Getters y Setters
}