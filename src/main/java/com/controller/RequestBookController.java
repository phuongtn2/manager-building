package com.controller;

import com.building.dto.AuthorizedUserInfo;
import com.building.dto.BookServiceDto;
import com.building.services.RequestBookService;
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
@RequestMapping("/request_booking")
public class RequestBookController {
	@Autowired
	private RequestBookService requestBookService;
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

	@RequestMapping(method = RequestMethod.GET)
	public String initForm(ModelMap model) throws ServerException {
		BookServiceDto bookServiceDto = new BookServiceDto();
		//command object
		model.addAttribute("bookServiceDto", bookServiceDto);

		return "request_booking/view";
	}

	@ModelAttribute("bookServiceDtoList")
	public List<BookServiceDto> populateBookServiceList() throws ServerException {
		return requestBookService.findAllBook();
	}
	@RequestMapping(method = RequestMethod.POST)
	public String processSubmit(
			@ModelAttribute("bookServiceDto") BookServiceDto bookServiceDto,
			BindingResult result, SessionStatus status) {
		//customerValidator.validate(customer, result);
		if (result.hasErrors()) {
			//if validator failed
			return "request_booking/view";
		} else {
			status.setComplete();
			//form success
			return "request_booking/view";
		}
	}
	@RequestMapping(method = RequestMethod.POST, params = "add")
	public String addBook(@ModelAttribute("bookServiceDto") BookServiceDto bookServiceDto, HttpServletRequest request) throws ServerException {
		AuthorizedUserInfo aui = (AuthorizedUserInfo) request.getSession().getAttribute("aui");
		bookServiceDto.setUserId(aui.getUserId());
		bookServiceDto.setFollowStatus((byte) 0);
		requestBookService.insertBook(bookServiceDto);
		return "redirect:/request_booking";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String getEdit(@PathVariable long id, Model model, HttpServletRequest request)  throws ServerException{
		AuthorizedUserInfo aui = (AuthorizedUserInfo) request.getSession().getAttribute("aui");
		BookServiceDto bookServiceDto = requestBookService.findById(id);
		bookServiceDto.setUpdateId(aui.getUserId());
		model.addAttribute("bookServiceDto",bookServiceDto);
		return "request_booking/view";
	}
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public String saveEdit(@ModelAttribute("bookServiceDto") BookServiceDto bookServiceDto, @PathVariable long id) throws ServerException {
		requestBookService.updateBook(bookServiceDto);
		return "redirect:/request_booking";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable long id, Model model, HttpServletRequest request)  throws ServerException{
		requestBookService.deleteById(id);
		return "redirect:/request_booking";
	}

}
