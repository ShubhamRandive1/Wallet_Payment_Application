package com.masai.ServiceLayer;

import com.masai.LoginSession.loginSession;

public interface UserSessionService {
	
	public loginSession getCurrentLoginSessionDetails(String customerDetail);

}
