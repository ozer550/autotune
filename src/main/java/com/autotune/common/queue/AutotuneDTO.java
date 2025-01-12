/*******************************************************************************
 * Copyright (c) 2020, 2021 Red Hat, IBM Corporation and others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.autotune.common.queue;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.autotune.common.data.datasource.DataSourceFactory;
import com.autotune.utils.AutotuneUtils;

/**
 * AutotuneDTO is a data traversing object, it used to transfer data between different autotune components.
 * @author bipkumar
 *
 */

public class AutotuneDTO implements Serializable {
	private static final long serialVersionUID = 8789442223058487193L;
	private int id;
	private String name;
	private String url;
	private String operation;
	private StringBuffer infoMessage;
	private StringBuffer errorMessage;
	private static final Logger LOGGER = LoggerFactory.getLogger(DataSourceFactory.class);

	public AutotuneDTO() {}

	/**
	 *
	 * @param experimentId : Id generated by Dependency analyzer
	 * @param componentName: Name of the component processing this DTO
	 * @param dataURL: fetch the data(JSON)from recommendation manager using this url
	 * @param operation : set operation name using Operation enum from AutotuneUtil.java
	 *
	 */
	public AutotuneDTO(int experimentId, String componentName, String dataURL, String operation) {
		this.id = experimentId;
		this.name = componentName;
		this.url = dataURL;
		this.infoMessage = new StringBuffer();
		this.errorMessage = new StringBuffer();
		this.operation = operation;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		if (! AutotuneUtils.isValidURL(url)) {
			errorMessage.append("\n URL is not valid or empty");
			LOGGER.error("URL is not valid");
		}
		this.url = url;
	}

	public StringBuffer getInfoMessage() {
		return infoMessage;
	}

	public void setInfoMessage(StringBuffer infoMessage) {
		this.infoMessage = infoMessage;
	}

	public StringBuffer getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(StringBuffer errorMessage) {
		this.errorMessage = errorMessage;
	}


	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}


	@Override
	public String toString() {
		return "id=" + id + ", name=" + name +  ", url=" + url + " , operation=" + operation + ", infoMessage="+infoMessage.toString() + ", errorMessage=" +errorMessage;
	}
}
