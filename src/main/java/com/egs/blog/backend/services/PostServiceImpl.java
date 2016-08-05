/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.egs.blog.backend.services;

import com.egs.blog.backend.dao.PostDAO;
import com.egs.blog.backend.entities.Post;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author eduardm
 */
@Service("postService")
@Component
@Transactional
public class PostServiceImpl implements PostService{

    @Autowired
    private PostDAO postDao;
    
    @Override
    public List<Post> getPostList(Integer start, Integer max) {
        return postDao.getPostList(start, max);
    }

    @Override
    public Long savePost(Post post) {
        return postDao.savePost(post);
    }

    @Override
    public boolean deletePost(Long id) {
        return postDao.deletePost(id);
    }

    @Override
    public boolean updatePost(Post post) {
        return postDao.updatePost(post);
    }

    @Override
    public Post getPostById(Long id) {
        return postDao.getPostById(id);
    }

    @Override
    public Post loadPost(Long id) {
        return postDao.loadPost(id);
    }

    @Override
    public Post getPost(Long id) {
        return postDao.getPost(id);
    }

    @Override
    public List<Post> getPostsByUserId(Long userId) {
        return postDao.getPostsByUserId(userId);
    }

    @Override
    public List<Post> getPostsByTitle(String title) {
        return postDao.getPostsByTitle(title);
    }

    @Override
    public List<Post> getPostsByDate(Date min, Date max) {
        return postDao.getPostsByDate(min, max);
    }
    
}
