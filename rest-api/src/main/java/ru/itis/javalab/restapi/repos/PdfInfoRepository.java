package ru.itis.javalab.restapi.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.javalab.restapi.entities.PdfInfo;

/**
 * @author Киямдинов Ильдар
 * @project rest-api
 * @created 24.01.2022
 */

public interface PdfInfoRepository extends JpaRepository<PdfInfo, Long> {

}
