package com.shooter.tools;

import static org.mybatis.generator.internal.util.StringUtility.stringHasValue;

import org.mybatis.generator.codegen.mybatis3.IntrospectedTableMyBatis3SimpleImpl;

public class MyIntrospectedTableMyBatis3SimpleImpl extends IntrospectedTableMyBatis3SimpleImpl {

	@Override
	protected void calculateJavaClientAttributes() {
		if (context.getJavaClientGeneratorConfiguration() == null) {
			return;
		}

		StringBuilder sb = new StringBuilder();
		sb.append(calculateJavaClientImplementationPackage());
		sb.append('.');
		sb.append(fullyQualifiedTable.getDomainObjectName());
		sb.append("DAOImpl"); //$NON-NLS-1$
		setDAOImplementationType(sb.toString());

		sb.setLength(0);
		sb.append(calculateJavaClientInterfacePackage());
		sb.append('.');
		sb.append(fullyQualifiedTable.getDomainObjectName());
		sb.append("DAO"); //$NON-NLS-1$
		setDAOInterfaceType(sb.toString());

		sb.setLength(0);
		sb.append(calculateJavaClientInterfacePackage());
		sb.append('.');
		if (stringHasValue(tableConfiguration.getMapperName())) {
			sb.append(tableConfiguration.getMapperName());
		} else {
			sb.append(fullyQualifiedTable.getDomainObjectName());
			// sb.append("Mapper"); //$NON-NLS-1$
			sb.append("DAO"); //$NON-NLS-1$
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

}
