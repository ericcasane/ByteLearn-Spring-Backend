-- Creación de la base de datos con datos de prueba
-- Languages of the courses
INSERT INTO languages (id, name, locale, default_language)
VALUES
    ('1', 'English', 'en_US', true),
    ('2', 'Spanish', 'es_ES', false),
    ('3', 'Catala', 'ca_ES', false),
    ('4', 'French', 'fr_FR', false),
    ('5', 'German', 'de_DE', false);

-- Categories of the courses
INSERT INTO categories (id, name, description)
VALUES
    ('1', 'Desarrollo Web', 'Cursos relacionados con el desarrollo y diseño de sitios web.'),
    ('2', 'Ciencias de la Información', 'Cursos sobre análisis y gestión de datos.'),
    ('3', 'Desarrollo de Aplicaciones Móviles', 'Cursos para aprender a desarrollar aplicaciones para dispositivos móviles.'),
    ('4', 'Lenguajes de Programación', 'Cursos sobre programación avanzada y desarrollo de software.'),
    ('5', 'Desarrollo de Videojuegos', 'Cursos sobre el diseño y desarrollo de videojuegos.');

-- Cursos
INSERT INTO courses (id, title, description, current_price, available, created_at, updated_at, language_id, image_url)
VALUES
    -- Cursos de Desarrollo Web
    ('a40edb92-17b3-4f3a-9758-9df565aa04f0', 'Diseño Web Inspirador: Más Allá de las Tendencias', 'Descubre cómo crear diseños web innovadores que van más allá de las tendencias actuales.', 59.99, true, current_timestamp, current_timestamp, 2, 'https://images.unsplash.com/photo-1534670007418-fbb7f6cf32c3?q=80&w=1888&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D'),
    ('a40edb92-17b3-4f3a-9758-9df565aa04f1', 'Optimización de Rendimiento en Desarrollo Web', 'Aprende a optimizar el rendimiento de tus aplicaciones web para una experiencia de usuario excepcional.', 59.99, false, current_timestamp, current_timestamp, 2, 'https://images.unsplash.com/photo-1517694712202-14dd9538aa97?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Nnx8ZGVzYXJyb2xsbyUyMHdlYnxlbnwwfHwwfHx8MA%3D%3D'),
    ('a40edb92-17b3-4f3a-9758-9df565aa04f2', 'Desenvolupament d´Aplicacions Web Progressives amb React', 'Aprèn a crear aplicacions web progressives alt rendiment utilitzant React i PWA.', 69.99, true, current_timestamp, current_timestamp, 3, 'https://images.unsplash.com/photo-1488590528505-98d2b5aba04b?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mzh8fENpZW5jaWFzJTIwZGUlMjBsYSUyMEluZm9ybWFjaSVDMyVCM258ZW58MHx8MHx8fDA%3D'),
    ('a40edb92-17b3-4f3a-9758-9df565aa04f3', 'Desarrollo Web Responsivo para Dispositivos Móviles', 'Crea sitios web que se adapten perfectamente a cualquier dispositivo, desde smartphones hasta tablets.', 49.99, true, current_timestamp, current_timestamp, 2, 'https://images.unsplash.com/photo-1517292987719-0369a794ec0f?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MjB8fERlc2Fycm9sbG8lMjBEaXNwb3NpdGl2b3MlMjBNJUMzJUIzdmlsZXN8ZW58MHx8MHx8fDA%3D'),
    ('a40edb92-17b3-4f3a-9758-9df565aa04f4', 'Conception Web Inspirante: Au-delà des Tendances', 'Découvrez comment créer des designs web innovants qui vont au-delà des tendances actuelles.', 64.99, true, current_timestamp, current_timestamp, 4, 'https://images.unsplash.com/photo-1460925895917-afdab827c52f?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MXx8U2VndXJpZGFkJTIwV2ViJTIwQXZhbnphZGF8ZW58MHx8MHx8fDA%3D'),
    ('a40edb92-17b3-4f3a-9758-9df565aa04f5', 'Seguridad Web Avanzada: Protegiendo tus Aplicaciones', 'Domina las técnicas et les outils pour assurer la sécurité de tes applications web.', 64.99, true, current_timestamp, current_timestamp, 4, 'https://images.unsplash.com/photo-1451187580459-43490279c0fa?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTZ8fFNlZ3VyaWRhZCUyMFdlYiUyMEF2YW56YWRhfGVufDB8fDB8fHww'),
    ('a40edb92-17b3-4f3a-9758-9df565aa04f6', 'Amazing CSS and JavaScript Web Animations', 'Create stunning animations for your websites using CSS and JavaScript.', 49.99, true, current_timestamp, current_timestamp, 1, 'https://images.unsplash.com/photo-1607706189992-eae578626c86?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTJ8fENTUyUyMGFuZCUyMEphdmFTY3JpcHR8ZW58MHx8MHx8fDA%3D'),
    ('a40edb92-17b3-4f3a-9758-9df565aa04f7', 'Full-Stack Web Development with Spring Boot 3 & React', 'Build full-stack web applications using Java, Spring Boot 3, Spring Data JPA, Spring Security, JWT, JavaScript, React JS & MySQL.', 64.99, true, current_timestamp, current_timestamp, 1, 'https://images.unsplash.com/photo-1519211975560-4ca611f5a72a?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NTR8fHdlYnNpdGV8ZW58MHx8MHx8fDA%3D'),
    ('a40edb92-17b3-4f3a-9758-9df565aa04f8', 'Erstaunliche Animationen mit CSS und JavaScript', 'Erstellen Sie beeindruckende Animationen für Ihre Websites mit CSS und JavaScript.', 59.99, true, current_timestamp, current_timestamp, 5, 'https://images.unsplash.com/photo-1583484963886-cfe2bff2945f?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTN8fFNlZ3VyaWRhZCUyMFdlYiUyMEF2YW56YWRhfGVufDB8fDB8fHww'),
    ('a40edb92-17b3-4f3a-9758-9df565aa04f9', 'Arquitecturas de Microservicios en Desarrollo Web', 'Explora la arquitectura de microservicios und cómo implementarla en el desarrollo web.', 69.99, true, current_timestamp, current_timestamp, 2, 'https://images.unsplash.com/photo-1667372459510-55b5e2087cd0?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8bWljcm9zZXJ2aWNpb3N8ZW58MHx8MHx8fDA%3D'),
    -- Cursos de Ciencias de la Información
    ('b40edb92-17b3-4f3a-9758-9df565aa04f0', 'Inteligencia Artificial en la Organización de la Información', 'Descubre cómo la IA transforma la organización y búsqueda de información.', 64.99, true, current_timestamp, current_timestamp, 2, 'https://images.unsplash.com/photo-1485827404703-89b55fcc595e?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mjh8fEludGVsaWdlbmNpYSUyMEFydGlmaWNpYWx8ZW58MHx8MHx8fDA%3D'),
    ('b40edb92-17b3-4f3a-9758-9df565aa04f1', 'Gestión de Datos: De la Teoría a la Práctica', 'Aprende a manejar y gestionar grandes volúmenes de datos de manera eficiente.', 54.99, true, current_timestamp, current_timestamp, 2, 'https://images.unsplash.com/photo-1558494949-ef010cbdcc31?q=80&w=1934&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D'),
    ('b40edb92-17b3-4f3a-9758-9df565aa04f2', 'Privacidad y Seguridad de la Información', 'Aprende a proteger la privacidad y seguridad de la información en el mundo digital.', 54.99, true, current_timestamp, current_timestamp, 2, 'https://images.unsplash.com/photo-1461685265823-f8d5d0b08b9b?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8cHJpdmFjaWRhZHxlbnwwfHwwfHx8MA%3D%3D'),
    ('b40edb92-17b3-4f3a-9758-9df565aa04f3', 'Anàlisi de Text i Processament del Llenguatge Natural', 'Explora tècniques avançades d´anàlisi de text i processament del llenguatge natural.', 59.99, true, current_timestamp, current_timestamp, 3, 'https://images.unsplash.com/photo-1557597774-9d273605dfa9?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MjN8fCdQcml2YWNpZGFkJTIweSUyMFNlZ3VyaWRhZHxlbnwwfHwwfHx8MA%3D%3D'),
    ('b40edb92-17b3-4f3a-9758-9df565aa04f4', 'Gestió del Coneixement en Organitzacions Modernes', 'Aprèn a gestionar i aprofitar el coneixement dins de les organitzacions.', 64.99, true, current_timestamp, current_timestamp, 3, 'https://images.unsplash.com/photo-1556761175-b413da4baf72?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8T3JnYW5pdHphY2lvbnN8ZW58MHx8MHx8fDA%3D'),
    ('b40edb92-17b3-4f3a-9758-9df565aa04f5', 'Intelligence Artificielle dans lOrganisation de l´Information', 'Découvrez comment l´IA transforme l´organisation et la recherche d´information.', 64.99, true, current_timestamp, current_timestamp, 4, 'https://images.unsplash.com/photo-1677442136019-21780ecad995?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8M3x8SUF8ZW58MHx8MHx8fDA%3D'),
    ('b40edb92-17b3-4f3a-9758-9df565aa04f6', 'Analyse des Réseaux Sociaux et Comportement en Ligne', 'Explorez l´analyse des réseaux sociaux et le comportement des utilisateurs en ligne.', 64.99, true, current_timestamp, current_timestamp, 4, 'https://images.unsplash.com/photo-1503945438517-f65904a52ce6?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mjh8fG9ubGluZXxlbnwwfHwwfHx8MA%3D%3D'),
    ('b40edb92-17b3-4f3a-9758-9df565aa04f7', 'Data Visualization for Informed Decision Making', 'Master data visualization techniques to present information effectively.', 59.99, true, current_timestamp, current_timestamp, 1, 'https://images.unsplash.com/photo-1551288049-bebda4e38f71?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8RGF0YSUyMFZpc3VhbGl6YXRpb258ZW58MHx8MHx8fDA%3D'),
    ('b40edb92-17b3-4f3a-9758-9df565aa04f8', 'Ethics in Information and Data Management', 'Learn about ethical aspects in information and data management in the digital age.', 49.99, true, current_timestamp, current_timestamp, 1, 'https://images.unsplash.com/photo-1599658880436-c61792e70672?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTV8fERhdGElMjBNYW5hZ2VtZW50fGVufDB8fDB8fHww'),
    ('b40edb92-17b3-4f3a-9758-9df565aa04f9', 'Automatisierung von Informationsprozessen', 'Erfahren Sie, wie Sie Prozesse im Informationsmanagement automatisieren, um die Effizienz zu steigern.', 59.99, true, current_timestamp, current_timestamp, 5, 'https://images.unsplash.com/photo-1488229297570-58520851e868?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTF8fERhdGElMjBNYW5hZ2VtZW50fGVufDB8fDB8fHww'),
    -- Cursos de Desarrollo Móvil
    ('c40edb92-17b3-4f3a-9758-9df565aa04f0', 'Desarrollo de Aplicaciones Nativas para iOS con Swift', 'Aprende a crear aplicaciones nativas de alta calidad para dispositivos iOS utilizando Swift.', 69.99, true, current_timestamp, current_timestamp, 2, 'https://images.unsplash.com/photo-1512941937669-90a1b58e7e9c?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NHx8aU9TfGVufDB8fDB8fHww'),
    ('c40edb92-17b3-4f3a-9758-9df565aa04f1', 'Desarrollo de Aplicaciones Híbridas con Ionic', 'Crea aplicaciones móviles multiplataforma utilizando Ionic, Angular y HTML.', 64.99, true, current_timestamp, current_timestamp, 2, 'https://images.unsplash.com/photo-1542641728-6ca359b085f4?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8N3x8YXBsaWNhY2lvbmVzJTIwbW92aWxlc3xlbnwwfHwwfHx8MA%3D%3D'),
    ('c40edb92-17b3-4f3a-9758-9df565aa04f2', 'Desenvolupament d´Aplicacions Android amb Kotlin', 'Domina la creació d´aplicacions per a dispositius Android utilitzant el llenguatge Kotlin.', 64.99, true, current_timestamp, current_timestamp, 3, 'https://images.unsplash.com/photo-1609921141835-710b7fa6e438?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTB8fGFwbGljYWNpb25lcyUyMG1vdmlsZXN8ZW58MHx8MHx8fDA%3D'),
    ('c40edb92-17b3-4f3a-9758-9df565aa04f3', 'Monetització d´Aplicacions Mòbils', 'Aprèn estratègies efectives per monetitzar les teves aplicacions mòbils i generar ingressos.', 59.99, true, current_timestamp, current_timestamp, 3, 'https://images.unsplash.com/photo-1601972602237-8c79241e468b?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8YXBsaWNhY2lvbiUyMG1vdmlsfGVufDB8fDB8fHww'),
    ('c40edb92-17b3-4f3a-9758-9df565aa04f4', 'Conception d´Interfaces Utilisateur pour Applications Mobiles', 'Apprends à concevoir des interfaces utilisateur intuitives et attrayantes pour les applications mobiles.', 54.99, true, current_timestamp, current_timestamp, 4, 'https://images.unsplash.com/photo-1558655146-364adaf1fcc9?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTB8fGFwbGljYWNpb24lMjBtb3ZpbHxlbnwwfHwwfHx8MA%3D%3D'),
    ('c40edb92-17b3-4f3a-9758-9df565aa04f5', 'Développement de Jeux Mobiles avec Unity', 'Créez des jeux mobiles passionnants en utilisant le moteur Unity et C#.', 69.99, true, current_timestamp, current_timestamp, 4, 'https://images.unsplash.com/photo-1544725121-be3bf52e2dc8?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MjB8fGFwbGljYWNpb24lMjBtb3ZpbHxlbnwwfHwwfHx8MA%3D%3D'),
    ('c40edb92-17b3-4f3a-9758-9df565aa04f6', 'Mobile App Performance Optimization', 'Learn to optimize the performance and efficiency of your mobile apps for a seamless experience.', 59.99, true, current_timestamp, current_timestamp, 1, 'https://images.unsplash.com/photo-1523206489230-c012c64b2b48?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTF8fGFwbGljYWNpb24lMjBtb3ZpbHxlbnwwfHwwfHx8MA%3D%3D'),
    ('c40edb92-17b3-4f3a-9758-9df565aa04f7', 'Augmented Reality in Mobile Applications', 'Explore the integration of augmented reality in mobile applications for immersive experiences.', 64.99, true, current_timestamp, current_timestamp, 1, 'https://images.unsplash.com/photo-1590126141992-d6a613152c77?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8QXVnbWVudGVkJTIwUmVhbGl0eXxlbnwwfHwwfHx8MA%3D%3D'),
    ('c40edb92-17b3-4f3a-9758-9df565aa04f8', 'Sensor Integration in Mobile Applications', 'Discover how to use sensors in mobile devices to create interactive experiences.', 49.99, true, current_timestamp, current_timestamp, 1, 'https://images.unsplash.com/photo-1599950755346-a3e58f84ca63?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8U2Vuc29yJTIwSW50ZWdyYXRpb24lMjBtb2JpbGV8ZW58MHx8MHx8fDA%3D'),
    ('c40edb92-17b3-4f3a-9758-9df565aa04f9', 'Development of Native iOS Apps with Swift', 'Learn to create high-quality native apps for iOS devices using Swift.', 69.99, true, current_timestamp, current_timestamp, 1, 'https://images.unsplash.com/photo-1633250391894-397930e3f5f2?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MjZ8fGFwbGljYWNpb24lMjBtb3ZpbHxlbnwwfHwwfHx8MA%3D%3D'),
    -- Cursos de Lenguajes de Programación
    ('d40edb92-17b3-4f3a-9758-9df565aa04f0', 'Python: Más Allá de lo Básico', 'Explora las características avanzadas y técnicas poderosas de programación en Python.', 59.99, true, current_timestamp, current_timestamp, 2, 'https://images.unsplash.com/photo-1690683789978-3cf73960d650?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NXx8RGphbmdvfGVufDB8fDB8fHww'),
    ('d40edb92-17b3-4f3a-9758-9df565aa04f1', 'Rust: Programación Segura y Eficiente', 'Aprende a programar en Rust para desarrollar aplicaciones seguras y de alto rendimiento.', 64.99, true, current_timestamp, current_timestamp, 2, 'https://images.unsplash.com/photo-1656863678565-b7576b9363bb?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NHx8UnVzdCUyMGNvZGV8ZW58MHx8MHx8fDA%3D'),
    ('d40edb92-17b3-4f3a-9758-9df565aa04f2', 'Dominant JavaScript: Programació Funcional', 'Aprèn a aplicar conceptes de programació funcional en JavaScript per escriure codi més net i eficient.', 64.99, true, current_timestamp, current_timestamp, 3, 'https://images.unsplash.com/photo-1607970669494-309137683be5?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mjh8fEphdmFTY3JpcHR8ZW58MHx8MHx8fDA%3D'),
    ('d40edb92-17b3-4f3a-9758-9df565aa04f3', 'Java: Développement d´Applications d´Entreprise', 'Découvrez comment développer des applications d´entreprise robustes en utilisant le langage de programmation Java.', 64.99, true, current_timestamp, current_timestamp, 4, 'https://images.unsplash.com/photo-1519163219899-21d2bb723b3e?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTF8fEphdmF8ZW58MHx8MHx8fDA%3D'),
    ('d40edb92-17b3-4f3a-9758-9df565aa04f4', 'C#: Windows Forms Application Development', 'Learn to create Windows Forms desktop applications using the C# programming language.', 54.99, true, current_timestamp, current_timestamp, 1, 'https://images.unsplash.com/photo-1509966756634-9c23dd6e6815?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8N3x8YyUyMyUyMGNvZGV8ZW58MHx8MHx8fDA%3D'),
    ('d40edb92-17b3-4f3a-9758-9df565aa04f5', 'Ruby on Rails: Building Web Applications', 'Create dynamic and high-performance web applications using Ruby on Rails.', 59.99, true, current_timestamp, current_timestamp, 1, 'https://images.unsplash.com/photo-1518773553398-650c184e0bb3?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NHx8cnVieSUyMGNvZGV8ZW58MHx8MHx8fDA%3D'),
    ('d40edb92-17b3-4f3a-9758-9df565aa04f6', 'Go: Concurrent Application Development', 'Explore concurrent programming in Go to build scalable and efficient applications.', 64.99, true, current_timestamp, current_timestamp, 1, 'https://images.unsplash.com/photo-1542831371-29b0f74f9713?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTE0fHxNYXN0ZXIlMjBTd2lmdCUyMHByb2dyYW1taW5nfGVufDB8fDB8fHww'),
    ('d40edb92-17b3-4f3a-9758-9df565aa04f7', 'Android App Development with Java', 'Learn to develop Android apps using the Java programming language.', 54.99, true, current_timestamp, current_timestamp, 1, 'https://images.unsplash.com/photo-1607705703571-c5a8695f18f6?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTU0fHxqYXZhJTIwY29kZXxlbnwwfHwwfHx8MA%3D%3D'),
    ('d40edb92-17b3-4f3a-9758-9df565aa04f8', 'Swift: Programming for Apple Platforms', 'Master Swift programming to create stunning apps on Apple devices.', 59.99, true, current_timestamp, current_timestamp, 1, 'https://images.unsplash.com/photo-1529101091764-c3526daf38fe?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NDR8fE1hc3RlciUyMFN3aWZ0JTIwcHJvZ3JhbW1pbmd8ZW58MHx8MHx8fDA%3D'),
    ('d40edb92-17b3-4f3a-9758-9df565aa04f9', 'Web Application Development with Django', 'Create powerful and scalable web applications using the Python Django framework.', 69.99, true, current_timestamp, current_timestamp, 1, 'https://images.unsplash.com/photo-1580121441575-41bcb5c6b47c?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MXx8RGphbmdvfGVufDB8fDB8fHww'),
    -- Cursos de Desarrollo de Videojuegos
    ('e40edb92-17b3-4f3a-9758-9df565aa04f0', 'Introducción al Diseño de Videojuegos', 'Descubre los principios fundamentales del diseño de videojuegos y crea tus propios prototipos.', 54.99, true, current_timestamp, current_timestamp, 2, 'https://images.unsplash.com/photo-1486572788966-cfd3df1f5b42?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTl8fFVuaXR5JTIwZ2FtZXxlbnwwfHwwfHx8MA%3D%3D'),
    ('e40edb92-17b3-4f3a-9758-9df565aa04f1', 'Diseño de Personajes para Videojuegos', 'Domina las técnicas de diseño de personajes para dar vida a tus juegos.', 54.99, true, current_timestamp, current_timestamp, 2, 'https://images.unsplash.com/photo-1534423861386-85a16f5d13fd?w=600&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MzV8fFBlcnNvbmFqZXMlMjBqdWVnb3xlbnwwfHwwfHx8MA%3D%3D'),
    ('e40edb92-17b3-4f3a-9758-9df565aa04f2', 'Efectos Visuales Espectaculares en Videojuegos', 'Aprende a crear efectos visuales impresionantes para mejorar la experiencia de juego.', 59.99, true, current_timestamp, current_timestamp, 2, 'https://images.unsplash.com/photo-1648880004349-9bf1926b7556?w=600&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MzJ8fEVmZWN0b3MlMjBWaXN1YWxlc3xlbnwwfHwwfHx8MA%3D%3D'),
    ('e40edb92-17b3-4f3a-9758-9df565aa04f3', 'Narrativa Interactiva en Videojuegos', 'Explora técnicas de narrativa interactiva para crear experiencias inmersivas en tus juegos.', 54.99, true, current_timestamp, current_timestamp, 2, 'https://images.unsplash.com/photo-1635514569146-9a9607ecf303?w=600&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8TmFycmF0aXZhJTIwSW50ZXJhY3RpdmElMjBlbiUyMFZpZGVvanVlZ29zfGVufDB8fDB8fHww'),
    ('e40edb92-17b3-4f3a-9758-9df565aa04f4', 'Optimización de Rendimiento en Desarrollo de Videojuegos', 'Aprende a optimizar el rendimiento de tus juegos para proporcionar una experiencia de juego fluida.', 59.99, true, current_timestamp, current_timestamp, 2, 'https://images.unsplash.com/photo-1469032923574-4f1413034019?w=600&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NTF8fHVucmVhbCUyMGVuZ2luZSUyMGdhbWV8ZW58MHx8MHx8fDA%3D'),
    ('e40edb92-17b3-4f3a-9758-9df565aa04f5', 'Desarrollo de Juegos Educativos para Niños', 'Crea juegos educativos interactivos para niños y fomenta el aprendizaje a través del juego.', 54.99, true, current_timestamp, current_timestamp, 2, 'https://images.unsplash.com/photo-1642444616393-df04dcb1492c?w=600&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MjR8fEp1ZWdvcyUyMEVkdWNhdGl2b3N8ZW58MHx8MHx8fDA%3D'),
    ('e40edb92-17b3-4f3a-9758-9df565aa04f6', 'Unity 2D: Create Your First Platformer Game', 'Learn to develop an exciting 2D platformer game using Unity.', 59.99, true, current_timestamp, current_timestamp, 1, 'https://images.unsplash.com/photo-1615680022647-99c397cbcaea?w=600&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTl8fGZvcnRuaXRlfGVufDB8fDB8fHww'),
    ('e40edb92-17b3-4f3a-9758-9df565aa04f7', 'Artificial Intelligence in Games with Unity', 'Learn to implement AI to create intelligent enemies and non-playable characters in your games.', 64.99, true, current_timestamp, current_timestamp, 1, 'https://images.unsplash.com/photo-1697577418970-95d99b5a55cf?w=600&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NTB8fEFJfGVufDB8fDB8fHww'),
    ('e40edb92-17b3-4f3a-9758-9df565aa04f8', 'Developing Virtual Reality Games with Unreal Engine', 'Create immersive virtual reality experiences using the Unreal Engine.', 69.99, true, current_timestamp, current_timestamp, 1, 'https://images.unsplash.com/photo-1691405152460-82df81ce2955?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NXx8dW5yZWFsJTIwZW5naW5lfGVufDB8fDB8fHww'),
    ('e40edb92-17b3-4f3a-9758-9df565aa04f9', 'Cross-Platform Game Development with Phaser', 'Create fun and addictive games that work on different platforms using Phaser.', 64.99, true, current_timestamp, current_timestamp, 1, 'https://images.unsplash.com/photo-1550921464-9f7a27f99edc?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NHx8Y29uc29sZXN8ZW58MHx8MHx8fDA%3D');

-- Add categories to courses
INSERT INTO course_categories (category_id, course_id)
VALUES
    ('1', 'a40edb92-17b3-4f3a-9758-9df565aa04f0'),
    ('1', 'a40edb92-17b3-4f3a-9758-9df565aa04f1'),
    ('1', 'a40edb92-17b3-4f3a-9758-9df565aa04f2'),
    ('1', 'a40edb92-17b3-4f3a-9758-9df565aa04f3'),
    ('1', 'a40edb92-17b3-4f3a-9758-9df565aa04f4'),
    ('1', 'a40edb92-17b3-4f3a-9758-9df565aa04f5'),
    ('1', 'a40edb92-17b3-4f3a-9758-9df565aa04f6'),
    ('1', 'a40edb92-17b3-4f3a-9758-9df565aa04f7'),
    ('1', 'a40edb92-17b3-4f3a-9758-9df565aa04f8'),
    ('1', 'a40edb92-17b3-4f3a-9758-9df565aa04f9'),
    ('2', 'b40edb92-17b3-4f3a-9758-9df565aa04f0'),
    ('2', 'b40edb92-17b3-4f3a-9758-9df565aa04f1'),
    ('2', 'b40edb92-17b3-4f3a-9758-9df565aa04f2'),
    ('2', 'b40edb92-17b3-4f3a-9758-9df565aa04f3'),
    ('2', 'b40edb92-17b3-4f3a-9758-9df565aa04f4'),
    ('2', 'b40edb92-17b3-4f3a-9758-9df565aa04f5'),
    ('2', 'b40edb92-17b3-4f3a-9758-9df565aa04f6'),
    ('2', 'b40edb92-17b3-4f3a-9758-9df565aa04f7'),
    ('2', 'b40edb92-17b3-4f3a-9758-9df565aa04f8'),
    ('2', 'b40edb92-17b3-4f3a-9758-9df565aa04f9'),
    ('3', 'c40edb92-17b3-4f3a-9758-9df565aa04f0'),
    ('3', 'c40edb92-17b3-4f3a-9758-9df565aa04f1'),
    ('3', 'c40edb92-17b3-4f3a-9758-9df565aa04f2'),
    ('3', 'c40edb92-17b3-4f3a-9758-9df565aa04f3'),
    ('3', 'c40edb92-17b3-4f3a-9758-9df565aa04f4'),
    ('3', 'c40edb92-17b3-4f3a-9758-9df565aa04f5'),
    ('3', 'c40edb92-17b3-4f3a-9758-9df565aa04f6'),
    ('3', 'c40edb92-17b3-4f3a-9758-9df565aa04f7'),
    ('3', 'c40edb92-17b3-4f3a-9758-9df565aa04f8'),
    ('3', 'c40edb92-17b3-4f3a-9758-9df565aa04f9'),
    ('4', 'd40edb92-17b3-4f3a-9758-9df565aa04f0'),
    ('4', 'd40edb92-17b3-4f3a-9758-9df565aa04f1'),
    ('4', 'd40edb92-17b3-4f3a-9758-9df565aa04f2'),
    ('4', 'd40edb92-17b3-4f3a-9758-9df565aa04f3'),
    ('4', 'd40edb92-17b3-4f3a-9758-9df565aa04f4'),
    ('4', 'd40edb92-17b3-4f3a-9758-9df565aa04f5'),
    ('4', 'd40edb92-17b3-4f3a-9758-9df565aa04f6'),
    ('4', 'd40edb92-17b3-4f3a-9758-9df565aa04f7'),
    ('4', 'd40edb92-17b3-4f3a-9758-9df565aa04f8'),
    ('4', 'd40edb92-17b3-4f3a-9758-9df565aa04f9'),
    ('5', 'e40edb92-17b3-4f3a-9758-9df565aa04f0'),
    ('5', 'e40edb92-17b3-4f3a-9758-9df565aa04f1'),
    ('5', 'e40edb92-17b3-4f3a-9758-9df565aa04f2'),
    ('5', 'e40edb92-17b3-4f3a-9758-9df565aa04f3'),
    ('5', 'e40edb92-17b3-4f3a-9758-9df565aa04f4'),
    ('5', 'e40edb92-17b3-4f3a-9758-9df565aa04f5'),
    ('5', 'e40edb92-17b3-4f3a-9758-9df565aa04f6'),
    ('5', 'e40edb92-17b3-4f3a-9758-9df565aa04f7'),
    ('5', 'e40edb92-17b3-4f3a-9758-9df565aa04f8'),
    ('5', 'e40edb92-17b3-4f3a-9758-9df565aa04f9')
;

-- Add lessons to courses
INSERT INTO lessons (id, title, description, duration, video_url, course_id, created_at, updated_at)
VALUES
    -- Diseño Web Inspirador: Más Allá de las Tendencias
    ('ll0edb92-17b3-4f3a-9758-9df565aa0431', 'Introducción', 'Introducción al curso', 29, 'https://www.youtube.com/watch?v=9bZkp7q19f0', 'a40edb92-17b3-4f3a-9758-9df565aa04f0', current_timestamp, current_timestamp),
    ('ll0edb92-17b3-4f3a-9758-9df565aa0432', '¿Qué es el Diseño Web?', '¿Qué es el Diseño Web?', 35, 'https://www.youtube.com/watch?v=9bZkp7q19f0', 'a40edb92-17b3-4f3a-9758-9df565aa04f0', current_timestamp, current_timestamp),
    -- Optimización de Rendimiento en Desarrollo Web
    ('ll0edb92-17b3-4f3a-9758-9df565aa0433', 'Introducción', 'Introducción al curso', 15, 'https://www.youtube.com/watch?v=9bZkp7q19f0', 'a40edb92-17b3-4f3a-9758-9df565aa04f1', current_timestamp, current_timestamp),
    ('ll0edb92-17b3-4f3a-9758-9df565aa0434', '¿Qué es la Optimización de Rendimiento?', '¿Qué es la Optimización de Rendimiento?', 25, 'https://www.youtube.com/watch?v=9bZkp7q19f0', 'a40edb92-17b3-4f3a-9758-9df565aa04f1', current_timestamp, current_timestamp),
    -- Diseño de Personajes para Videojuegos
    ('ll0edb92-17b3-4f3a-9758-9df565aa0435', 'Introducción', 'Introducción al curso', 20, 'https://www.youtube.com/watch?v=9bZkp7q19f0', 'e40edb92-17b3-4f3a-9758-9df565aa04f1', current_timestamp, current_timestamp)
;

-- Roles
INSERT INTO roles(name) VALUES
    ('ROLE_GUEST'), -- 1
    ('ROLE_STUDENT'), -- 2
    ('ROLE_TEACHER'), -- 3
    ('ROLE_ADMIN'); -- 4

-- Privileges
INSERT INTO privileges(id, name)
VALUES
    (1, 'READ_COURSES'),
    (2, 'CREATE_COURSE'), -- Done
    (3, 'UPDATE_COURSE'), -- Done
    (4, 'CREATE_CATEGORY'), -- Done
    (5, 'DELETE_CATEGORY'), -- Done
    (6, 'CREATE_LANGUAGE'),
    (7, 'UPDATE_LANGUAGE'),
    (8, 'DELETE_LANGUAGE'),
    (9, 'CREATE_LESSON'), -- Done
    (10, 'CREATE_ORDER'), -- Done
    (11, 'READ_ORDER'), -- Done
    (12, 'COMPLETE_LESSON'), -- Done
    (13, 'READ_ENROLLMENT'), -- Done
    (14, 'CREATE_COURSE_REVIEW') -- Done
;


-- Role Privileges
INSERT INTO role_privileges(privilege_id, role_id)
VALUES -- role_guest(1), role_student(2), role_teacher(3), role_admin(4)
    -- Privileges for admin
    (1, 4), -- admin can read courses
    (2, 4), -- admin can create courses
    (3, 4), -- admin can update courses
    (4, 4), -- admin can create categories
    (5, 4), -- admin can delete categories
    (6, 4), -- admin can create languages
    (7, 4), -- admin can update languages
    (8, 4), -- admin can delete languages
    (9, 4), -- admin can create lessons
    (10, 4), -- admin can create orders
    (11, 4), -- admin can read orders
    (12, 4), -- admin can complete lessons
    (13, 4), -- admin can read enrollments
    (14, 4), -- admin can create course reviews
    -- Privileges for teacher
    (1, 3), -- teacher can read courses
    (2, 3), -- teacher can create courses
    (3, 3), -- teacher can update courses
    (4, 3), -- teacher can create categories
    (6, 3), -- teacher can create languages
    (9, 3), -- teacher can create lessons
    (10, 3), -- teacher can create orders
    (11, 3), -- teacher can read orders
    (12, 3), -- teacher can complete lessons
    (13, 3), -- teacher can read enrollments
    (14, 3), -- teacher can create course reviews
    -- Privileges for student
    (10, 2), -- student can create orders
    (11, 2), -- student can read orders
    (12, 2), -- student can complete lessons
    (13, 2), -- student can read enrollments
    (14, 2) -- student can create course reviews
;

-- Usuarios
INSERT INTO users (id, firstname, lastname, email, gender, username, active, created_at, updated_at, password_hash)
VALUES
    ('0a8df84e-7e91-4509-9c02-e6d8b29f93b6', 'Student', 'Test', 'student@tecnocampus.cat', 'OTHER', 'student', true, current_timestamp, current_timestamp, '$2a$10$fVKfcc47q6lrNbeXangjYeY000dmjdjkdBxEOilqhapuTO5ZH0co2'), -- password: password123
    ('0a8df84e-7e91-4509-9c02-e6d8b29f93b7', 'Teacher', 'Test', 'teacher@tecnocampus.cat', 'OTHER', 'teacher', true, current_timestamp, current_timestamp, '$2a$10$fVKfcc47q6lrNbeXangjYeY000dmjdjkdBxEOilqhapuTO5ZH0co2'), -- password: password123
    ('0a8df84e-7e91-4509-9c02-e6d8b29f93b9', 'Admin', 'Test', 'admin@tecnocampus.cat', 'OTHER', 'admin', true, current_timestamp, current_timestamp, '$2a$10$fVKfcc47q6lrNbeXangjYeY000dmjdjkdBxEOilqhapuTO5ZH0co2'), -- password: password123
    ('0a8df84e-7e91-4509-9c02-e6d8b29f93c8', 'Maria', 'Test', 'maria@tecnocampus.cat', 'OTHER', 'maria', true, current_timestamp, current_timestamp, '$2a$10$fVKfcc47q6lrNbeXangjYeY000dmjdjkdBxEOilqhapuTO5ZH0co2'), -- password: password123
    ('0a8df84e-7e91-4509-9c02-e6d8b29f93b5', 'Mia', 'Khalifa Gomez', 'mia.perez@outlook.com', 'FEMALE', 'miamia', true, current_timestamp, current_timestamp, '$2a$10$fVKfcc47q6lrNbeXangjYeY000dmjdjkdBxEOilqhapuTO5ZH0co2'),
    ('c40edb92-17b3-4f3a-9758-9df565aa04f1', 'John', 'Doe William', 'john.doe@gmail.com', 'MALE', 'johnny', true, current_timestamp, current_timestamp, '$2a$10$fVKfcc47q6lrNbeXangjYeY000dmjdjkdBxEOilqhapuTO5ZH0co2'),
    ('59e06854-3406-449f-8f0e-292d65756ed8', 'Jane', 'Smith Elizabeth', 'jane.smith@yahoo.com', 'OTHER', 'liz_smith', true, current_timestamp, current_timestamp, '$2a$10$fVKfcc47q6lrNbeXangjYeY000dmjdjkdBxEOilqhapuTO5ZH0co2'),
    ('efd61065-409b-4962-b619-09a324ad0f50', 'Michael', 'Johnson Robert', 'michael.johnson@hotmail.com', 'MALE', 'mike', true, current_timestamp, current_timestamp, '$2a$10$fVKfcc47q6lrNbeXangjYeY000dmjdjkdBxEOilqhapuTO5ZH0co2'),
    ('cdb63d03-18c2-41bd-baeb-0303b0c49571', 'Emily', 'Williams Grace', 'emily.williams@outlook.com', 'FEMALE', 'emmy', true, current_timestamp, current_timestamp, '$2a$10$fVKfcc47q6lrNbeXangjYeY000dmjdjkdBxEOilqhapuTO5ZH0co2'),
    ('cecfd4a6-53e9-4a2e-bcd3-7a8d40773498', 'William', 'Brown Thomas', 'william.brown@aol.com', 'MALE', 'billy', true, current_timestamp, current_timestamp, '$2a$10$fVKfcc47q6lrNbeXangjYeY000dmjdjkdBxEOilqhapuTO5ZH0co2'),
    ('3c4622cf-7626-4aa5-934e-6c17df6a52a0', 'Olivia', 'Jones Taylor', 'olivia.jones@icloud.com', 'FEMALE', 'livvy', true, current_timestamp, current_timestamp, '$2a$10$fVKfcc47q6lrNbeXangjYeY000dmjdjkdBxEOilqhapuTO5ZH0co2'),
    ('8e1f5141-2b12-4ea4-8fc5-0676d6da9a14', 'James', 'Garcia Charles', 'james.garcia@protonmail.com', 'MALE', 'jamie', true, current_timestamp, current_timestamp, '$2a$10$fVKfcc47q6lrNbeXangjYeY000dmjdjkdBxEOilqhapuTO5ZH0co2'),
    ('f1434b85-72c9-4ed0-86c1-6b680ae464f3', 'Ava', 'Miller Rose', 'ava.miller@yandex.com', 'OTHER', 'avam', true, current_timestamp, current_timestamp, '$2a$10$fVKfcc47q6lrNbeXangjYeY000dmjdjkdBxEOilqhapuTO5ZH0co2'),
    ('8f187f98-d32d-468d-8a27-79c65a4a6b15', 'David', 'Davis Lee', 'david.davis@msn.com', 'MALE', 'davidd', true, current_timestamp, current_timestamp, '$2a$10$fVKfcc47q6lrNbeXangjYeY000dmjdjkdBxEOilqhapuTO5ZH0co2'),
    ('aa4266d4-3696-4859-80d7-9e94d2df128c', 'Sophia', 'Rodriguez Martinez', 'sophia.rodriguez@gmail.com', 'FEMALE', 'sophiarod', true, current_timestamp, current_timestamp, '$2a$10$fVKfcc47q6lrNbeXangjYeY000dmjdjkdBxEOilqhapuTO5ZH0co2'),
    ('30a8c656-18f7-4536-8b9f-2ef3a03f587e', 'Ethan', 'Hernandez Martin', 'ethan.hernandez@yahoo.com', 'MALE', 'ethanh', true, current_timestamp, current_timestamp, '$2a$10$fVKfcc47q6lrNbeXangjYeY000dmjdjkdBxEOilqhapuTO5ZH0co2'),
    ('63c62e33-4d01-4b93-b8e7-d799e241ea6d', 'Isabella', 'Lopez Sanchez', 'isabella.lopez@hotmail.com', 'OTHER', 'isabellal', true, current_timestamp, current_timestamp, '$2a$10$fVKfcc47q6lrNbeXangjYeY000dmjdjkdBxEOilqhapuTO5ZH0co2'),
    ('f32a4a2b-c648-49a7-b108-280034b4d063', 'Alexander', 'Gonzalez Perez', 'alexander.gonzalez@gmail.com', 'MALE', 'alexperez', true, current_timestamp, current_timestamp, '$2a$10$fVKfcc47q6lrNbeXangjYeY000dmjdjkdBxEOilqhapuTO5ZH0co2'),
    ('0710d6ab-0720-4b66-8402-f27e0daec5bb', 'Daniel', 'Sanchez Romero', 'daniel.sanchez@aol.com', 'MALE', 'danrom', true, current_timestamp, current_timestamp, '$2a$10$fVKfcc47q6lrNbeXangjYeY000dmjdjkdBxEOilqhapuTO5ZH0co2');


INSERT INTO user_roles (USER_ID, ROLE_ID) VALUES ('0a8df84e-7e91-4509-9c02-e6d8b29f93b6', 2); -- student
INSERT INTO user_roles (USER_ID, ROLE_ID) VALUES ('0a8df84e-7e91-4509-9c02-e6d8b29f93b7', 3); -- teacher
INSERT INTO user_roles (USER_ID, ROLE_ID) VALUES ('0a8df84e-7e91-4509-9c02-e6d8b29f93b9', 4); -- admin
INSERT INTO user_roles (USER_ID, ROLE_ID) VALUES ('0a8df84e-7e91-4509-9c02-e6d8b29f93c8', 2); -- maria is a student
INSERT INTO user_roles (USER_ID, ROLE_ID) VALUES ('59e06854-3406-449f-8f0e-292d65756ed8', 2);

