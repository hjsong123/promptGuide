package com.mysite.prom.details;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class DetailsController {
	
	private final DetailsService detailsService;

	@GetMapping("/Details/list")
	public String list(Model model, @RequestParam(value="category", required=false) Integer category) {
	    List<Details> detailsList;
	    if (category != null) {
	        detailsList = this.detailsService.getListByCategory(category);
	    } else {
	        detailsList = this.detailsService.getList(); // 카테고리 없으면 전체 출력
	    }
	    model.addAttribute("detailsList", detailsList);
	    return "details_list";
	}
    
    @GetMapping(value = "/details/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id) {
    	Details detail = this.detailsService.getDetail(id);
    	model.addAttribute("detail", detail);
        return "detail_view";
    }
}
