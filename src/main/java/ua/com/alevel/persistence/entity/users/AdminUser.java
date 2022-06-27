package ua.com.alevel.persistence.entity.users;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import ua.com.alevel.persistence.entity.posts.Post;
import ua.com.alevel.persistence.types.Role;

import javax.persistence.*;
import java.util.Set;

@Entity
@DiscriminatorValue("ADMIN")
public class AdminUser extends BaseUser {

    public AdminUser() {
        super();
        setRole(Role.USER);
    }

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<Post> posts;
}