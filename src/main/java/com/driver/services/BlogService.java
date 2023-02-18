package com.driver.services;

import com.driver.models.Blog;
import com.driver.models.Image;
import com.driver.models.User;
import com.driver.repositories.BlogRepository;
import com.driver.repositories.ImageRepository;
import com.driver.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BlogService {
    @Autowired
    BlogRepository blogRepository1;

    @Autowired
    UserRepository userRepository1;

    public Blog createAndReturnBlog(Integer userId, String title, String content) throws Exception {
        //create a blog at the current time
        Blog blog = new Blog();
        User user = userRepository1.findById(userId).get();
        if(!userRepository1.existsById(userId)){
            throw new Exception("user not exist");
        }
        blog.setTitle(title);
        blog.setContent(content);
        blog.setUser(user);
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
