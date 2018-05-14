package com.peak.service;

import org.apache.ibatis.annotations.Param;

public interface BaseService <ID extends Object, Domain extends Object>{
	/**
	 * 根据ID查询
	 *
	 * @param id
	 * @param vp
	 * @return
	 */
	Domain get(@Param("id") ID id);
	
	/**
	 * 删除
	 *
	 * @param id
	 * @param vp
	 */
	int delete(@Param("id") ID id);
	
	/**
	 * 保存
	 *
	 * @param domain
	 */
	int create(Domain domain);
	
	/**
	 * 更新
	 *
	 * @param domain
	 */
	int update(Domain domain);
}
