
// BUSINESS SERVICE
public class LoginService {
	public boolean authenticate(String userId, String password) {
	// usually what happens this method will connect to a database where all ids and pass are stored, then it matches whether pass is correct for that userId or not
	// but here what we'll do for now , just to check whether pass is null or pass contains only blank spaces(no chars)..... authentication fails
	// otherwise authentication successful... just a dummy implementation
	
	if(password==null || password.trim()=="") {
		return false;
	}
	return true;
}
}
