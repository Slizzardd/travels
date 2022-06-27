package ua.com.alevel.service;

import ua.com.alevel.persistence.entity.users.BaseUser;

public interface UserService extends BaseService<BaseUser> {

    BaseUser findByEmail(String email);

    void deleteAllRelations(Long id);
}
