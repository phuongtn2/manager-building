package com.controller;

import com.building.dto.AuthorizedUserInfo;
import com.building.dto.BuildingDto;
import com.building.dto.NewsDto;
import com.building.services.ManagerBuildingService;
import com.building.services.NewsService;
import com.building.services.error.ServiceException;
import com.dropbox.core.ServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/news.htm")
public class NewsController {
	@Autowired
	private NewsService newsService;
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

	@RequestMapping(method = RequestMethod.GET)
	public String initForm(ModelMap model) throws ServerException {
		NewsDto newsDto = new NewsDto();
		//command object
		model.addAttribute("newsDto", newsDto);
		//model.addAttribute("newsDtoList", newsService.findAll());
		//return form view
		return "news/view";
	}

	@ModelAttribute("newsDtoList")
	public List<NewsDto> populateNewsList() throws ServerException {
		return newsService.findAll();
	}
	/*@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView getListBuilding(HttpServletRequest request, HttpServletResponse response) throws ServerException {
		//check login
		AuthorizedUserInfo aui = (AuthorizedUserInfo) request.getSession().getAttribute("aui");
		if(aui == null){
			return new ModelAndView("login", "error", "");
		}
		List <NewsDto> newsDtoList = newsService.findAll();
		return new ModelAndView("news/view","newsDtoList", newsDtoList);
	}*/
	@RequestMapping(method = RequestMethod.POST)
	public String processSubmit(
			@ModelAttribute("newsDto") NewsDto newsDto,
			BindingResult result, SessionStatus status) {
		//customerValidator.validate(customer, result);
		if (result.hasErrors()) {
			//if validator failed
			return "news/view";
		} else {
			status.setComplete();
			//form success
			return "news/view";
		}
	}
	@RequestMapping(method = RequestMethod.POST, params = "add")
	public String addNews(@ModelAttribute("newsDto") NewsDto newsDto) throws ServerException {
		newsService.insertNews(newsDto);
		return "redirect:/news.htm";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String getEdit(@PathVariable Integer id, Model model) {
		return "news/view";
	}
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public String saveEdit(@ModelAttribute("newsDto") NewsDto newsDto,
						   @PathVariable Integer id, Model model) {
		return "news/view";
	}
	/*

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
	}*/

}
