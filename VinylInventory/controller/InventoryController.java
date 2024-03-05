package edu.cscc.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import edu.cscc.model.Record;
import edu.cscc.repository.InventoryRepository;

@Controller
public class InventoryController {
	@Autowired
	private InventoryRepository repository;
	
	@GetMapping("/records")
	public String getRecords(Model model) {
		List<Record> records = (List<Record>) repository.findAll();
		model.addAttribute("records", records);
		model.addAttribute("isRecords", records.isEmpty());
		return "records";
	}
	
	@GetMapping("/records/{id}")
	public String getRecord(@PathVariable long id, Model model) {
		var record = repository.findById(id).get();
		
		model.addAttribute("record", record);
		
		return "record";
		
	}
	@GetMapping("/add-record")
	public String getItemForm(Model model) {
		model.addAttribute("recordRequest", new Record());
		return "add-record";
	}
	@PostMapping("/records")
	public String postProduct(@Valid @ModelAttribute("recordRequest") Record record, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "add-record";
		}
		
		var createdRecord = repository.save(record);
		return "redirect:/records/" + createdRecord.id;
	}
}
