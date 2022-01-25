package ru.itis.javalab.restapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.javalab.restapi.repos.BlacklistRepository;

/**
 * @author Киямдинов Ильдар
 * @project rest-api
 * @created 24.01.2022
 */

@Service
public class JwtBlacklistServiceImpl implements JwtBlacklistService {

    @Autowired
    private BlacklistRepository blacklistRepository;

    @Override
    public void add(String token) {
        blacklistRepository.save(token);
    }

    @Override
    public boolean exists(String token) {
        return blacklistRepository.exists(token);
    }
}
