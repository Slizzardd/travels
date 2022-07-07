package ua.com.alevel.persistence.entity.user;

import ua.com.alevel.persistence.types.Role;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("ADMIN")
public class AdminCustomer extends BaseUser {

    public AdminCustomer() {
        super();
        setRole(Role.ADMIN);
    }
}
