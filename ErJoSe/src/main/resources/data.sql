INSERT INTO courses (id, title, description, creation_date, last_update_date, image_url, current_price, available)
VALUES
    ('c40edb92-17b3-4f3a-9758-9df565aa04f1', 'Full-Stack Web Development with Spring Boot 3 & React', 'Build full-stack web applications using Java, Spring Boot 3, Spring Data JPA, Spring Security, JWT, JavaScript, React JS & MySQL.', current_date, current_date,  '/images/nodejs.jpg', 64.99, true),
    ('59e06854-3406-449f-8f0e-292d65756ed8', 'Web Development with JavaScript', 'Master web development using JavaScript and related technologies.', current_date, current_date, '/images/javascript.jpg', 59.99, false),
    ('efd61065-409b-4962-b619-09a324ad0f50', 'Data Science and Machine Learning', 'Explore data science and machine learning with practical examples.', current_date, current_date, '/images/datascience.jpg', 69.99, false),
    ('cdb63d03-18c2-41bd-baeb-0303b0c49571', 'Java Programming for Beginners', 'Get started with Java programming from scratch.', current_date, current_date, '/images/java.jpg', 54.99, true),
    ('cecfd4a6-53e9-4a2e-bcd3-7a8d40773498', 'Introduction to Python Programming', 'Learn the fundamentals of Python programming language.', current_date, current_date, '/images/python.jpg', 49.99, true);
INSERT INTO users (id,name, second_name, third_name, email, gender, username)
VALUES
    (random_uuid(), 'John', 'Doe', 'William', 'john.doe@gmail.com', 'Male', 'johnny'),
    (random_uuid(), 'Jane', 'Smith', 'Elizabeth', 'jane.smith@yahoo.com', 'Female', 'liz_smith'),
    (random_uuid(), 'Michael', 'Johnson', 'Robert', 'michael.johnson@hotmail.com', 'Male', 'mike'),
    (random_uuid(), 'Emily', 'Williams', 'Grace', 'emily.williams@outlook.com', 'Female', 'emmy'),
    (random_uuid(), 'William', 'Brown', 'Thomas', 'william.brown@aol.com', 'Male', 'billy'),
    (random_uuid(), 'Olivia', 'Jones', 'Taylor', 'olivia.jones@icloud.com', 'Female', 'livvy'),
    (random_uuid(), 'James', 'Garcia', 'Charles', 'james.garcia@protonmail.com', 'Male', 'jamie'),
    (random_uuid(), 'Ava', 'Miller', 'Rose', 'ava.miller@yandex.com', 'Female', 'avam'),
    (random_uuid(), 'David', 'Davis', 'Lee', 'david.davis@msn.com', 'Male', 'davidd'),
    (random_uuid(), 'Sophia', 'Rodriguez', 'Martinez', 'sophia.rodriguez@gmail.com', 'Female', 'sophiarod');