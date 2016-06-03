package kr.casagalleria.util;

import javax.servlet.http.HttpSession;

import kr.casagalleria.DTO.casa_member;


public class SessionUtil {
	private HttpSession session;
	
	public SessionUtil(HttpSession session) {
		this.session = session;
	}
	
	public void logout() {
		session.invalidate();
	}
	
	public void setUser(casa_member usrData) {
		session.setAttribute("user", usrData);
	}
	
	public casa_member getUser() {
		return (casa_member) session.getAttribute("user");
	}
	
	public void setAttribute(String key, Object Value) {
		session.setAttribute(key, Value);
	}
	
	public Object getAttribute(String key) {
		return session.getAttribute(key);
	}
	
	public boolean isLogin() {
		return getUser()==null?false:true;
	}
	
}
