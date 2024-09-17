package com.example.FiNTracker.Service;

import com.example.FiNTracker.Entity.AuthorizedUser;
import com.example.FiNTracker.Repo.AuthorizedUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorizedUserService {

    private final AuthorizedUserRepository authorizedUserRepository;

    public AuthorizedUserService(AuthorizedUserRepository authorizedUserRepository) {
        this.authorizedUserRepository = authorizedUserRepository;
    }

    public List<AuthorizedUser> findAll() {
        return authorizedUserRepository.findAll();
    }

    public List<AuthorizedUser> findAllByUserID(Long userID) {
        return authorizedUserRepository.findAllByUserID(userID);
    }

    public List<AuthorizedUser> findAllByAccountID(Long accountID) {
        return authorizedUserRepository.findAllByAccountID(accountID);
    }

    public AuthorizedUser findByUserIDAndAccountID(Long userID, Long accountID) {
        return authorizedUserRepository.findByUserIDAndAccountID(userID, accountID);
    }

}
