package com.controller;


import com.building.dto.AuthorizedUserInfo;
import com.building.dto.NewsDetailDto;
import com.building.services.NewsDetailService;
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
 * Created by Giang.DaoTu on 11/20/2016.
 */
@Controller
@RequestMapping("/newsdetail")
public class NewsDetailController{
    @Autowired
    private NewsDetailService newsDetailService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @RequestMapping(method = RequestMethod.GET)
    public String initForm(ModelMap model) throws ServerException {
        NewsDetailDto newsDetailDto = new NewsDetailDto();
        //command object
        model.addAttribute("newsDetailDto", newsDetailDto);
        //model.addAttribute("newsDtoList", newsService.findAll());
        //return form view
        return "newsDetail/view";
    }

    @ModelAttribute("newsDetailDtoList")
    public List<NewsDetailDto> populateNewsDetailList() throws ServerException {
        return newsDetailService.findAll();
    }
    @RequestMapping(method = RequestMethod.POST)
    public String processSubmit(
            @ModelAttribute("newsDetailDto") NewsDetailDto newsDetailDto,
            BindingResult result, SessionStatus status) {
        //customerValidator.validate(customer, result);
        if (result.hasErrors()) {
            //if validator failed
            return "newsDetail/view";
        } else {
            status.setComplete();
            //form success
            return "newsDetail/view";
        }
    }
    @RequestMapping(method = RequestMethod.POST, params = "add")
    public String addNews(@ModelAttribute("newsDetailDto") NewsDetailDto newsDetailDto) throws ServerException {
        newsDetailService.insertNewsDetail(newsDetailDto);
        return "redirect:/newsdetail";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String getEdit(@PathVariable long id, Model model, HttpServletRequest request)  throws ServerException{
        AuthorizedUserInfo aui = (AuthorizedUserInfo) request.getSession().getAttribute("aui");
        NewsDetailDto newsDetailDto = newsDetailService.findById(id);
//        newsDetailDto.setUpdateId(aui.getUserId());
        model.addAttribute("newsDetailDto",newsDetailDto);
        return "newsDetail/view";
    }
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String saveEdit(@ModelAttribute("newsDetailDto") NewsDetailDto newsDetailDto, @PathVariable long id) throws ServerException {
        newsDetailService.update(newsDetailDto);
        return "redirect:/newsdetail";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable long id, Model model, HttpServletRequest request)  throws ServerException{
        newsDetailService.deleteById(id);
        return "redirect:/newsdetail";
    }
}
