package com.jana.jobListing.repository;

import com.jana.jobListing.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post,String> {
}
