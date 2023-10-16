INSERT INTO courses (id, title, description, creation_date, last_update_date, image_url, current_price, available)
VALUES
    (random_uuid(), 'Full-Stack Web Development with Spring Boot 3 & React', 'Build full-stack web applications using Java, Spring Boot 3, Spring Data JPA, Spring Security, JWT, JavaScript, React JS & MySQL.', current_date, current_date,  '/images/nodejs.jpg', 64.99, true),
    (random_uuid(), 'Web Development with JavaScript', 'Master web development using JavaScript and related technologies.', current_date, current_date, '/images/javascript.jpg', 59.99, false),
    (random_uuid(), 'Data Science and Machine Learning', 'Explore data science and machine learning with practical examples.', current_date, current_date, '/images/datascience.jpg', 69.99, false),
    (random_uuid(), 'Java Programming for Beginners', 'Get started with Java programming from scratch.', current_date, current_date, '/images/java.jpg', 54.99, true),
    (random_uuid(), 'Introduction to Python Programming', 'Learn the fundamentals of Python programming language.', current_date, current_date, '/images/python.jpg', 49.99, true);