package com.controller;

import com.building.dto.AuthorizedUserInfo;
import com.building.dto.NewsDetailDto;
import com.building.dto.NewsDto;
import com.building.services.NewsService;
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

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/news")
public class NewsController {
	@Autowired
	private NewsService newsService;
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
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
		return "redirect:/news";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String getEdit(@PathVariable long id, Model model, HttpServletRequest request)  throws ServerException{
		AuthorizedUserInfo aui = (AuthorizedUserInfo) request.getSession().getAttribute("aui");
		NewsDto newsDto = newsService.findById(id);
		newsDto.setUpdateId(aui.getUserId());
		model.addAttribute("newsDto",newsDto);
		return "news/view";
	}
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public String saveEdit(@ModelAttribute("newsDto") NewsDto newsDto, @PathVariable long id) throws ServerException {
		newsService.update(newsDto);
		return "redirect:/news";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable long id, Model model, HttpServletRequest request)  throws ServerException{
		newsService.deleteById(id);
		return "redirect:/news";
	}

	// NewsDetail
	@RequestMapping(value = "/newsdetail/{id}", method = RequestMethod.GET)
	public String getListNewsDetail(@PathVariable long id, Model model, HttpServletRequest request)  throws ServerException{
		List<NewsDetailDto> listNewsDetail = newsService.findAllNewsDetailByNewsCode(id);
		model.addAttribute("newsDetailDto",listNewsDetail);
		return "news/newsDetail/view";
	}

	@RequestMapping(value = "/news/newsdetail/{id}", method = RequestMethod.POST, params = "add")
	public String addNewsDetail(@PathVariable long id, @ModelAttribute("newsDetailDto") NewsDetailDto newsDetailDto, HttpServletRequest request) throws ServerException {
		AuthorizedUserInfo aui = (AuthorizedUserInfo) request.getSession().getAttribute("aui");
		newsDetailDto.setCreateId(aui.getUserId());
		newsDetailDto.setUpdateId(aui.getUserId());
		newsDetailDto.setNewCode(id);
		newsService.insertNewsDetail(newsDetailDto);
		return "redirect:/news/newsdetail/" + id;
	}
	@RequestMapping(value = "/newsdetail/{newsId}/edit/{id}", method = RequestMethod.GET)
	public String getEditNewsDetail(@PathVariable long newsId, @PathVariable long id, Model model, HttpServletRequest request)  throws ServerException{
		AuthorizedUserInfo aui = (AuthorizedUserInfo) request.getSession().getAttribute("aui");
		NewsDetailDto newsDetailDto = newsService.findNewsDetailById(id);
		newsDetailDto.setUpdateId(aui.getUserId());
		model.addAttribute("newsDetailDto",newsDetailDto);
		List<NewsDetailDto> listNewsDetail = newsService.findAllNewsDetailByNewsCode(newsId);
		model.addAttribute("newsDetailDto",listNewsDetail);
		return "news/newsDetail/view";
	}

	@RequestMapping(value = "/newsdetail/{newsId}/edit/{id}", method = RequestMethod.POST)
	public String saveEditNewsDetail(@ModelAttribute("newsDetailDto") NewsDetailDto newsDetailDto, @PathVariable long newsId, @PathVariable long id) throws ServerException {
		newsService.updateNewsDetail(newsDetailDto);
		return "redirect:/news/newsdetail/"+ newsId;
	}

	@RequestMapping(value = "/newsdetail/{newsId}/delete/{id}", method = RequestMethod.GET)
	public String deleteNewsDetail(@PathVariable long newsId,@PathVariable long id, Model model, HttpServletRequest request)  throws ServerException{
		newsService.deleteNewsDetailById(id);
		return "redirect:/news/newsdetail/"+newsId;
	}
}
