package com.controller;

import com.building.dto.AuthorizedUserInfo;
import com.building.dto.MemberDto;
import com.building.services.ManagerMemberService;
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

/**
 * Created by Giang.DaoTu on 11/11/2016.
 */

@Controller
@RequestMapping("/member")
public class ManagerMemberController {
    @Autowired
    private ManagerMemberService managerMemberService;
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @RequestMapping(method = RequestMethod.GET)
    public String initForm(ModelMap model){
         MemberDto memberDto = new MemberDto();
        //command object
        model.addAttribute("memberDto", memberDto);
        //return form view
        return "member/view";
    }

    @ModelAttribute("memberDtoList")
        public List<MemberDto> populateMemberList() throws ServerException {
        return managerMemberService.findAll();
    }
    @RequestMapping(method = RequestMethod.POST)
    public String processSubmit(
            @ModelAttribute("memberDtoList") MemberDto memberDto,
            BindingResult result, SessionStatus status) {

        //customerValidator.validate(customer, result);

        if (result.hasErrors()) {
            //if validator failed
            return "member/view";
        } else {
            status.setComplete();
            //form success
            return "member/view";
        }
    }

    @RequestMapping(method = RequestMethod.POST, params = "add")
    public String addMember(@ModelAttribute("memberDto") MemberDto memberDto) throws ServerException {
        managerMemberService.insertMember(memberDto);
        return "redirect:/member";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String getEdit(@PathVariable long id, Model model, HttpServletRequest request)  throws ServerException{
        AuthorizedUserInfo aui = (AuthorizedUserInfo) request.getSession().getAttribute("aui");
        MemberDto memberDto = managerMemberService.findById(id);
        memberDto.setUpdateId(aui.getUserId());
        model.addAttribute("memberDto",memberDto);
        return "member/view";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String saveEdit(@ModelAttribute("memberDto") MemberDto memberDto, @PathVariable long id) throws ServerException {
        managerMemberService.update(memberDto);
        return "redirect:/member";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable long id, Model model, HttpServletRequest request)  throws ServerException{
        managerMemberService.deleteById(id);
        return "redirect:/member";
    }
}