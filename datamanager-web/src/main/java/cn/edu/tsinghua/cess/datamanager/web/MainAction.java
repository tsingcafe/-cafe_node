package cn.edu.tsinghua.cess.datamanager.web;

import cn.edu.tsing.hua.cafe.service.ModelFileJust;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class MainAction {

	@Resource
	private ModelFileJust modelFileJust;

	@RequestMapping("index")
	public String main() {
		return "main/index";
	}

	@RequestMapping(value = "get/each/mfs")
	@ResponseBody
	public String deploy(@RequestParam("model") String mode, @RequestParam("value") String value) {
		System.out.println("-----------");
		modelFileJust.getModelFile(mode, value);

		return "redirect:";  // after deployment, redirect the browser to "/web/deployment" as to show the result
	}
}
