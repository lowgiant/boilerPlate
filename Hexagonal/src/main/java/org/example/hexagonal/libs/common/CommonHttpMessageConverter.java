package org.example.hexagonal.libs.common;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CommonHttpMessageConverter extends
	AbstractHttpMessageConverter<ApiResponse<Object>> {
	private final ObjectMapper objectMapper;

	public CommonHttpMessageConverter(ObjectMapper objectMapper) {
		this.objectMapper = objectMapper;
	}

	@Override
	public List<MediaType> getSupportedMediaTypes() {
		return Collections.singletonList(MediaType.APPLICATION_JSON);
	}

	@Override
	protected boolean supports(Class<?> clazz) {
		return clazz.equals(String.class);
	}

	@Override
	protected ApiResponse<Object> readInternal(Class<? extends ApiResponse<Object>> clazz, HttpInputMessage inputMessage)
		throws IOException, HttpMessageNotReadableException {
		throw new UnsupportedOperationException("This converter can only support writing operation.");
	}

	@Override
	protected void writeInternal(ApiResponse<Object> resultMessage, HttpOutputMessage outputMessage)
		throws IOException, HttpMessageNotWritableException {
		String responseMessage = this.objectMapper.writeValueAsString(resultMessage);
		StreamUtils.copy(responseMessage.getBytes(StandardCharsets.UTF_8), outputMessage.getBody());
	}
}
