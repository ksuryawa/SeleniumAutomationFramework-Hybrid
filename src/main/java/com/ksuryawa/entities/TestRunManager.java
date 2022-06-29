package com.ksuryawa.entities;


import com.creditdatamw.zerocell.annotation.Column;
import com.creditdatamw.zerocell.annotation.ZerocellReaderBuilder;
import com.ksuryawa.converters.zerocell.StringToBooleanConverter;
import com.ksuryawa.converters.zerocell.StringToIntegerConverter;
import lombok.Data;
import lombok.Getter;

/**
 * @author Kapil Suryawanshi
 * 28/06/2022
 */
@Getter
@Data
@ZerocellReaderBuilder
public class TestRunManager {

	@Column(name = "testCaseName",index = 0)
	private String testCaseName;

	@Column(name = "testDescription",index = 1)
	private String testDescription;

	@Column(name = "execute",index = 2,converterClass = StringToBooleanConverter.class)
	private Boolean execute;

	@Column(name = "priority" ,index = 3, converterClass = StringToIntegerConverter.class)
	private Integer priority;

	@Column(name = "count" ,index = 4, converterClass= StringToIntegerConverter.class)
	private Integer count;

}