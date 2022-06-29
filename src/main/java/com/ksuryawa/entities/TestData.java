package com.ksuryawa.entities;

import com.creditdatamw.zerocell.annotation.Column;
import com.ksuryawa.converters.zerocell.StringToBooleanConverter;
import com.ksuryawa.converters.zerocell.StringToBrowserTypeConverter;
import com.ksuryawa.enums.BrowserType;
import lombok.Data;
import lombok.Getter;

/**
 * @author Kapil Suryawanshi
 * 27/06/2022
 */
@Data
@Getter

public class TestData {
	@Column(name = "testCaseName",index = 0)
	private String testCaseName;
	@Column(name = "execute",index = 1,converterClass = StringToBooleanConverter.class)
	private Boolean execute;
	@Column(name="browser",index = 2,converterClass = StringToBrowserTypeConverter.class)
	private BrowserType browser;
	@Column(name="username",index = 3)
	private String username;
	@Column(name="password",index = 4)
	private String password;

}