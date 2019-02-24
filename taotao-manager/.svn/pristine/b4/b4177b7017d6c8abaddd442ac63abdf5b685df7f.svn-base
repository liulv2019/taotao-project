package com.taotao.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.EUIDataGridResult;
import com.taotao.common.util.TaotaoResult;
import com.taotao.pojo.TbContent;
import com.taotao.service.ContentService;

/**
 * 内容管理
 * @author Liulv
 *
 */
@Controller
@RequestMapping("/content")
public class ContentController {

	@Autowired
	private ContentService contentService;

	@RequestMapping("/query/list")
	@ResponseBody
	public EUIDataGridResult getContentList(@RequestParam(defaultValue="0") Integer page, @RequestParam(defaultValue="0") Integer rows, Long categoryId){
		
		EUIDataGridResult result = contentService.getContentList(page, rows, categoryId);
		return result;
	}
	
	
	@RequestMapping("/save")
	@ResponseBody
	public TaotaoResult insertContent(TbContent content){
		
		TaotaoResult result = contentService.insertContent(content);
		return result;
	}

}
