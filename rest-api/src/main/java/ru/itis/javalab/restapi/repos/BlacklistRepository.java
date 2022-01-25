package ru.itis.javalab.restapi.repos;

/**
 * @author Киямдинов Ильдар
 * @project rest-api
 * @created 24.01.2022
 */

public interface BlacklistRepository {

    void save(String token);

    boolean exists(String token);
}
