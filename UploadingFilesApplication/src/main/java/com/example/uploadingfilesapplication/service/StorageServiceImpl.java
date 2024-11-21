package com.example.uploadingfilesapplication.service;

import com.example.uploadingfilesapplication.exception.StorageException;
import com.example.uploadingfilesapplication.exception.StorageFileNotFoundException;
import com.example.uploadingfilesapplication.model.StorageProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.stream.Stream;

@Service
public class StorageServiceImpl implements StorageService{
  private final Path rootLocation;

  @Autowired
  public StorageServiceImpl(StorageProperties properties){
    if(properties.getLocation().trim().length() == 0){
      throw  new StorageException("File upload location cannot be empty");
    }
    this.rootLocation = Paths.get(properties.getLocation());
  }

  @Override
  public void init() {
    try{
      Files.createDirectories(rootLocation);
    }catch (IOException e){
      throw new StorageException("Could not initialize storage: ", e);
    }
  }

  @Override
  public void store(MultipartFile file) {
    try{
      if(file.isEmpty()){
        throw new StorageException("Failed to store empty file");
      }
      Path destincationFile = this.rootLocation.resolve(Paths.get(file.getOriginalFilename()))
          .normalize().toAbsolutePath();
      if(!destincationFile.getParent().equals(this.rootLocation.toAbsolutePath())){ // For security
        throw new StorageException("Cannot store file outside of current directory");
      }
      try(InputStream inputStream = file.getInputStream()){ // Try with resources block. The inputStream is declared and can be used only inside the try block.
        //"Any object that implements java.lang.AutoCloseable, which includes all objects which implement java.io.Closeable, can be used as a resource."
        Files.copy(inputStream, destincationFile, StandardCopyOption.REPLACE_EXISTING);
      }
    }catch (IOException e){
      throw new StorageException("Failed to store file: ", e);
    }
  }

  @Override
  public Stream<Path> loadAll() {
    try{
      return Files.walk(this.rootLocation, 1)
          .filter(path -> !path.equals(this.rootLocation))
          .map(this.rootLocation::relativize);
    }catch (IOException e){
      throw new StorageException("Failed to read stored files: ", e);
    }
  }

  @Override
  public Path load(String fileName) {
    return rootLocation.resolve(fileName);
  }

  @Override
  public Resource loadAsResource(String fileName) {
    try{
      Path file = load(fileName);
      Resource resource = new UrlResource(file.toUri());
      if(resource.exists() || resource.isReadable()){
        return resource;
      }else {
        throw new StorageFileNotFoundException(
            "Could not read file: " + fileName);

      }
    }catch (MalformedURLException e){
      throw new StorageFileNotFoundException("Could not read file: ", e);
    }
  }

  @Override
  public void deleteAll() {
    FileSystemUtils.deleteRecursively(rootLocation.toFile());
  }
}
