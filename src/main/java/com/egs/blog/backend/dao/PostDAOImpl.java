/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.egs.blog.backend.dao;

import com.egs.blog.backend.entities.Post;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 *
 * @author eduardm
 */
@Component
@Repository("postDAO")
public class PostDAOImpl extends AbstractDAO implements PostDAO {

    @Override
    public List<Post> getPostList(Integer start, Integer max) {
        List<Post> finalList = null;
        try {
            Query query = getSession().createQuery("SELECT p FROM Post p WHERE p.id > 0 ORDER BY p.id DESC");
            if (start != null) {
                query.setFirstResult(start);
            }
            if (max != null) {
                query.setMaxResults(max);
            }
            finalList = query.list();

            if (finalList == null) {
                return null;
            }
            //   System.out.println("finalList " + finalList.size());

        } catch (Exception e) {
            e.printStackTrace();
        }

        return finalList;
    }

    @Override
    public Long savePost(Post post) {
        Long id = 0L;
        post.setPostedDate(new Date(System.currentTimeMillis()));
        getSession().save(post);
        getSession().flush();
        id = post.getId();
        return id;
    }

    @Override
    public boolean deletePost(Long id) {
        if (id != null) {
            Post post = this.getPostById(id);
            if (post != null) {
                getSession().delete(post);
            }
        } else {
            return false;
        }
        return true;
    }

    @Override
    public boolean updatePost(Post post) {
        if (post != null) {
            getSession().update(post);
        } else {
            return false;
        }
        return true;
    }

    @Override
    public Post getPostById(Long id) {
        Post entity = null;
        try {
            Query query = getSession().createQuery("SELECT p FROM Post p WHERE p.id=:id").setParameter("id", id);
            entity = (Post) query.uniqueResult();

            if (entity == null) {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return entity;
    }

    @Override
    public Post loadPost(Long id) {
        Post entity = null;
        try {
            entity = (Post) getSession().load(Post.class, id);//return proxy        
            if (entity == null) {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return entity;
    }

    @Override
    public Post getPost(Long id) {
        Post entity = null;
        try {
            entity = (Post) getSession().get(Post.class, id);//get Post from database
            if (entity == null) {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return entity;
    }

    @Override
    public List<Post> getPostsByUserId(Long userId) {
        List<Post> finalList = null;
        try {
            Query query = getSession().createQuery("SELECT p FROM Post p WHERE p.user.id = :id").setParameter("id", userId);
            finalList = query.list();
            if (finalList == null) {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return finalList;
    }

    @Override
    public List<Post> getPostsByTitle(String title) {
        List<Post> finalList = null;
        try {
            Query query = getSession().createQuery("SELECT p FROM Post p where p.title LIKE :title").setParameter("title", "%" + title + "%");
            finalList = query.list();
            if (finalList == null) {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return finalList;
    }

    @Override
    public List<Post> getPostsByDate(Date min, Date max) {
        List<Post> finalList = null;
        try {
            Query query = getSession().createQuery("SELECT p FROM Post p where p.postedDate > :min and p.postedDate < :max").setParameter("minDate", min).setParameter("maxDate", max);
            finalList = query.list();
            if (finalList == null) {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return finalList;
    }

}
