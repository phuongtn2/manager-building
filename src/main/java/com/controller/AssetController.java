package com.controller;

import com.building.dto.AssetDto;
import com.building.dto.AuthorizedUserInfo;
import com.building.services.AssetService;
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
@RequestMapping("/asset")
public class AssetController {
	@Autowired
	private AssetService assetService;
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

	@RequestMapping(method = RequestMethod.GET)
	public String initForm(ModelMap model) throws ServerException {
		AssetDto assetDto = new AssetDto();
		//command object
		model.addAttribute("assetDto", assetDto);
		//model.addAttribute("newsDtoList", newsService.findAll());
		//return form view
		return "asset/view";
	}

	@ModelAttribute("assetDtoList")
	public List<AssetDto> populateNewsList() throws ServerException {
		return assetService.findAll();
	}
	@RequestMapping(method = RequestMethod.POST)
	public String processSubmit(
			@ModelAttribute("assetDto") AssetDto assetDto,
			BindingResult result, SessionStatus status) {
		//customerValidator.validate(customer, result);
		if (result.hasErrors()) {
			//if validator failed
			return "asset/view";
		} else {
			status.setComplete();
			//form success
			return "asset/view";
		}
	}
	@RequestMapping(method = RequestMethod.POST, params = "add")
	public String addAsset(@ModelAttribute("assetDto") AssetDto assetDto) throws ServerException {
		assetService.insertAsset(assetDto);
		return "redirect:/asset";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String getEdit(@PathVariable long id, Model model, HttpServletRequest request)  throws ServerException{
		AuthorizedUserInfo aui = (AuthorizedUserInfo) request.getSession().getAttribute("aui");
		AssetDto assetDto = assetService.findById(id);
		assetDto.setUpdateId(aui.getUserId());
		model.addAttribute("assetDto",assetDto);
		return "asset/view";
	}
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public String saveEdit(@ModelAttribute("assetDto") AssetDto assetDto, @PathVariable long id) throws ServerException {
		assetService.update(assetDto);
		return "redirect:/asset";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable long id, Model model, HttpServletRequest request)  throws ServerException{
		assetService.deleteById(id);
		return "redirect:/asset";
	}
}
