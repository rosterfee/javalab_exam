package ru.itis.javalab.restapi.services;

/**
 * @author Киямдинов Ильдар
 * @project rest-api
 * @created 24.01.2022
 */

public interface JwtBlacklistService {

    void add(String token);

    boolean exists(String token);

}
