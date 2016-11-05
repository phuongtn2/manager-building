package com.controller;

import com.building.dto.AuthorizedUserInfo;
import com.building.dto.BuildingDto;
import com.building.services.ManagerBuildingService;
import com.building.services.error.ServiceException;
import com.dropbox.core.ServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class ManagerBuildingController {
	@Autowired
	private ManagerBuildingService managerBuildingService;
	@RequestMapping(value = "/building", method = RequestMethod.GET)
	public ModelAndView getListBuilding(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
		//check login
		AuthorizedUserInfo aui = (AuthorizedUserInfo) request.getSession().getAttribute("aui");
		if(aui == null){
			return new ModelAndView("login", "error", "");
		}
		return new ModelAndView("building/list", "error", "");
	}
	@RequestMapping(value = "/building/add", method = RequestMethod.POST)
	public ModelAndView addBuilding(HttpServletRequest request, HttpServletResponse response) throws  ServiceException
	{
		//check login
		AuthorizedUserInfo aui = (AuthorizedUserInfo) request.getSession().getAttribute("aui");
		if(aui == null){
			return new ModelAndView("login", "error", "");
		}
		String buildingName=request.getParameter("buildingName");
		String memo=request.getParameter("memo");
		BuildingDto buildingDto = new BuildingDto();
		buildingDto.setBuildingName(buildingName);
		buildingDto.setMemo(memo);
		buildingDto.setCreateId(aui.getUserId());
		buildingDto.setUpdateId(aui.getUserId());
		try {
			managerBuildingService.insertBuilding(buildingDto);
		} catch (ServerException e) {
			e.printStackTrace();
		}
		return null;
	}

}
