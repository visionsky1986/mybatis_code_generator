package com.shooter.tools;

import static org.mybatis.generator.internal.util.messages.Messages.getString;

import org.mybatis.generator.api.FullyQualifiedTable;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.codegen.mybatis3.xmlmapper.SimpleXMLMapperGenerator;
import org.mybatis.generator.codegen.mybatis3.xmlmapper.elements.AbstractXmlElementGenerator;
import org.mybatis.generator.codegen.mybatis3.xmlmapper.elements.DeleteByPrimaryKeyElementGenerator;
import org.mybatis.generator.codegen.mybatis3.xmlmapper.elements.InsertElementGenerator;

public class MySimpleXMLMapperGenerator extends SimpleXMLMapperGenerator {

	public MySimpleXMLMapperGenerator() {
		super();
	}

	@Override
	protected XmlElement getSqlMapElement() {
		FullyQualifiedTable table = introspectedTable.getFullyQualifiedTable();
		progressCallback.startTask(getString("Progress.12", table.toString())); //$NON-NLS-1$
		XmlElement answer = new XmlElement("mapper"); //$NON-NLS-1$
//		String namespace = introspectedTable.getMyBatis3SqlMapNamespace();
		answer.addAttribute(new Attribute("namespace", //$NON-NLS-1$
				table.getDomainObjectName()));

		context.getCommentGenerator().addRootComment(answer);

		addResultMapElement(answer);
		addDeleteByPrimaryKeyElement(answer);
		addInsertElement(answer);
		addUpdateByPrimaryKeyElement(answer);
		addSelectByPrimaryKeyElement(answer);
		addSelectAllElement(answer);

		return answer;
	}

	@Override
	protected void addSelectByPrimaryKeyElement(XmlElement parentElement) {
		if (introspectedTable.getRules().generateSelectByPrimaryKey()) {
			AbstractXmlElementGenerator elementGenerator = new MySimpleSelectByPrimaryKeyElementGenerator();
			initializeAndExecuteGenerator(elementGenerator, parentElement);
		}
	}

	@Override
	protected void addSelectAllElement(XmlElement parentElement) {
		AbstractXmlElementGenerator elementGenerator = new MySimpleSelectAllElementGenerator();
		initializeAndExecuteGenerator(elementGenerator, parentElement);
	}

	@Override
	protected void addDeleteByPrimaryKeyElement(XmlElement parentElement) {
		if (introspectedTable.getRules().generateDeleteByPrimaryKey()) {
			AbstractXmlElementGenerator elementGenerator = new DeleteByPrimaryKeyElementGenerator(true);
			initializeAndExecuteGenerator(elementGenerator, parentElement);
		}
	}

	@Override
	protected void addInsertElement(XmlElement parentElement) {
		if (introspectedTable.getRules().generateInsert()) {
			AbstractXmlElementGenerator elementGenerator = new InsertElementGenerator(true);
			initializeAndExecuteGenerator(elementGenerator, parentElement);
		}
	}

}
