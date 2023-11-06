package com.tecnocampus.erjose.persistence;

import com.tecnocampus.erjose.domain.Language;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageRepository extends JpaRepository<Language, Long> {
}
