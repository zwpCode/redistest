package com.redis.redistest.authrealm;

import com.redis.redistest.user.entity.Permission;
import com.redis.redistest.user.entity.Role;
import com.redis.redistest.user.entity.User;
import com.redis.redistest.user.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class AuthRealm extends AuthorizingRealm{

    @Resource
    private UserService userService;

    /**
     * 授权使用
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        User user = (User) principalCollection.fromRealm(this.getClass().getName()).iterator().next();
        List<String> permissionList = new ArrayList<>();
        List<String> roleNameList = new ArrayList<>();
        Set<Role> roleSet = user.getRoles();
        if(!CollectionUtils.isEmpty(roleSet)){
            for (Role role : roleSet){
                roleNameList.add(role.getRname());
                Set<Permission> permissionSet = role.getPermissions();
                if (!CollectionUtils.isEmpty(permissionSet)) {
                    for (Permission permission : permissionSet) {
                        permissionList.add(permission.getName());
                    }
                }
            }

        }
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addStringPermissions(permissionList);
        info.addRoles(roleNameList);
        return info;
    }

    /**
     * 登录使用
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;

        String username = usernamePasswordToken.getUsername();

        User user = userService.findByUsername(username);

        return new SimpleAuthenticationInfo(user, user.getPassword(), this.getClass().getName());
    }
}
