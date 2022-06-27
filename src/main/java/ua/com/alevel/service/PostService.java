package ua.com.alevel.service;

import ua.com.alevel.persistence.datatable.DataTableRequest;
import ua.com.alevel.persistence.datatable.DataTableResponse;
import ua.com.alevel.persistence.entity.posts.Post;
import ua.com.alevel.persistence.entity.users.BaseUser;

import java.util.List;
import java.util.Map;

public interface PostService extends BaseService<Post> {

    Long getLastIndex();

    Post likes(BaseUser user, Long imageId);

    DataTableResponse<Post> findAllByUser(DataTableRequest request, BaseUser user);

    void deleteAllRelations(Long id);

    List<Post> search(Map<String, String[]> queryMap, BaseUser user);

    DataTableResponse<Post> findAllForAdmin(DataTableRequest request);
}
