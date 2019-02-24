package com.taotao.rest.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.mapper.TbItemCatMapper;
import com.taotao.pojo.TbItemCat;
import com.taotao.pojo.TbItemCatExample;
import com.taotao.pojo.TbItemCatExample.Criteria;
import com.taotao.rest.pojo.CatNode;
import com.taotao.rest.pojo.CatResult;
import com.taotao.rest.service.ItemCatService;

/**
 * 商品分类服务
 * @author Liulv
 *
 */
@Service
public class ItemCatServiceImpl implements ItemCatService {

	@Autowired
	private TbItemCatMapper itemCatMapper;
	
	@Override
	public CatResult getItemCatList() {

		CatResult catResult = new CatResult();
		catResult.setData(getCatList(0));
		return catResult;
	}
	
	/**
	 * 查询分类列表
	 * @param parentId
	 * @return
	 */
	private List<?> getCatList(long parentId){
		
		//创建查询条件
		TbItemCatExample example = new TbItemCatExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		//执行查询
		List<TbItemCat> list = itemCatMapper.selectByExample(example);
		//返回list
		List<Object> resultList = new ArrayList<>();
		//向list中添加节点
		int count = 0;
		for(TbItemCat tbItemCat : list){
			//判断是否为父节点
			if(tbItemCat.getIsParent()){
				CatNode catNode = new CatNode();
				if(parentId == 0){
					catNode.setName("<a href='/products/" + tbItemCat.getName() + ".html'>" + tbItemCat.getName() + "</a>");
				}else{
					catNode.setName(tbItemCat.getName());
				}
				catNode.setUrl("/products/" + tbItemCat.getId() + ".html");
				//递归查询下一级列表
				catNode.setItem(getCatList(tbItemCat.getId()));
				resultList.add(catNode);
				count++;
				if(parentId == 0 && count >= 14){
					break;
				}
			} else {
				resultList.add("/products/" + tbItemCat.getId() + ".html|" + tbItemCat.getName());
			}
		}
		return resultList;
	}

}
