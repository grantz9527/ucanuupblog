package ucanuup.cc.blog.web.articles.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("article")
public class ArticleController {
	
	@GetMapping({"index"})
	public String index(){
		return "blog/article/index";
	}
}
