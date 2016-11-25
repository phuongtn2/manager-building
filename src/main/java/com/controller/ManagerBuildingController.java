package com.controller;

import com.building.dto.AuthorizedUserInfo;
import com.building.dto.BuildingDto;
import com.building.dto.FloorDto;
import com.building.services.ManagerBuildingService;
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
@RequestMapping("/building")
public class ManagerBuildingController {
	@Autowired
	private ManagerBuildingService managerBuildingService;
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

	@RequestMapping(method = RequestMethod.GET)
	public String initForm(ModelMap model){
		BuildingDto buildingDto = new BuildingDto();
		//command object
		model.addAttribute("buildingDto", buildingDto);
		//return form view
		return "building/view";
	}

	@ModelAttribute("buildingDtoList")
	public List<BuildingDto> populateBuildingList() throws ServerException {
		return managerBuildingService.findAll();
	}
	@RequestMapping(method = RequestMethod.POST)
	public String processSubmit(
			@ModelAttribute("buildingDto") BuildingDto buildingDto,
			BindingResult result, SessionStatus status) {

		//customerValidator.validate(customer, result);

		if (result.hasErrors()) {
			//if validator failed
			return "building/view";
		} else {
			status.setComplete();
			//form success
			return "building/view";
		}
	}

	@RequestMapping(method = RequestMethod.POST, params = "add")
	public String addBuilding(@ModelAttribute("buildingDto") BuildingDto buildingDto) throws ServerException {
		managerBuildingService.insertBuilding(buildingDto);
		return "redirect:/building";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String getEdit(@PathVariable long id, Model model, HttpServletRequest request)  throws ServerException{
		AuthorizedUserInfo aui = (AuthorizedUserInfo) request.getSession().getAttribute("aui");
		BuildingDto buildingDto = managerBuildingService.findById(id);
		buildingDto.setUpdateId(aui.getUserId());
		model.addAttribute("buildingDto",buildingDto);
		return "building/view";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public String saveEdit(@ModelAttribute("buildingDto") BuildingDto buildingDto, @PathVariable long id) throws ServerException {
		managerBuildingService.update(buildingDto);
		return "redirect:/building";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable long id, Model model, HttpServletRequest request)  throws ServerException{
		managerBuildingService.deleteById(id);
		return "redirect:/building";
	}

	@RequestMapping(value = "/addFloor/{id}", method = RequestMethod.GET)
	public String addFloor(@PathVariable long id, Model model, HttpServletRequest request)  throws ServerException{
		List<FloorDto> listFloor = managerBuildingService.findAllFloorByBuildingId(id);
		model.addAttribute("floorDtoList",listFloor);
		return "building/floor/view";
	}

	@RequestMapping(value = "/addFloor/{id}", method = RequestMethod.POST, params = "add")
	public String addFloor(@PathVariable long id, @ModelAttribute("floorDto") FloorDto floorDto, HttpServletRequest request) throws ServerException {
		AuthorizedUserInfo aui = (AuthorizedUserInfo) request.getSession().getAttribute("aui");
		floorDto.setCreateId(aui.getUserId());
		floorDto.setUpdateId(aui.getUserId());
		floorDto.setBuildingCode(id);
		managerBuildingService.insertFloor(floorDto);
		return "redirect:/building/floor/" + id;
	}
	/*@ModelAttribute("floorDtoList")
	public List<BuildingDto> populateFloorList() throws ServerException {
		return managerBuildingService.findAllFloorByBuildingId();
	}*/
}
