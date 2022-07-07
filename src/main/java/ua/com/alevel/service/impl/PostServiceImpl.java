package ua.com.alevel.service.impl;

import org.apache.commons.collections4.MapUtils;
import org.springframework.stereotype.Service;
import ua.com.alevel.persistence.crud.CrudRepositoryHelper;
import ua.com.alevel.persistence.datatable.DataTableRequest;
import ua.com.alevel.persistence.datatable.DataTableResponse;
import ua.com.alevel.persistence.entity.post.Post;
import ua.com.alevel.persistence.repository.post.PostRepository;
import ua.com.alevel.service.PostService;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final CrudRepositoryHelper<Post, PostRepository> crudRepositoryHelper;

    public PostServiceImpl(PostRepository postRepository, CrudRepositoryHelper<Post, PostRepository> crudRepositoryHelper) {
        this.postRepository = postRepository;
        this.crudRepositoryHelper = crudRepositoryHelper;
    }


    @Override
    public void create(Post post) {
        crudRepositoryHelper.create(postRepository, post);
    }

    @Override
    public void update(Post post) {
        crudRepositoryHelper.update(postRepository, post);
    }

    @Override
    public void delete(Long id) {
        crudRepositoryHelper.delete(postRepository, id);
    }

    @Override
    public Optional<Post> findById(Long id) {
        return crudRepositoryHelper.findById(postRepository, id);
    }

    @Override
    public DataTableResponse<Post> findAll(DataTableRequest request) {
        DataTableResponse<Post> dataTableResponse = responseFill(request);

        dataTableResponse.getItems().stream().filter(Post::getVisible).collect(Collectors.toList());

        return dataTableResponse;
    }

    @Override
    public Long getLastIndex() {
        Long id;
        try {
            id = postRepository.findTopByOrderByIdDesc().getId();
            return id;
        } catch (NullPointerException e) {
            return 0L;
        }
    }

    @Override
    public List<Post> search(Map<String, String[]> queryMap) {
        String[] searchImage = queryMap.get("name");
        return postRepository.findByNamePostContaining(searchImage[0]);
    }

    @Override
    public DataTableResponse<Post> findAllForAdmin(DataTableRequest request) {
        DataTableResponse<Post> dataTableResponse = responseFill(request);
        return dataTableResponse;
    }

    private DataTableResponse<Post> responseFill(DataTableRequest request) {
        if (MapUtils.isNotEmpty(request.getRequestParamMap())) {
            return crudRepositoryHelper.findAll(postRepository, request, Post.class);
        } else {
            return crudRepositoryHelper.findAll(postRepository, request);
        }
    }
}
