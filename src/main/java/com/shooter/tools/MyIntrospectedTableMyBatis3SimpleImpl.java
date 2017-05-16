package com.shooter.tools;

import static org.mybatis.generator.internal.util.StringUtility.stringHasValue;

import java.util.List;

import org.mybatis.generator.api.ProgressCallback;
import org.mybatis.generator.codegen.AbstractJavaClientGenerator;
import org.mybatis.generator.codegen.mybatis3.IntrospectedTableMyBatis3SimpleImpl;
import org.mybatis.generator.codegen.mybatis3.javamapper.SimpleAnnotatedClientGenerator;
import org.mybatis.generator.internal.ObjectFactory;

public class MyIntrospectedTableMyBatis3SimpleImpl extends IntrospectedTableMyBatis3SimpleImpl {

	@Override
	protected void calculateXmlMapperGenerator(AbstractJavaClientGenerator javaClientGenerator, List<String> warnings,
			ProgressCallback progressCallback) {
		if (javaClientGenerator == null) {
			if (context.getSqlMapGeneratorConfiguration() != null) {
				xmlMapperGenerator = new MySimpleXMLMapperGenerator();
			}
		} else {
			xmlMapperGenerator = javaClientGenerator.getMatchedXMLGenerator();
		}

		initializeAbstractGenerator(xmlMapperGenerator, warnings, progressCallback);
	}

	@Override
	protected AbstractJavaClientGenerator createJavaClientGenerator() {
		if (context.getJavaClientGeneratorConfiguration() == null) {
			return null;
		}

		String type = context.getJavaClientGeneratorConfiguration().getConfigurationType();

		AbstractJavaClientGenerator javaGenerator;
		if ("XMLMAPPER".equalsIgnoreCase(type)) { //$NON-NLS-1$
			javaGenerator = new MySimpleJavaClientGenerator();
		} else if ("ANNOTATEDMAPPER".equalsIgnoreCase(type)) { //$NON-NLS-1$
			javaGenerator = new SimpleAnnotatedClientGenerator();
		} else if ("MAPPER".equalsIgnoreCase(type)) { //$NON-NLS-1$
			javaGenerator = new MySimpleJavaClientGenerator();
		} else {
			javaGenerator = (AbstractJavaClientGenerator) ObjectFactory.createInternalObject(type);
		}

		return javaGenerator;
	}

	@Override
	protected void calculateJavaClientAttributes() {
		if (context.getJavaClientGeneratorConfiguration() == null) {
			return;
		}

		StringBuilder sb = new StringBuilder();
		sb.append(calculateJavaClientImplementationPackage());
		sb.append('.');
		sb.append(fullyQualifiedTable.getDomainObjectName());
		sb.append("DaoImpl"); //$NON-NLS-1$
		setDAOImplementationType(sb.toString());

		sb.setLength(0);
		sb.append(calculateJavaClientInterfacePackage());
		sb.append('.');
		sb.append(fullyQualifiedTable.getDomainObjectName());
		sb.append("Dao"); //$NON-NLS-1$
		setDAOInterfaceType(sb.toString());

		sb.setLength(0);
		sb.append(calculateJavaClientInterfacePackage());
		sb.append('.');
		if (stringHasValue(tableConfiguration.getMapperName())) {
			sb.append(tableConfiguration.getMapperName());
		} else {
			sb.append(fullyQualifiedTable.getDomainObjectName());
			// sb.append("Mapper"); //$NON-NLS-1$
			sb.append("Dao"); //$NON-NLS-1$
		}
		setMyBatis3JavaMapperType(sb.toString());

		sb.setLength(0);
		sb.append(calculateJavaClientInterfacePackage());
		sb.append('.');
		if (stringHasValue(tableConfiguration.getSqlProviderName())) {
			sb.append(tableConfiguration.getSqlProviderName());
		} else {
			sb.append(fullyQualifiedTable.getDomainObjectName());
			sb.append("SqlProvider"); //$NON-NLS-1$
		}
		setMyBatis3SqlProviderType(sb.toString());
	}

	@Override
	protected String calculateMyBatis3XmlMapperFileName() {
		StringBuilder sb = new StringBuilder();
		if (stringHasValue(tableConfiguration.getMapperName())) {
			String mapperName = tableConfiguration.getMapperName();
			int ind = mapperName.lastIndexOf('.');
			if (ind == -1) {
				sb.append(mapperName);
			} else {
				sb.append(mapperName.substring(ind + 1));
			}
			sb.append(".xml"); //$NON-NLS-1$
		} else {
			sb.append(fullyQualifiedTable.getDomainObjectName());
			sb.append(".xml"); //$NON-NLS-1$
		}
		return sb.toString();
	}

}
