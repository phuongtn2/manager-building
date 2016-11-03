package com.building.services.interceptor;

import java.text.SimpleDateFormat;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@Provider
@Produces(MediaType.APPLICATION_JSON)
public class JsonObjectMapperConfig implements ContextResolver<ObjectMapper> {
	private final ObjectMapper objectMapper;

	public JsonObjectMapperConfig() {
		objectMapper = new ObjectMapper();
		objectMapper.setDateFormat(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss")); //日付形式のカスタム化
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false); // JSON deserialization時のプロパティ非存在の無視
		objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL); // null なフィールドを無視させる設定をする
	}

	@Override
	public ObjectMapper getContext(Class<?> type) {
		return objectMapper;
	}
}
