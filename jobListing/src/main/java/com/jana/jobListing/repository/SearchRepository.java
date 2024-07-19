package com.jana.jobListing.repository;

import com.jana.jobListing.model.Post;

import java.util.List;

public interface SearchRepository {
  List<Post> findByText(String text);
}
