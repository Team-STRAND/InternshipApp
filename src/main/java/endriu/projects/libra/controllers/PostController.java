package endriu.projects.libra.controllers;

import endriu.projects.libra.model.Requests.ApplyToPostRequest;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import endriu.projects.libra.model.Post;
import endriu.projects.libra.model.User;
import endriu.projects.libra.model.UserType;
import endriu.projects.libra.model.Responses.SimpleMessageResponse;
import endriu.projects.libra.services.PostService;
import endriu.projects.libra.util.Validator;

@RestController
@CrossOrigin(origins="*")
@RequestMapping(value = "/post")
public class PostController {
	
	@Autowired
	PostService postService;
	
	@PostMapping(value = "")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<?> createPost(@RequestBody Post post) throws Exception {
		
        Validator.validatePostDetails(post.getCompanyEmail());
        postService.addPost(post);
        
        return ResponseEntity.ok(new SimpleMessageResponse("Post added"));
    }
	
	@PostMapping(value = "/update/{postid}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<?> updatePost(@RequestBody Post post, @PathVariable int postid) throws Exception {
		
        postService.updatePost(post, postid);
        
        return ResponseEntity.ok(new SimpleMessageResponse("Post modified"));
    }
	
	@PostMapping(value = "/delete/{postid}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<?> deletePost(@PathVariable int postid) throws Exception {
		
        postService.deletePost(postid);
        
        return ResponseEntity.ok(new SimpleMessageResponse("Post deleted"));
    }
	
	@GetMapping(value = "/{userid}/{type}")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Post> findPosts(@PathVariable int userid, @PathVariable UserType type) throws Exception{
		
		User user = new User();
		user.setId(userid);
		user.setType(type);
		
		List<Post> posts = postService.findPosts(user);
		for(Post post : posts)
			post.setCreator(null);
		return posts;
		
	}
	
	@GetMapping(value = "/find/{postid}")
	@CrossOrigin(origins = "http://localhost:4200")
	public Post findPost(@PathVariable int postid) throws Exception{
		
		Post post = postService.findPost(postid);
		post.setCreator(null);
		return post;
		
	}

	@PostMapping(value = "/apply/{postid}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<?> applyToPost(@PathVariable int postid, @RequestBody ApplyToPostRequest applyToPostRequest) throws Exception {
        postService.applyToPost(postid, applyToPostRequest.getUserid());
	    return ResponseEntity.ok(new SimpleMessageResponse("You have successfully applied to the internship post."));
    }
}
