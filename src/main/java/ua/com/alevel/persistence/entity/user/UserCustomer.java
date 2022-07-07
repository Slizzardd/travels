package ua.com.alevel.persistence.entity.user;

import ua.com.alevel.persistence.types.Role;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("REGULAR_USER")
public class UserCustomer extends BaseUser {

    public UserCustomer() {
        super();
        setRole(Role.USER);
    }
}
