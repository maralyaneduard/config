/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.egs.blog.backend.services;

import com.egs.blog.backend.entities.Post;
import java.util.Date;
import java.util.List;

/**
 *
 * @author eduardm
 */
public interface PostService {

    public List<Post> getPostList(Integer start, Integer max);

    public Long savePost(Post post);

    public boolean deletePost(Long id);

    public boolean updatePost(Post post);

    public Post getPostById(Long id);

    public Post loadPost(Long id);

    public Post getPost(Long id);

    public List<Post> getPostsByUserId(Long userId);
    
    public List<Post> getPostsByTitle(String title);
    
    public List<Post> getPostsByDate(Date min, Date max);
}
