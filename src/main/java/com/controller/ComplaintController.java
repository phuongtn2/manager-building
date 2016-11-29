package com.controller;

import com.building.dto.*;
import com.building.services.ComplaintService;
import com.building.services.Role;
import com.dropbox.core.ServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/complaint")
public class ComplaintController {
	@Autowired
	private ComplaintService complaintService;
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

	@RequestMapping(method = RequestMethod.GET)
	public String initForm(ModelMap model) throws ServerException {
		ComplaintDto complaintDto = new ComplaintDto();
		//command object
		model.addAttribute("complaintDto", complaintDto);
		//model.addAttribute("newsDtoList", newsService.findAll());
		//return form view
		return "complaint/view";
	}

	@ModelAttribute("tmComplaintList")
	public List<TMComplaintDto> populateTMComplaintList() throws ServerException {
		List<TMComplaintDto> tmComplaintList = new ArrayList<TMComplaintDto>();
		List<ComplaintDto> listComplaint = complaintService.findAllComplaint();
		List<Long> complaintCodeList = new ArrayList<Long>();
		if (listComplaint.size() > 0){
			for (ComplaintDto complaintDto : listComplaint) {
				complaintCodeList.add(complaintDto.getComplaintCode());
			}
			//Find TComplaint
			List<TransferComplaintDto> tComplaintList = complaintService.findAllTComplaint(complaintCodeList);
			List<Long> parentComplaintCodeList = new ArrayList<Long>();
			for (TransferComplaintDto transferComplaintDto : tComplaintList) {
				parentComplaintCodeList.add(transferComplaintDto.getParentComplaintCode());
			}
			List<TransferReplyDto> tReply = complaintService.findAllTReply(parentComplaintCodeList);
			for (ComplaintDto complaintDto : listComplaint) {
				TMComplaintDto tmComplaintDto = new TMComplaintDto();
				List<TransferComplaintDto> tComplaintListTemp = new ArrayList<TransferComplaintDto>();
				for (TransferComplaintDto transferComplaintDto: tComplaintList) {
					if(transferComplaintDto.getComplaintCode() == complaintDto.getComplaintCode()){
						List<TransferReplyDto> tReplyTemp = new ArrayList<TransferReplyDto>();
						for (TransferReplyDto transferReplyDto: tReply) {
							if(transferReplyDto.getParentComplaintCode() == transferComplaintDto.getParentComplaintCode()){
								tReplyTemp.add(transferReplyDto);
							}
						}
						transferComplaintDto.settReplyDtoList(tReplyTemp);
						tComplaintListTemp.add(transferComplaintDto);
					}
				}
				tmComplaintDto.setmComplaint(complaintDto);
				tmComplaintDto.settComplaintList(tComplaintListTemp);
				tmComplaintList.add(tmComplaintDto);
			}
		}
		return tmComplaintList;
	}
	@RequestMapping(method = RequestMethod.POST)
	public String processSubmit(
			@ModelAttribute("complaintDto") ComplaintDto complaintDto,
			BindingResult result, SessionStatus status) {
		//customerValidator.validate(customer, result);
		if (result.hasErrors()) {
			//if validator failed
			return "complaint/view";
		} else {
			status.setComplete();
			//form success
			return "complaint/view";
		}
	}
	@RequestMapping(method = RequestMethod.POST, params = "add")
	public String addComplaint(@ModelAttribute("complaintDto") ComplaintDto complaintDto, HttpServletRequest request) throws ServerException {
		AuthorizedUserInfo aui = (AuthorizedUserInfo) request.getSession().getAttribute("aui");
		complaintDto.setCreateId(aui.getUserId());
		complaintService.insertComplaint(complaintDto);
		return "redirect:/complaint";
	}

	@RequestMapping(method = RequestMethod.POST, params = "comment")
	public String addTComplaint(@ModelAttribute("complaintDto") ComplaintDto complaintDto) throws ServerException {
		complaintService.insertComplaint(complaintDto);
		return "redirect:/complaint";
	}

	@RequestMapping(method = RequestMethod.POST, params = "reply")
	public String addTReply(@ModelAttribute("complaintDto") ComplaintDto complaintDto) throws ServerException {
		complaintService.insertComplaint(complaintDto);
		return "redirect:/complaint";
	}

	@RequestMapping(method = RequestMethod.POST, params = "follow")
	public String follow(@ModelAttribute("complaintDto") ComplaintDto complaintDto) throws ServerException {
		if(complaintDto.getFollowStatus() == 0){
			complaintDto.setFollowStatus((byte) 1);
		}else{
			complaintDto.setFollowStatus((byte) 0);
		}
		complaintService.updateFollowStatus(complaintDto);
		return "redirect:/complaint";
		//return "complaint/view";
	}

	@RequestMapping(value = "/history", method = RequestMethod.GET)
	public String listComplaintHistory(Model model, HttpServletRequest request) throws ServerException {
		AuthorizedUserInfo aui = (AuthorizedUserInfo) request.getSession().getAttribute("aui");
		boolean per = aui.getRoleSet().contains(Role.ADMIN);
		List<ComplaintDto> listComplaintHistory = complaintService.findAllComplaintHistory(aui,per);
		/*if(aui.getRoleSet().contains(Role.ADMIN)){
			listComplaintHistory = complaintService.findAllComplaint();
		}else{
			listComplaintHistory = complaintService.findAllComplaintHistory(aui.getUserId());
		}*/

		model.addAttribute("listComplaintHistory", listComplaintHistory);
		return "complaint/view_history";
	}
}
