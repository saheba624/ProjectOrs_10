package com.rays.ctl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.ORSResponse;
import com.rays.dto.CollegeDTO;
import com.rays.form.CollegeForm;
import com.rays.service.CollegeServiceImpl;
import com.rays.service.CollegeServiceInt;
import com.rays.service.MarksheetServiceInt;

@RestController
@RequestMapping(value = "College")
public class CollegeCtl extends BaseCtl<CollegeForm, CollegeDTO, CollegeServiceInt> {

	@Autowired
	private CollegeServiceInt collegeService;

	@GetMapping("/preload")
	public ORSResponse preload() {
		ORSResponse res = new ORSResponse(true);
		List<CollegeDTO> list = collegeService.search(new CollegeDTO(), userContext);

		res.addresult("name", list);

		return res;
	}
}
