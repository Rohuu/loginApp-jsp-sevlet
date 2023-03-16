import java.util.HashMap;
import java.util.Map;

// BUSINESS SERVICE
// here different methods are different business services
public class LoginService {
	
	Map<String,String> users=new HashMap<String, String>();
	

	
	
	// keeping some data, like dummy database
	public LoginService(){
		 users.put("johndoe", "John Doe");
		 users.put("janedoe", "Jane Doe");
		 users.put("javaguru", "Java Guru");
	}
	
	// a business service
	// returned thing is a modal(M of MVC)
	public boolean authenticate(String userId, String password) {
	// usually what happens this method will connect to a database where all ids and pass are stored, then it matches whether pass is correct for that userId or not
	// but here what we'll do for now , just to check whether pass is null or pass contains only blank spaces(no chars)..... authentication fails
	// otherwise authentication successful... just a dummy implementation
	
	if(password==null || password.trim()=="") {
		return false;
	}
	return true;
}
	
	// takes userId as input and returns User object containing whole info about user
	// again getUserDetails is a business request, we are getting User object from here which is modal(M of MVC) 
	public User getUserDetails(String userId) {
		User user=new User();
		user.setUserName(users.get(userId));
		user.setUserId(userId);
		return user;
	}
}
