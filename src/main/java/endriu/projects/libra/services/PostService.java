package endriu.projects.libra.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import endriu.projects.libra.dao.PostRepository;
import endriu.projects.libra.dao.UserRepository;
import endriu.projects.libra.model.Comment;
import endriu.projects.libra.model.Post;
import endriu.projects.libra.model.User;
import endriu.projects.libra.model.UserType;

@Service
public class PostService {

	@Autowired
	PostRepository postRepository;
	
	@Autowired
	UserRepository userRepository;
	
	public void addPost(Post post) {
		
		post.setNumberOfApplicants(0);
		post.setComments(new ArrayList<Comment>());
		postRepository.save(post);
	}
	
	public void updatePost(Post post, Integer id) {
		
		Post currentPost = postRepository.getById(id);
		currentPost.setDomain(post.getDomain());
		currentPost.setDuration(post.getDuration());
		currentPost.setInformation(post.getInformation());
		currentPost.setPaid(post.getPaid());
		currentPost.setRequirements(post.getRequirements());
		postRepository.save(currentPost);
	}
	
	public void deletePost(Integer id) {
		
		postRepository.deleteById(id);
	}
	
	public List<Post> findPosts(User user){
		
		if(user.getType().equals(UserType.COMPANY)) {
			User currentUser = userRepository.getById(user.getId());
			return currentUser.getPostsCreated();
		}
		else {
			return postRepository.findAll();
		}
		
	}
	
}
