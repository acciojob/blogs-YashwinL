package com.driver.services;

import com.driver.models.Blog;
import com.driver.models.Image;
import com.driver.models.User;
import com.driver.repositories.BlogRepository;
import com.driver.repositories.ImageRepository;
import com.driver.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BlogService {
    @Autowired
    BlogRepository blogRepository1;

    @Autowired
    UserRepository userRepository1;

    public Blog createAndReturnBlog(Integer userId, String title, String content)  {
        //create a blog at the current time
//        Instant currentInstant = Instant.now();
        Date currentDate = new Date();
        Blog blog = new Blog();
        User user = userRepository1.findById(userId).get();
        blog.setTitle(title);
        blog.setContent(content);
        blog.setUser(user);
        blog.setPubDate(currentDate);
        List<Blog> blogList = user.getBlogList();
        blogList.add(blog);
        user.setBlogList(blogList);
        userRepository1.save(user);

        return blog;
    }

    public void deleteBlog(int blogId){
        //delete blog and corresponding images
//        Blog blog = blogRepository1.findById(blogId).get();
//        User user = blog.getUser();
//        List<Blog> blogList = user.getBlogList();
//        for(Blog i : blogList){
//            if(i.getId()==blogId){
//                blogList.remove(i);
//                break;
//            }
//        }
//        user.setBlogList(blogList);
//        userRepository1.save(user);
        blogRepository1.deleteById(blogId);


    }
}
