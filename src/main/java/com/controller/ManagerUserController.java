package com.controller;

import com.building.dto.*;
import com.building.services.ManagerUserService;
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
@RequestMapping("/user")
public class ManagerUserController {
    @Autowired
    private ManagerUserService managerUserService;
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @RequestMapping(method = RequestMethod.GET)
    public String initForm(ModelMap model){
         UserRoleRoomDto userRoleRoomDto = new UserRoleRoomDto();
        //command object
        model.addAttribute("userRoleRoomDto", userRoleRoomDto);
        //return form view
        return "user/view";
    }

    @ModelAttribute("userDtoList")
        public List<UserDto> populateUserList() throws ServerException {
        return managerUserService.findAll();
    }
    @RequestMapping(method = RequestMethod.POST)
    public String processSubmit(
            @ModelAttribute("userRoleRoomDto") UserRoleRoomDto userRoleRoomDto,
            BindingResult result, SessionStatus status) {

        //customerValidator.validate(customer, result);

        if (result.hasErrors()) {
            //if validator failed
            return "user/view";
        } else {
            status.setComplete();
            //form success
            return "user/view";
        }
    }

    @RequestMapping(method = RequestMethod.POST, params = "add")
    public String addUser(@ModelAttribute("userRoleRoomDto") UserRoleRoomDto userRoleRoomDto, HttpServletRequest request) throws ServerException {
        AuthorizedUserInfo aui = (AuthorizedUserInfo) request.getSession().getAttribute("aui");
        //get user
        UserDto userDto = userRoleRoomDto.getUserDto();
        userDto.setCreateId(aui.getUserId());
        userDto.setUpdateId(aui.getUserId());
        userDto.setPassword("123456");
        managerUserService.insertUser(userDto);
        //get role
        UserRoleGroupDto userRoleGroupDto = userRoleRoomDto.getUserRoleGroupDto();
        userRoleGroupDto.setUserId(userDto.getUserId());
        userRoleGroupDto.setCreateId(aui.getUserId());
        userRoleGroupDto.setUpdateId(aui.getUserId());
        managerUserService.insertUserRoleGroup(userRoleGroupDto);
        //get user room
        UserRoomDto userRoomDto = userRoleRoomDto.getUserRoomDto();
        userRoomDto.setUserId(userDto.getUserId());
        managerUserService.insertUserRoom(userRoomDto);
        return "redirect:/user";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String getEdit(@PathVariable long id, Model model, HttpServletRequest request)  throws ServerException{
        AuthorizedUserInfo aui = (AuthorizedUserInfo) request.getSession().getAttribute("aui");
        UserDto userDto = managerUserService.findById(id);
        userDto.setUpdateId(aui.getUserId());
        model.addAttribute("userDto",userDto);
        return "user/view";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String saveEdit(@ModelAttribute("userDto") UserDto userDto, @PathVariable long id) throws ServerException {
        managerUserService.update(userDto);
        return "redirect:/user";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable long id, Model model, HttpServletRequest request)  throws ServerException{
        managerUserService.deleteById(id);
        return "redirect:/user";
    }
}