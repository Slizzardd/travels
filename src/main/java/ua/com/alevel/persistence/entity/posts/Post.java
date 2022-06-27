package ua.com.alevel.persistence.entity.posts;

import ua.com.alevel.persistence.entity.BaseEntity;
import ua.com.alevel.persistence.entity.users.AdminUser;

import javax.persistence.*;

@Entity
@Table(name = "posts")
public class Post extends BaseEntity {


    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private AdminUser user;

    @Column(name = "path_small")
    private String pathToSmallImage;

    @Column(name = "path_big")
    private String pathToBigImage;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String Description;

    @Column(name = "price")
    private Double price;

    public Post(){
        this.pathToBigImage = "///";
        this.pathToSmallImage = "/";
    }

    public AdminUser getUser() {
        return user;
    }

    public void setUser(AdminUser user) {
        this.user = user;
    }

    public String getPathToSmallImage() {
        return pathToSmallImage;
    }

    public void setPathToSmallImage(String pathToSmallImage) {
        this.pathToSmallImage = pathToSmallImage;
    }

    public String getPathToBigImage() {
        return pathToBigImage;
    }

    public void setPathToBigImage(String pathToBigImage) {
        this.pathToBigImage = pathToBigImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
