package com.building.util;

import phuongtn2.dto.AuthorizedUserInfo;
import phuongtn2.rest.ApiDefs;
import phuongtn2.service.Role;
import phuongtn2.service.error.ServiceException;

import javax.servlet.http.HttpServletRequest;

public class AuthorizeUtil {
	/**
	 * Get the stored authenticated information.
	 * @param req Request information.
	 * @return Stored authenticated information.
	 */
	public static AuthorizedUserInfo getAuthorizedUserInfo(HttpServletRequest req) {
		return (AuthorizedUserInfo) req.getAttribute(ApiDefs.AUTH_PROP_NAME);// Authenticated information
	}

	public static AuthorizedUserInfo requireAuthorizedUserInfo(HttpServletRequest req) throws ServiceException {
		final AuthorizedUserInfo aui = getAuthorizedUserInfo(req);
		if (aui == null) {
			throw new ServiceException("requireAuth");
		} else {
			if (! aui.getRoleSet().contains(Role.LOGIN)) {
				throw new ServiceException("requireLoginRole", aui.getLoginName(), aui.getUserId());
			}
			return aui;
		}
	}
}
