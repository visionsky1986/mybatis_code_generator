package com.shooter.tools;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.TopLevelClass;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class LombokPlugin extends PluginAdapter {

	@Override
	public boolean clientSelectAllMethodGenerated(Method method, TopLevelClass topLevelClass,
			IntrospectedTable introspectedTable) {
		return false;
	}

	public boolean validate(List<String> list) {
		return true;
	}

	@Override
	public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
		// topLevelClass.addImportedType("lombok.Getter");
		// topLevelClass.addImportedType("lombok.Setter");
		// topLevelClass.addImportedType("lombok.ToString");

		topLevelClass.addImportedType("lombok.Data");
		topLevelClass.addImportedType("lombok.EqualsAndHashCode");
		topLevelClass.addImportedType("org.apache.ibatis.type.Alias");

		topLevelClass.addAnnotation("@Alias(\"" + topLevelClass.getType().getShortName() + "\")");
		topLevelClass.addAnnotation("@Data");
		topLevelClass.addAnnotation("@EqualsAndHashCode(callSuper = true)");

		// topLevelClass.addAnnotation("@Getter");
		// topLevelClass.addAnnotation("@Setter");
		// topLevelClass.addAnnotation("@ToString");

		topLevelClass.addJavaDocLine("/**");
		topLevelClass.addJavaDocLine("* Created by Mybatis Generator " + date2Str(new Date()));
		topLevelClass.addJavaDocLine("*/");

		return true;
	}

	@Override
	public boolean clientGenerated(Interface interfaze, TopLevelClass topLevelClass,
			IntrospectedTable introspectedTable) {
		interfaze.addJavaDocLine("/**");
		interfaze.addJavaDocLine("* Created by Mybatis Generator " + date2Str(new Date()));
		interfaze.addJavaDocLine("*/");
		return true;
	}

	@Override
	public boolean modelSetterMethodGenerated(Method method, TopLevelClass topLevelClass,
			IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable, ModelClassType modelClassType) {
		return false;
	}

	@Override
	public boolean modelGetterMethodGenerated(Method method, TopLevelClass topLevelClass,
			IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable, ModelClassType modelClassType) {
		return false;
	}

	private String date2Str(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		return sdf.format(date);
	}
}