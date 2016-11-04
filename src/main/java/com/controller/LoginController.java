package com.controller;

import com.building.dto.AuthorizedUserInfo;
import com.building.services.AuthorizedUserTokenService;
import com.building.services.error.ServiceException;
import com.building.util.str.StringUtil;
import com.controller.bean.LoginBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import sun.net.www.protocol.http.AuthenticationInfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {
	@Autowired
	private AuthorizedUserTokenService authorizedUserTokenService;

	@RequestMapping("/login") public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
		String userName=request.getParameter("userName");
		String password=request.getParameter("password");
		String message;
		if(!StringUtil.isEmpty(userName) && !StringUtil.isEmpty(password)){
			AuthorizedUserInfo authenticationInfo = authorizedUserTokenService.doLogin(userName, password);
			if(authenticationInfo != null){
				return new ModelAndView("home", "aui", authenticationInfo);
			}else{
				message = "Chưa có tài khoản.";
				return new ModelAndView("login", "error", message);
			}
		}else{
			message = "Sai tên đăng nhập/mật khẩu.";
			return new ModelAndView("login", "error", message);
		}
	}
}
