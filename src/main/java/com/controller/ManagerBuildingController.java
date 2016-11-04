package com.controller;

import com.building.services.error.ServiceException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class ManagerBuildingController {
	@RequestMapping(value = "/building", method = RequestMethod.GET)
	public ModelAndView getListBuilding(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
		return new ModelAndView("building/list", "error", "");
	}
}
