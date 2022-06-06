package com.mng.mycoin.aop;

import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.DatatypeConverter;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.mng.mycoin.annotation.TokenRequired;
import com.mng.mycoin.service.impl.ISecurityService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Component
@Aspect
public class SecurityAop {

	@Before("@annotation(tokenRequired)")
	public void authWithToken(TokenRequired tokenRequired) throws Throwable {
		ServletRequestAttributes reqAttributes = (ServletRequestAttributes) RequestContextHolder
				.currentRequestAttributes();
		HttpServletRequest request = reqAttributes.getRequest();

		// checks for token in request header
		String tokenInHeader = request.getHeader("token");
		if (StringUtils.isEmpty(tokenInHeader)) {
			throw new IllegalArgumentException("Empty token");
		}

		Claims claims = Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(ISecurityService.secretKey))
				.parseClaimsJws(tokenInHeader).getBody();

		if (claims == null || claims.getSubject() == null) {
			throw new IllegalArgumentException("Token Error : Claim is null");
		}

		System.out.println("토큰에 포함된 subject로 자체 인증처리 필요..");
	}
}