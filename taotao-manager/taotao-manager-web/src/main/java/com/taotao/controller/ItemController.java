package com.taotao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.EUIDataGridResult;
import com.taotao.common.util.TaotaoResult;
import com.taotao.pojo.TbItem;
import com.taotao.service.ItemService;

/**
 * 商品管理
 * @author Liulv
 *
 */
@Controller
@RequestMapping(value="/item")
public class ItemController {

	@Autowired
	ItemService itemService;
	
	@RequestMapping("/{itemId}")
	@ResponseBody
	public TbItem geTbItemById(@PathVariable Long itemId){
		
		TbItem tbItem = itemService.getItemById(itemId);
		return tbItem;
	}
	
	@RequestMapping(value="/list")
	@ResponseBody
	public EUIDataGridResult getItemlist(@RequestParam(defaultValue="0")Integer page, @RequestParam(defaultValue="0")Integer rows) throws Exception {
		
		//查询商品列表
		EUIDataGridResult result = itemService.getItemList(page, rows);
		return result;
	} 
	
	/**
	 * 添加商品
	 * @param tbItem
	 * @param desc
	 * @param itemParam
	 * @return
	 */
	@RequestMapping(value="/save",method=RequestMethod.POST)
	@ResponseBody
	public TaotaoResult createItem(TbItem tbItem, String desc, String itemParams){
		
		try {
			TaotaoResult result = itemService.createItem(tbItem,desc,itemParams);
			return result;
			
		} catch (Exception e) {
			
			return null;
		}
	}
	
}
