package ua.com.alevel.persistence.entity.users;

import ua.com.alevel.persistence.types.Role;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CUSTOMER")
public class CustomerUser extends BaseUser {

    public CustomerUser(){
        super();
        setRole(Role.USER);
    }
}
