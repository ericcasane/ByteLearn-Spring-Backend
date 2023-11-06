-- Creación de la base de datos con datos de prueba
-- Idiomas de los cursos
/*INSERT INTO languages (id, name, locale, default_language)
VALUES
    ('1', 'English', 'en_US', true),
    ('2', 'Spanish', 'es_ES', false),
    ('3', 'Catala', 'ca_ES', false),
    ('4', 'French', 'fr_FR', false),
    ('5', 'German', 'de_DE', false),
    ('6', 'Italian', 'it_IT', false),
    ('7', 'Japanese', 'ja_JP', false),
    ('8', 'Portuguese', 'pt_PT', false),
    ('9', 'Russian', 'ru_RU', false),
    ('10','Dutch', 'nl_NL', false);*/
-- Categorías de los cursos
/*INSERT INTO categories (id, name, description)
VALUES
    ('1', 'Desarrollo Web', 'Cursos relacionados con el desarrollo y diseño de sitios web.'),
    ('2', 'Ciencias de la Información', 'Cursos sobre análisis y gestión de datos.'),
    ('3', 'Desarrollo de Aplicaciones Móviles', 'Cursos para aprender a desarrollar aplicaciones para dispositivos móviles.'),
    ('4', 'Lenguajes de Programación', 'Cursos sobre programación avanzada y desarrollo de software.'),
    ('5', 'Desarrollo de Videojuegos', 'Cursos sobre el diseño y desarrollo de videojuegos.');*/

-- Cursos
INSERT INTO courses (id, title, description, creation_date, last_update_date, image_url, current_price, available)
VALUES
    -- Cursos de Desarrollo Web
    ('a40edb92-17b3-4f3a-9758-9df565aa04f0', 'Diseño Web Inspirador: Más Allá de las Tendencias', 'Descubre cómo crear diseños web innovadores que van más allá de las tendencias actuales.', current_date, current_date, '/images/inspiring_web_design.jpg', 59.99, true),
    ('a40edb92-17b3-4f3a-9758-9df565aa04f1', 'Optimización de Rendimiento en Desarrollo Web', 'Aprende a optimizar el rendimiento de tus aplicaciones web para una experiencia de usuario excepcional.', current_date, current_date, '/images/web_performance.jpg', 59.99, true);
    /*
    ('a40edb92-17b3-4f3a-9758-9df565aa04f2', 'Desenvolupament d´Aplicacions Web Progressives amb React', 'Aprèn a crear aplicacions web progressives alt rendiment utilitzant React i PWA.', current_date, current_date, '/images/pwa_react.jpg', 69.99, true, '3'),
    ('a40edb92-17b3-4f3a-9758-9df565aa04f3', 'Desarrollo Web Responsivo para Dispositivos Móviles', 'Crea sitios web que se adapten perfectamente a cualquier dispositivo, desde smartphones hasta tablets.', current_date, current_date, '/images/responsive_web.jpg', 49.99, true, '2'),
    ('a40edb92-17b3-4f3a-9758-9df565aa04f4', 'Conception Web Inspirante: Au-delà des Tendances', 'Découvrez comment créer des designs web innovants qui vont au-delà des tendances actuelles.', current_date, current_date, '/images/inspiring_web_design.jpg', 64.99, true, '4'),
    ('a40edb92-17b3-4f3a-9758-9df565aa04f5', 'Seguridad Web Avanzada: Protegiendo tus Aplicaciones', 'Domina las técnicas et les outils pour assurer la sécurité de tes applications web.', current_date, current_date, '/images/web_security.jpg', 64.99, true, '4'),
    ('a40edb92-17b3-4f3a-9758-9df565aa04f6', 'Amazing CSS and JavaScript Web Animations', 'Create stunning animations for your websites using CSS and JavaScript.', current_date, current_date, '/images/web_animations.jpg', 49.99, true, '1'),
    ('a40edb92-17b3-4f3a-9758-9df565aa04f7', 'Full-Stack Web Development with Spring Boot 3 & React', 'Build full-stack web applications using Java, Spring Boot 3, Spring Data JPA, Spring Security, JWT, JavaScript, React JS & MySQL.', current_date, current_date, '/images/nodejs.jpg', 64.99, true, '1'),
    ('a40edb92-17b3-4f3a-9758-9df565aa04f8', 'Erstaunliche Animationen mit CSS und JavaScript', 'Erstellen Sie beeindruckende Animationen für Ihre Websites mit CSS und JavaScript.', current_date, current_date, '/images/web_animations.jpg', 59.99, true, '5'),
    ('a40edb92-17b3-4f3a-9758-9df565aa04f9', 'Arquitecturas de Microservicios en Desarrollo Web', 'Explora la arquitectura de microservicios und cómo implementarla en el desarrollo web.', current_date, current_date, '/images/microservices.jpg', 69.99, true, '2'),
    -- Cursos de Ciencias de la Información
    ('b40edb92-17b3-4f3a-9758-9df565aa04f0', 'Inteligencia Artificial en la Organización de la Información', 'Descubre cómo la IA transforma la organización y búsqueda de información.', current_date, current_date, '/images/ai_information.jpg', 64.99, true, '2', '2'),
    ('b40edb92-17b3-4f3a-9758-9df565aa04f1', 'Gestión de Datos: De la Teoría a la Práctica', 'Aprende a manejar y gestionar grandes volúmenes de datos de manera eficiente.', current_date, current_date, '/images/data_management.jpg', 54.99, true, '2', '2'),
    ('b40edb92-17b3-4f3a-9758-9df565aa04f2', 'Privacidad y Seguridad de la Información', 'Aprende a proteger la privacidad y seguridad de la información en el mundo digital.', current_date, current_date, '/images/information_security.jpg', 54.99, true, '2', '2'),
    ('b40edb92-17b3-4f3a-9758-9df565aa04f3', 'Anàlisi de Text i Processament del Llenguatge Natural', 'Explora tècniques avançades d´anàlisi de text i processament del llenguatge natural.', current_date, current_date, '/images/nlp.jpg', 59.99, true, '2', '3'),
    ('b40edb92-17b3-4f3a-9758-9df565aa04f4', 'Gestió del Coneixement en Organitzacions Modernes', 'Aprèn a gestionar i aprofitar el coneixement dins de les organitzacions.', current_date, current_date, '/images/knowledge_management.jpg', 64.99, true, '2', '3'),
    ('b40edb92-17b3-4f3a-9758-9df565aa04f5', 'Intelligence Artificielle dans lOrganisation de l´Information', 'Découvrez comment l´IA transforme l´organisation et la recherche d´information.', current_date, current_date, '/images/ai_information.jpg', 64.99, true, '2', '4'),
    ('b40edb92-17b3-4f3a-9758-9df565aa04f6', 'Analyse des Réseaux Sociaux et Comportement en Ligne', 'Explorez l´analyse des réseaux sociaux et le comportement des utilisateurs en ligne.', current_date, current_date, '/images/social_network_analysis.jpg', 64.99, true, '2', '4'),
    ('b40edb92-17b3-4f3a-9758-9df565aa04f7', 'Data Visualization for Informed Decision Making', 'Master data visualization techniques to present information effectively.', current_date, current_date, '/images/data_visualization.jpg', 59.99, true, '2', '1'),
    ('b40edb92-17b3-4f3a-9758-9df565aa04f8', 'Ethics in Information and Data Management', 'Learn about ethical aspects in information and data management in the digital age.', current_date, current_date, '/images/ethics_data_management.jpg', 49.99, true, '2', '1'),
    ('b40edb92-17b3-4f3a-9758-9df565aa04f9', 'Automatisierung von Informationsprozessen', 'Erfahren Sie, wie Sie Prozesse im Informationsmanagement automatisieren, um die Effizienz zu steigern.', current_date, current_date, '/images/information_automation.jpg', 59.99, true, '2', '4'),
    -- Cursos de Desarrollo Móvil
    ('c40edb92-17b3-4f3a-9758-9df565aa04f0', 'Desarrollo de Aplicaciones Nativas para iOS con Swift', 'Aprende a crear aplicaciones nativas de alta calidad para dispositivos iOS utilizando Swift.', current_date, current_date, '/images/ios_swift.jpg', 69.99, true, '3', '2'),
    ('c40edb92-17b3-4f3a-9758-9df565aa04f1', 'Desarrollo de Aplicaciones Híbridas con Ionic', 'Crea aplicaciones móviles multiplataforma utilizando Ionic, Angular y HTML.', current_date, current_date, '/images/ionic_mobile.jpg', 64.99, true, '3', '2'),
    ('c40edb92-17b3-4f3a-9758-9df565aa04f2', 'Desenvolupament d´Aplicacions Android amb Kotlin', 'Domina la creació d´aplicacions per a dispositius Android utilitzant el llenguatge Kotlin.', current_date, current_date, '/images/android_kotlin.jpg', 64.99, true, '3', '3'),
    ('c40edb92-17b3-4f3a-9758-9df565aa04f3', 'Monetització d´Aplicacions Mòbils', 'Aprèn estratègies efectives per monetitzar les teves aplicacions mòbils i generar ingressos.', current_date, current_date, '/images/mobile_monetization.jpg', 59.99, true, '3', '3'),
    ('c40edb92-17b3-4f3a-9758-9df565aa04f4', 'Conception d´Interfaces Utilisateur pour Applications Mobiles', 'Apprends à concevoir des interfaces utilisateur intuitives et attrayantes pour les applications mobiles.', current_date, current_date, '/images/mobile_ui_design.jpg', 54.99, true, '3', '4'),
    ('c40edb92-17b3-4f3a-9758-9df565aa04f5', 'Développement de Jeux Mobiles avec Unity', 'Créez des jeux mobiles passionnants en utilisant le moteur Unity et C#.', current_date, current_date, '/images/unity_mobile.jpg', 69.99, true, '3', '4'),
    ('c40edb92-17b3-4f3a-9758-9df565aa04f6', 'Mobile App Performance Optimization', 'Learn to optimize the performance and efficiency of your mobile apps for a seamless experience.', current_date, current_date, '/images/mobile_performance.jpg', 59.99, true, '3', '1'),
    ('c40edb92-17b3-4f3a-9758-9df565aa04f7', 'Augmented Reality in Mobile Applications', 'Explore the integration of augmented reality in mobile applications for immersive experiences.', current_date, current_date, '/images/ar_mobile.jpg', 64.99, true, '3', '1'),
    ('c40edb92-17b3-4f3a-9758-9df565aa04f8', 'Sensor Integration in Mobile Applications', 'Discover how to use sensors in mobile devices to create interactive experiences.', current_date, current_date, '/images/mobile_sensors.jpg', 49.99, true, '3', '1'),
    ('c40edb92-17b3-4f3a-9758-9df565aa04f9', 'Development of Native iOS Apps with Swift', 'Learn to create high-quality native apps for iOS devices using Swift.', current_date, current_date, '/images/ios_swift.jpg', 69.99, true, '3', '1'),
    -- Cursos de Lenguajes de Programación
    ('d40edb92-17b3-4f3a-9758-9df565aa04f0', 'Python: Más Allá de lo Básico', 'Explora las características avanzadas y técnicas poderosas de programación en Python.', current_date, current_date, '/images/python_advanced.jpg', 59.99, true, '4', '2'),
    ('d40edb92-17b3-4f3a-9758-9df565aa04f1', 'Rust: Programación Segura y Eficiente', 'Aprende a programar en Rust para desarrollar aplicaciones seguras y de alto rendimiento.', current_date, current_date, '/images/rust_programming.jpg', 64.99, true, '4', '2'),
    ('d40edb92-17b3-4f3a-9758-9df565aa04f2', 'Dominant JavaScript: Programació Funcional', 'Aprèn a aplicar conceptes de programació funcional en JavaScript per escriure codi més net i eficient.', current_date, current_date, '/images/functional_js.jpg', 64.99, true, '4', '3'),
    ('d40edb92-17b3-4f3a-9758-9df565aa04f3', 'Java: Développement d´Applications d´Entreprise', 'Découvrez comment développer des applications d´entreprise robustes en utilisant le langage de programmation Java.', current_date, current_date, '/images/java_enterprise.jpg', 64.99, true, '4', '4'),
    ('d40edb92-17b3-4f3a-9758-9df565aa04f4', 'C#: Windows Forms Application Development', 'Learn to create Windows Forms desktop applications using the C# programming language.', current_date, current_date, '/images/csharp_windows.jpg', 54.99, true, '4', '1'),
    ('d40edb92-17b3-4f3a-9758-9df565aa04f5', 'Ruby on Rails: Building Web Applications', 'Create dynamic and high-performance web applications using Ruby on Rails.', current_date, current_date, '/images/ruby_rails.jpg', 59.99, true, '4', '1'),
    ('d40edb92-17b3-4f3a-9758-9df565aa04f6', 'Go: Concurrent Application Development', 'Explore concurrent programming in Go to build scalable and efficient applications.', current_date, current_date, '/images/go_concurrent.jpg', 64.99, true, '4', '1'),
    ('d40edb92-17b3-4f3a-9758-9df565aa04f7', 'Android App Development with Java', 'Learn to develop Android apps using the Java programming language.', current_date, current_date, '/images/java_android.jpg', 54.99, true, '4', '1'),
    ('d40edb92-17b3-4f3a-9758-9df565aa04f8', 'Swift: Programming for Apple Platforms', 'Master Swift programming to create stunning apps on Apple devices.', current_date, current_date, '/images/swift_programming.jpg', 59.99, true, '4', '1'),
    ('d40edb92-17b3-4f3a-9758-9df565aa04f9', 'Web Application Development with Django', 'Create powerful and scalable web applications using the Python Django framework.', current_date, current_date, '/images/django_web.jpg', 69.99, true, '4', '1'),
    -- Cursos de Desarrollo de Videojuegos
    ('e40edb92-17b3-4f3a-9758-9df565aa04f0', 'Introducción al Diseño de Videojuegos', 'Descubre los principios fundamentales del diseño de videojuegos y crea tus propios prototipos.', current_date, current_date, '/images/game_design.jpg', 54.99, true, '5', '2'),
    ('e40edb92-17b3-4f3a-9758-9df565aa04f1', 'Diseño de Personajes para Videojuegos', 'Domina las técnicas de diseño de personajes para dar vida a tus juegos.', current_date, current_date, '/images/character_design.jpg', 54.99, true, '5', '2'),
    ('e40edb92-17b3-4f3a-9758-9df565aa04f2', 'Efectos Visuales Espectaculares en Videojuegos', 'Aprende a crear efectos visuales impresionantes para mejorar la experiencia de juego.', current_date, current_date, '/images/vfx_game.jpg', 59.99, true, '5', '2'),
    ('e40edb92-17b3-4f3a-9758-9df565aa04f3', 'Narrativa Interactiva en Videojuegos', 'Explora técnicas de narrativa interactiva para crear experiencias inmersivas en tus juegos.', current_date, current_date, '/images/interactive_narrative.jpg', 54.99, true, '5', '2'),
    ('e40edb92-17b3-4f3a-9758-9df565aa04f4', 'Optimización de Rendimiento en Desarrollo de Videojuegos', 'Aprende a optimizar el rendimiento de tus juegos para proporcionar una experiencia de juego fluida.', current_date, current_date, '/images/game_performance.jpg', 59.99, true, '5', '2'),
    ('e40edb92-17b3-4f3a-9758-9df565aa04f5', 'Desarrollo de Juegos Educativos para Niños', 'Crea juegos educativos interactivos para niños y fomenta el aprendizaje a través del juego.', current_date, current_date, '/images/educational_game.jpg', 54.99, true, '5', '2'),
    ('e40edb92-17b3-4f3a-9758-9df565aa04f6', 'Unity 2D: Create Your First Platformer Game', 'Learn to develop an exciting 2D platformer game using Unity.', current_date, current_date, '/images/unity_2d.jpg', 59.99, true, '5', '1'),
    ('e40edb92-17b3-4f3a-9758-9df565aa04f7', 'Artificial Intelligence in Games with Unity', 'Learn to implement AI to create intelligent enemies and non-playable characters in your games.', current_date, current_date, '/images/ai_game.jpg', 64.99, true, '5', '1'),
    ('e40edb92-17b3-4f3a-9758-9df565aa04f8', 'Developing Virtual Reality Games with Unreal Engine', 'Create immersive virtual reality experiences using the Unreal Engine.', current_date, current_date, '/images/vr_unreal.jpg', 69.99, true, '5', '1'),
    ('e40edb92-17b3-4f3a-9758-9df565aa04f9', 'Cross-Platform Game Development with Phaser', 'Create fun and addictive games that work on different platforms using Phaser.', current_date, current_date, '/images/phaser_game.jpg', 64.99, true, '5', '1');
*/
-- Usuarios
INSERT INTO users (id, first_name, last_name, email, gender, username)
VALUES
    ('0a8df84e-7e91-4509-9c02-e6d8b29f93b5', 'Mia', 'Khalifa Gomez', 'mia.perez@outlook.com', 'FEMALE', 'miamia'),
    ('c40edb92-17b3-4f3a-9758-9df565aa04f1', 'John', 'Doe William', 'john.doe@gmail.com', 'MALE', 'johnny'),
    ('59e06854-3406-449f-8f0e-292d65756ed8', 'Jane', 'Smith Elizabeth', 'jane.smith@yahoo.com', 'OTHER', 'liz_smith'),
    ('efd61065-409b-4962-b619-09a324ad0f50', 'Michael', 'Johnson Robert', 'michael.johnson@hotmail.com', 'MALE', 'mike'),
    ('cdb63d03-18c2-41bd-baeb-0303b0c49571', 'Emily', 'Williams Grace', 'emily.williams@outlook.com', 'FEMALE', 'emmy'),
    ('cecfd4a6-53e9-4a2e-bcd3-7a8d40773498', 'William', 'Brown Thomas', 'william.brown@aol.com', 'MALE', 'billy'),
    ('3c4622cf-7626-4aa5-934e-6c17df6a52a0', 'Olivia', 'Jones Taylor', 'olivia.jones@icloud.com', 'FEMALE', 'livvy'),
    ('8e1f5141-2b12-4ea4-8fc5-0676d6da9a14', 'James', 'Garcia Charles', 'james.garcia@protonmail.com', 'MALE', 'jamie'),
    ('f1434b85-72c9-4ed0-86c1-6b680ae464f3', 'Ava', 'Miller Rose', 'ava.miller@yandex.com', 'OTHER', 'avam'),
    ('8f187f98-d32d-468d-8a27-79c65a4a6b15', 'David', 'Davis Lee', 'david.davis@msn.com', 'MALE', 'davidd'),
    ('aa4266d4-3696-4859-80d7-9e94d2df128c', 'Sophia', 'Rodriguez Martinez', 'sophia.rodriguez@gmail.com', 'FEMALE', 'sophiarod'),
    ('30a8c656-18f7-4536-8b9f-2ef3a03f587e', 'Ethan', 'Hernandez Martin', 'ethan.hernandez@yahoo.com', 'MALE', 'ethanh'),
    ('63c62e33-4d01-4b93-b8e7-d799e241ea6d', 'Isabella', 'Lopez Sanchez', 'isabella.lopez@hotmail.com', 'OTHER', 'isabellal'),
    ('f32a4a2b-c648-49a7-b108-280034b4d063', 'Alexander', 'Gonzalez Perez', 'alexander.gonzalez@gmail.com', 'MALE', 'alexperez'),
    ('0710d6ab-0720-4b66-8402-f27e0daec5bb', 'Daniel', 'Sanchez Romero', 'daniel.sanchez@aol.com', 'MALE', 'danrom');

