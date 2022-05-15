package com.nasa.sonda.model;

import org.apache.commons.lang3.StringUtils;

import com.nasa.sonda.exceptions.BusinessException;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Terrain {
	private int limitX;
	
	private int limitY;
	
	public Terrain(String header) throws BusinessException {
		if (header.split(" ").length != 2) {
			throw new BusinessException("invalid.header.file");
		}
		
		if (!StringUtils.isNumericSpace(header)) {
			throw new BusinessException("invalid.header.file");
		}

		this.limitX = Integer.parseInt(header.split(" ")[0]);
		this.limitY = Integer.parseInt(header.split(" ")[1]);
	}
}
