package ua.oracleacademy.fp.web;

import java.util.Map;

import ua.oracleacademy.fp.domain.Task;
import ua.oracleacademy.fp.service.TaskService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TaskController {

	@Autowired
	private TaskService taskService;



	@RequestMapping("/index")
	public String listContacts(Map<String, Object> map) {

		map.put("task", new Task());
		map.put("taskList", taskService.taskList());

		return "task";
	}

	@RequestMapping("/")
	public String home() {
		return "redirect:/index";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addContact(@ModelAttribute("task") Task task,
			BindingResult result) {

		taskService.addTask(task);

		return "redirect:/index";
	}

	@RequestMapping("/delete/{taskId}")
	public String deleteContact(@PathVariable("taskId") Integer taskId) {

		taskService.removeTask(taskId);

		return "redirect:/index";
	}

	@RequestMapping(value = "/searchbydescription", method = RequestMethod.POST)
	public String searchResult(@ModelAttribute("searchbydescription") String description,
							   BindingResult result, Map<String, Object> map) {
		System.out.println("Request: " + description);
		map.put("searchResult", taskService.searchByDescription(description));

		return "searchResult";
	}

}
