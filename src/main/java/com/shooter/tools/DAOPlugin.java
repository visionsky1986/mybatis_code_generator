package com.shooter.tools;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.TopLevelClass;

import java.util.List;

/**
 * 去掉DAO的接口
 * @author zhouyang
 *
 */
public class DAOPlugin extends PluginAdapter {

	@Override
	public boolean clientGenerated(Interface interfaze, TopLevelClass topLevelClass,
			IntrospectedTable introspectedTable) {
		return super.clientGenerated(interfaze, topLevelClass, introspectedTable);
	}

	@Override
	public boolean clientCountByExampleMethodGenerated(Method method, Interface interfaze,
			IntrospectedTable introspectedTable) {
		return false;
	}

	@Override
	public boolean clientCountByExampleMethodGenerated(Method method, TopLevelClass topLevelClass,
			IntrospectedTable introspectedTable) {
		return false;
	}

	@Override
	public boolean clientDeleteByExampleMethodGenerated(Method method, Interface interfaze,
			IntrospectedTable introspectedTable) {
		return false;
	}

	@Override
	public boolean clientDeleteByExampleMethodGenerated(Method method, TopLevelClass topLevelClass,
			IntrospectedTable introspectedTable) {
		return false;
	}

	@Override
	public boolean clientDeleteByPrimaryKeyMethodGenerated(Method method, Interface interfaze,
			IntrospectedTable introspectedTable) {
		return false;
	}

	@Override
	public boolean clientDeleteByPrimaryKeyMethodGenerated(Method method, TopLevelClass topLevelClass,
			IntrospectedTable introspectedTable) {
		return false;
	}

	@Override
	public boolean clientInsertMethodGenerated(Method method, Interface interfaze,
			IntrospectedTable introspectedTable) {
		return false;
	}

	@Override
	public boolean clientInsertMethodGenerated(Method method, TopLevelClass topLevelClass,
			IntrospectedTable introspectedTable) {
		return false;
	}

	@Override
	public boolean clientSelectByExampleWithBLOBsMethodGenerated(Method method, Interface interfaze,
			IntrospectedTable introspectedTable) {
		return false;
	}

	@Override
	public boolean clientSelectByExampleWithBLOBsMethodGenerated(Method method, TopLevelClass topLevelClass,
			IntrospectedTable introspectedTable) {
		return false;
	}

	@Override
	public boolean clientSelectByExampleWithoutBLOBsMethodGenerated(Method method, Interface interfaze,
			IntrospectedTable introspectedTable) {
		return false;
	}

	@Override
	public boolean clientSelectByExampleWithoutBLOBsMethodGenerated(Method method, TopLevelClass topLevelClass,
			IntrospectedTable introspectedTable) {
		return false;
	}

	@Override
	public boolean clientSelectByPrimaryKeyMethodGenerated(Method method, Interface interfaze,
			IntrospectedTable introspectedTable) {
		return false;
	}

	@Override
	public boolean clientSelectByPrimaryKeyMethodGenerated(Method method, TopLevelClass topLevelClass,
			IntrospectedTable introspectedTable) {
		return false;
	}

	@Override
	public boolean clientUpdateByExampleSelectiveMethodGenerated(Method method, Interface interfaze,
			IntrospectedTable introspectedTable) {
		return false;
	}

	@Override
	public boolean clientUpdateByExampleSelectiveMethodGenerated(Method method, TopLevelClass topLevelClass,
			IntrospectedTable introspectedTable) {
		return false;
	}

	@Override
	public boolean clientUpdateByExampleWithBLOBsMethodGenerated(Method method, Interface interfaze,
			IntrospectedTable introspectedTable) {
		return false;
	}

	@Override
	public boolean clientUpdateByExampleWithBLOBsMethodGenerated(Method method, TopLevelClass topLevelClass,
			IntrospectedTable introspectedTable) {
		return false;
	}

	@Override
	public boolean clientUpdateByExampleWithoutBLOBsMethodGenerated(Method method, Interface interfaze,
			IntrospectedTable introspectedTable) {
		return false;
	}

	@Override
	public boolean clientUpdateByExampleWithoutBLOBsMethodGenerated(Method method, TopLevelClass topLevelClass,
			IntrospectedTable introspectedTable) {
		return false;
	}

	@Override
	public boolean clientUpdateByPrimaryKeySelectiveMethodGenerated(Method method, Interface interfaze,
			IntrospectedTable introspectedTable) {
		return false;
	}

	@Override
	public boolean clientUpdateByPrimaryKeySelectiveMethodGenerated(Method method, TopLevelClass topLevelClass,
			IntrospectedTable introspectedTable) {
		return false;
	}

	@Override
	public boolean clientUpdateByPrimaryKeyWithBLOBsMethodGenerated(Method method, Interface interfaze,
			IntrospectedTable introspectedTable) {
		return false;
	}

	@Override
	public boolean clientUpdateByPrimaryKeyWithBLOBsMethodGenerated(Method method, TopLevelClass topLevelClass,
			IntrospectedTable introspectedTable) {
		return false;
	}

	@Override
	public boolean clientUpdateByPrimaryKeyWithoutBLOBsMethodGenerated(Method method, Interface interfaze,
			IntrospectedTable introspectedTable) {
		return false;
	}

	@Override
	public boolean clientUpdateByPrimaryKeyWithoutBLOBsMethodGenerated(Method method, TopLevelClass topLevelClass,
			IntrospectedTable introspectedTable) {
		return false;
	}

	@Override
	public boolean clientInsertSelectiveMethodGenerated(Method method, Interface interfaze,
			IntrospectedTable introspectedTable) {
		return false;
	}

	@Override
	public boolean clientInsertSelectiveMethodGenerated(Method method, TopLevelClass topLevelClass,
			IntrospectedTable introspectedTable) {
		return false;
	}

	@Override
	public boolean clientSelectAllMethodGenerated(Method method, Interface interfaze,
			IntrospectedTable introspectedTable) {
		return false;
	}

	@Override
	public boolean clientSelectAllMethodGenerated(Method method, TopLevelClass topLevelClass,
			IntrospectedTable introspectedTable) {
		return false;
	}

	@Override
	public boolean validate(List<String> warnings) {
		return true;
	}

}