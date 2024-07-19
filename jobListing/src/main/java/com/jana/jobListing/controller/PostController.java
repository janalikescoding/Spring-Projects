package com.jana.jobListing.controller;

import com.jana.jobListing.model.Post;
import com.jana.jobListing.repository.PostRepository;
import com.jana.jobListing.repository.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
public class PostController {

  @Autowired
  private PostRepository postRepository;

  @Autowired
  private SearchRepository searchRepository;

  @ApiIgnore
  @RequestMapping(value="/")
  public void redirect(HttpServletResponse response) throws IOException {
    response.sendRedirect("/swagger-ui.html");
  }

  @GetMapping("/posts")
  public List<Post> getAllPosts(){
    return postRepository.findAll();
  }

  @GetMapping("/posts/{text}")
  public List<Post> findByText(@PathVariable String text){
    return searchRepository.findByText(text);
  }

  @PostMapping("/post")
  public Post postJob(@RequestBody Post post){
    return postRepository.save(post);
  }
}
