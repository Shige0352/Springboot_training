package com.example.demo.trySpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

// ポイント １：@ Controller

@Controller
public class HelloController {

	@Autowired
	private HelloService helloService;


	// ポイント ２：@ GetMapping
	@GetMapping("/hello")
	public String getHello() {

		// hello.htmlに画面遷移
		return "hello";

	}

	@PostMapping("/hello")
	public String postRequest(@RequestParam("text1")String str, Model model) {
		// ポイント ３： model. addAttribute
		// 画面 から 受け取っ た 文字列 を Model に 登録
		model.addAttribute("sample", str);
		// helloResponse. html に 画面 遷移
		return "helloResponse";
		}

	@PostMapping("/hello/db")
	public String postDbRequest(@RequestParam("text2")String str, Model model) {
		// String から int 型 に 変換
		int id = Integer.parseInt(str);
		// １ 件 検索
		Employee employee = helloService.findOne(id);
		// 検索 結果 を Model に 登録
		model.addAttribute("id", employee.getEmployeeId());
		model.addAttribute("name",employee.getEmployeeName());
		model.addAttribute("age", employee.getAge());
		// helloResponseDB. html に 画面 遷移
		return "helloResponseDB";



	}


	}
