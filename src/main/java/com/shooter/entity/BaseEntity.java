package com.shooter.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@RequiredArgsConstructor
@ToString
public abstract class BaseEntity implements Serializable {

	private static final long serialVersionUID = -1733999490201200475L;
	@Getter
	@Setter
	protected Date createTime;
	@Getter
	@Setter
	protected Date modifyTime;

}
