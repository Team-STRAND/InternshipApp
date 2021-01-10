package endriu.projects.libra.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import endriu.projects.libra.model.Post;

public interface PostRepository extends JpaRepository<Post, Integer>{
	
	Post getById(int id);

}
