package com.rays.ctl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.ORSResponse;
import com.rays.dto.CourseDTO;
import com.rays.form.CourseForm;
import com.rays.service.CourseServiceInt;

@RestController
@RequestMapping(value = "Course")
public class CourseCtl extends BaseCtl<CourseForm, CourseDTO, CourseServiceInt> {

	@Autowired
	CourseServiceInt courseService;

	@GetMapping("/preload")
	public ORSResponse preload() {
		ORSResponse res = new ORSResponse(true);
		List<CourseDTO> list = courseService.search(new CourseDTO(), userContext);

		res.addresult("courseName", list);

		return res;
	}

}
