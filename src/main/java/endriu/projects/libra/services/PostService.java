package endriu.projects.libra.services;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import endriu.projects.libra.util.EmailCfg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
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

	@Autowired
	@Qualifier("gmail")
	private JavaMailSender mailSender;
	
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
	
	public Post findPost(Integer postid) {
		return postRepository.getById(postid);
	}

	public void applyToPost(int postid, int userid) throws Exception{

		User user = userRepository.getById(userid);

		if (user.getResumepath().length() != 0){
			Post post = postRepository.getById(postid);

			MimeMessagePreparator preparator = mimeMessage -> {
				MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true);
				message.setTo(post.getCompanyEmail());
				message.setFrom("ubb.rpa.2019.d2@gmail.com");
				message.setSubject(String.format("Someone has applied to the %s internship of your company", post.getDomain()));
				message.setText(String.format("Internship application from %s %s for the %s internship", user.getName(), user.getSurname(), post.getDomain()));
				File resume = new File(user.getResumepath());
				message.addAttachment(resume.getName(), new FileSystemResource(resume));
			};
			mailSender.send(preparator);
		}
		else {
			throw new Exception("User has not uploaded a resume.");
		}
	}
	
}
