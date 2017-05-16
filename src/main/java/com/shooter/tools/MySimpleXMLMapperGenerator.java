package com.shooter.tools;

import static org.mybatis.generator.internal.util.messages.Messages.getString;

import org.mybatis.generator.api.FullyQualifiedTable;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.codegen.mybatis3.xmlmapper.SimpleXMLMapperGenerator;

public class MySimpleXMLMapperGenerator extends SimpleXMLMapperGenerator {

	public MySimpleXMLMapperGenerator() {
		super();
	}

	@Override
	protected XmlElement getSqlMapElement() {
		FullyQualifiedTable table = introspectedTable.getFullyQualifiedTable();
		progressCallback.startTask(getString("Progress.12", table.toString())); //$NON-NLS-1$
		XmlElement answer = new XmlElement("mapper"); //$NON-NLS-1$
		String namespace = introspectedTable.getMyBatis3SqlMapNamespace();
		answer.addAttribute(new Attribute("namespace", //$NON-NLS-1$
				namespace));

		context.getCommentGenerator().addRootComment(answer);

		addResultMapElement(answer);
		addDeleteByPrimaryKeyElement(answer);
		addInsertElement(answer);
		addUpdateByPrimaryKeyElement(answer);
		addSelectByPrimaryKeyElement(answer);
		addSelectAllElement(answer);

		return answer;
	}

}
