package org.benetech.util;

import org.benetech.constants.GeneralConsts;
import org.opendatakit.aggregate.odktables.rest.entity.PrivilegesInfo;
import org.springframework.security.core.Authentication;

import java.util.Map;

public class UserUtils {

  public static String idToUsername(String id) {
    String username = id;
    if (id.startsWith(GeneralConsts.USERNAME_COLON)) {
      username = id.substring(GeneralConsts.USERNAME_COLON.length());
    }
    return username;
  }
  
  public static String usernameToId(String username) {
    if (!username.equals("anonymous")) {
      return (GeneralConsts.USERNAME_COLON + username);
    }
    return username;
  }

  @SuppressWarnings("unchecked")
  public static Map<String, Object> getUserDetail(Authentication authentication) {
    return (Map<String, Object>) authentication.getDetails();
  }

  public static PrivilegesInfo getPrivilegesInfo(Authentication authentication) {
    return (PrivilegesInfo) getUserDetail(authentication).get(GeneralConsts.PRIVILEGES_INFO);
  }

  public static String getDefaultGroup(Authentication authentication) {
    return getPrivilegesInfo(authentication).getDefaultGroup();
  }

  public static String getFullName(Authentication authentication) {
    return getPrivilegesInfo(authentication).getFull_name();
  }
}
